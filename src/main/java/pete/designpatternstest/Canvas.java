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

public class Canvas extends JPanel{
    
    private Sprite bluePlane;
    private boolean isStop = false;
    
    static{ 
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane.png"));       
    }
    
    public Canvas(){    
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        bluePlane = new BluePlane(120, 250);
        
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();                   
                if(keyCode == KeyEvent.VK_UP){
                    bluePlane.move(0, -12);
                }else if(keyCode == KeyEvent.VK_DOWN){
                    bluePlane.move(0, 12);
                }else if(keyCode == KeyEvent.VK_RIGHT){
                    bluePlane.move(12, 0);
                }else if(keyCode == KeyEvent.VK_LEFT){
                    bluePlane.move(-12, 0);
                }
                if(isStop){
                    return;
                }
                Canvas.this.repaint();
            }
        });
        
        MouseListener popupListener = new PopupListener();
        this.addMouseListener(popupListener);        
    }
    
    class PopupListener extends MouseAdapter{
    
        public void mouseReleased(MouseEvent e){
            if(e.isPopupTrigger()){
                JPopupMenu popupMenu = new JPopupMenu();
                JMenu fileMenu = new JMenu("Game");
                JMenuItem newFile = new JMenuItem("New");
                JMenuItem stopFile = new JMenuItem("Stop");
                JMenuItem resumeFile = new JMenuItem("Resume");
                fileMenu.add(newFile);
                fileMenu.add(stopFile);
                fileMenu.add(resumeFile);
                popupMenu.add(fileMenu);
                popupMenu.addSeparator();
                JMenuItem exitFile = new JMenuItem("Exit");
                popupMenu.add(exitFile);
                popupMenu.show(e.getComponent(), e.getX(), e.getY());

                stopFile.setActionCommand("Stop");
                stopFile.addActionListener(menuActionListener);
                resumeFile.setActionCommand("Resume");
                resumeFile.addActionListener(menuActionListener);
                exitFile.setActionCommand("Exit");
                exitFile.addActionListener(menuActionListener);                      
            }        
        }    
    }

    private ActionListener menuActionListener = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String action = e.getActionCommand();
            if("Stop".equals(action)){
                isStop = true;
            }else if("Resume".equals(action)){
                isStop = false;
            }else if("Exit".equals(action)){
                System.exit(0);
            }
        }
    };

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bluePlane.draw(g);
    }    
}
    

