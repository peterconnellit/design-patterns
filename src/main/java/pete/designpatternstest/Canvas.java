/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author peter
 */
public class Canvas extends JPanel implements Runnable {

    private boolean isRun = true;
    private boolean isInit = false;
    private int canvasWidth;
    private int canvasHeight;
    private TiledLayer mapLayer;
    private MapContext mapContext;
    private int screenY;
    private BluePlane bluePlane;
    private EnemyPlane enemyPlane;
    private PlaneLife planeLife;
    private PlaneScore planeScore;
    private Mediator mediator;
    private boolean explosionVisible = false;
    private final Object pauseLock = new Object();
    private volatile boolean isPaused = false;

    static {
        BufferedImage mapImage = ImageUtil.loadImage("images/grass.png");
        ImageCache.put("mapImage", mapImage);
        BufferedImage map2Image = ImageUtil.loadImage("images/space.png");
        ImageCache.put("map2Image", map2Image);

        ImageCache.put("redBulletImage", ImageUtil.loadImage("images/red_bullet.png"));
        ImageCache.put("enemyPlaneImage", ImageUtil.loadImage("images/enemy_plane.png"));
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane1.png"));
        ImageCache.put("bluePlaneLifeImage", ImageUtil.loadImage("images/blue_plane_small.png"));
        ImageCache.put("explosionImage", ImageUtil.loadImage("images/explosion.png"));
    }

    public Canvas() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);
    }

    private void init() {
        mapContext = new MapContext();
        mapContext.addMap(new MapLayer(this.canvasWidth, this.canvasHeight));
        mapContext.addMap(new Map2Layer(this.canvasWidth, this.canvasHeight));
        mapLayer = mapContext.next();
        screenY = -this.canvasHeight;

        enemyPlane = new EnemyPlane(120, 0);
        enemyPlane.setVisible(true);

        bluePlane = new BluePlane(0, 0);
        bluePlane.setX(this.canvasWidth / 2 - bluePlane.getWidth() / 2);
        bluePlane.setY(this.canvasHeight - bluePlane.getHeight() - 30);
        bluePlane.loadBullet(new RedBullet(-100, -100));
        bluePlane.setVisible(true);

        planeLife = new PlaneLife(0, 0, canvasWidth, canvasHeight);
        bluePlane.registerObserver(planeLife);

        planeScore = new PlaneScore(0, 0, canvasWidth, canvasHeight);
        bluePlane.registerObserver(planeScore);

        mediator = new MediatorImpl();

        new Thread(this).start();

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    bluePlane.move(0, -6);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    bluePlane.move(0, 6);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    bluePlane.move(6, 0);
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    bluePlane.move(-6, 0);
                } else if (keyCode == KeyEvent.VK_ENTER) {
                    bluePlane.fireBullet();
                }

            }
        });

        MouseListener popupListener = new PopupListener();
        this.addMouseListener(popupListener);

    }

    class PopupListener extends MouseAdapter {

        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                JPopupMenu popupMenu = new JPopupMenu();
                JMenu fileMenu = new JMenu("Game");
                JMenuItem stopFile = new JMenuItem("Pause");
                JMenuItem resumeFile = new JMenuItem("Resume");
                fileMenu.add(stopFile);
                fileMenu.add(resumeFile);
                popupMenu.add(fileMenu);
                popupMenu.addSeparator();
                JMenuItem exitFile = new JMenuItem("Exit");
                popupMenu.add(exitFile);
                popupMenu.show(e.getComponent(), e.getX(), e.getY());

                stopFile.setActionCommand("Pause");
                stopFile.addActionListener(menuActionListener);
                resumeFile.setActionCommand("Resume");
                resumeFile.addActionListener(menuActionListener);
                exitFile.setActionCommand("Exit");
                exitFile.addActionListener(menuActionListener);
            }
        }
    }

    ActionListener menuActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Pause")) {
                pause();
            } else if (command.equals("Resume")) {
                resume();
            } else if (command.equals("Exit")) {
                System.exit(0);
            }
        }
    };

    protected void paintComponent(Graphics g) {
        this.canvasWidth = this.getWidth();
        this.canvasHeight = this.getHeight();

        if (!isInit) {
            init();
            isInit = true;
        }
        super.paintComponent(g);
        collideCheck(g);
        drawMap(g);
        bluePlane.draw(g);
        bluePlane.getBullet().draw(g);
        enemyPlane.draw(g);
        planeLife.draw(g);
        planeScore.draw(g);
        if (explosionVisible) {
            mediator.handle(g, enemyPlane.getX(), enemyPlane.getY());
        }
    }

    private void collideCheck(Graphics g) {
        if (bluePlane.getBullet().collideWith(enemyPlane)) {
            enemyPlane.setVisible(false);
            bluePlane.getBullet().setVisible(false);

            ObserverData data = new ObserverData();
            data.setNotifyType(NotifyType.INCREMENT_SCORE);
            data.setScore(100);
            bluePlane.notifyAll(data);

            explosionVisible = true;
        }

        if (bluePlane.collideWith(enemyPlane)) {
            enemyPlane.setVisible(false);
            bluePlane.setVisible(false);

            ObserverData data = new ObserverData();
            data.setNotifyType(NotifyType.PLANE_DESTROY);
            bluePlane.notifyAll(data);

            bluePlane.setX(this.canvasWidth / 2 - bluePlane.getWidth() / 2);
            bluePlane.setY(this.canvasHeight - bluePlane.getHeight() - 30);

            explosionVisible = true;
        }

    }

    public void drawMap(Graphics g) {
        mapLayer.setViewPort(0, screenY);
        mapLayer.draw(g);
        if (screenY <= 0) {
            screenY++;
        }
        if (screenY >= 0) {
            screenY = -this.canvasHeight;
            mapLayer = mapContext.next();
        }
    }

    @Override
    public void run() {
        while (isRun) {
            try {
                synchronized (pauseLock) {
                    while (isPaused) {
                        pauseLock.wait();
                    }
                }
                enemyPlane.move(0, 2);
                explosionVisible = false;
                bluePlane.moveBullet();
                Thread.sleep(80);
                Canvas.this.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        synchronized (pauseLock) {
            isPaused = false;
            pauseLock.notifyAll();
        }
    }
}
