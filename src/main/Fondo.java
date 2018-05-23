/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author victor
 */
public class Fondo extends JFrame implements ActionListener {

    private boolean flag;
    private JLabel lblBola, lblBarrera, lblBarrera2;
    private ArrayList<JLabel> alBarreras;
    private Timer tmrMovimiento;
    private ImageIcon imagen;
    private int tiempo = 15, bolaY = 400, barreraX = 700;

    public Fondo() {
        super("BeatBall");
        this.setLayout(null);
        this.setBackground(Color.cyan);

        ImageIcon imagen = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\imagenes\\columna.png");
        alBarreras=new ArrayList();
        
        //-----------------------------
        
        lblBarrera = new JLabel(imagen);
        lblBarrera.setSize(50, 200);
        lblBarrera.setLocation(barreraX, 100);
        this.add(lblBarrera);
        
        //----------------------------
        
        lblBarrera2 = new JLabel(imagen);
        lblBarrera2.setSize(50, 300);
        lblBarrera2.setLocation(barreraX, 400);
        this.add(lblBarrera2);
        
        
        //asdfddfassdf
        
        lblBola = new JLabel("O.O");
        lblBola.setSize(30, 10);
        lblBola.setLocation(50, bolaY);
        lblBola.setVisible(true);
        this.add(lblBola);

        tmrMovimiento = new Timer(tiempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                barreraX = barreraX - 5;
                 lblBarrera.setLocation(barreraX, 100);
                 lblBarrera2.setLocation(barreraX, 400);
                 
                if (flag) {
                    bolaY = bolaY - 5;
                    lblBola.setLocation(50, bolaY);
                    if (bolaY == 100) {
                        bolaY = 105;
                    }
                }
                if (!flag) {
                    bolaY = bolaY + 5;
                    lblBola.setLocation(50, bolaY);
                    if (bolaY == 600) {
                        bolaY = 595;
                    }
                }
            }
        });
        tmrMovimiento.start();

        this.getContentPane().addKeyListener(new KeyHelper());
        this.getContentPane().addMouseListener(new MouseHelper());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    public class MouseHelper extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            flag = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            flag = false;
        }
    }

    public class KeyHelper extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }
}
