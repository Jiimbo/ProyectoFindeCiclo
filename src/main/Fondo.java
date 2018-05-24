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
    private ArrayList<JLabel> alBarreras, alBarreras2;
    private Timer tmrMovimiento;
    private ImageIcon imagen;
    private int tiempo = 15, bolaY = 400, barreraMov = 700, index=0,cont = 0;

    public Fondo() {
        super("BeatBall");
        this.setLayout(null);

        ImageIcon imagen = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\imagenes\\columna.png");
        alBarreras = new ArrayList();
        alBarreras2 = new ArrayList();

//        lblBarrera = new JLabel(imagen);
//        //MAXIMO 200 DE Y.SIZE
//        lblBarrera.setSize(50, (int) (200));
//        lblBarrera.setLocation(barreraX, 100);
//        alBarreras.add(lblBarrera);
//
//        lblBarrera2 = new JLabel(imagen);
//        //MAXIMO 200 DE Y.SIZE
//        lblBarrera2.setSize(50, (int) (200));
//        lblBarrera2.setLocation(barreraX, 400);
//        alBarreras2.add(lblBarrera2);
//
//        Fondo.this.add(alBarreras.get(cont));
//        Fondo.this.add(alBarreras2.get(cont));
        //asdfddfassdf
        lblBola = new JLabel("O.O");
        lblBola.setSize(30, 10);
        lblBola.setLocation(50, bolaY);
        lblBola.setVisible(true);
        this.add(lblBola);

        tmrMovimiento = new Timer(tiempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (cont == 0 || (cont % 50 == 0)) {
                    lblBarrera = new JLabel(imagen);
                    //MAXIMO 200 DE Y.SIZE
                    lblBarrera.setSize(50, (int) (200));
                    lblBarrera.setLocation(700, 100);
                    alBarreras.add(lblBarrera);

                    lblBarrera2 = new JLabel(imagen);
                    //MAXIMO 200 DE Y.SIZE
                    lblBarrera2.setSize(50, (int) (200));
                    lblBarrera2.setLocation(700, 400);
                    alBarreras2.add( lblBarrera2);

                    Fondo.this.add(lblBarrera);
                    Fondo.this.add(lblBarrera2);

//                    if (cont != 0&&cont%50==0) {
//                        index++;
//                    }
                }
                System.err.println("CONTADOR = " + cont);
                System.err.println("INDEX = " + index);
                cont++;
                for (JLabel barrera : alBarreras) {
                    barrera.setLocation(barrera.getX()-5, 100);
                }
                for (JLabel barrera : alBarreras2) {
                    barrera.setLocation(barrera.getX()-5, 400);
                }

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
