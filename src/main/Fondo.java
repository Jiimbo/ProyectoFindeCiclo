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
    private JLabel lblAvion, lblBarrera, lblBarrera2,lblSuelo,lblCielo;
    private ArrayList<JLabel> alBarreras, alBarreras2;
    private Timer tmrMovimiento;
    private int bolaY = 400, cont = 0, randSizeY, randLocY;

    public Fondo() {
        super("BeatBall");
        this.setLayout(null);

       
        ImageIcon imgCielo = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\src\\imagenes\\cielo.png");
        ImageIcon imgSuelo = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\src\\imagenes\\suelo.png");
        ImageIcon imgBarrera = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\src\\imagenes\\columna.png");
        ImageIcon imgFondo = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\src\\imagenes\\fondo.gif");
        ImageIcon imgAvion = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\src\\imagenes\\avion.png");
        ImageIcon imgSube = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\src\\imagenes\\avionsube.png");
        ImageIcon imgBaja = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\src\\imagenes\\avionbaja.png");
        ImageIcon imgExplosion = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\src\\imagenes\\explosion.png");
        
        ;
        alBarreras = new ArrayList();
        alBarreras2 = new ArrayList();

        //PAJARO
        lblAvion = new JLabel(imgAvion);
        lblAvion.setSize(100, 90);
        lblAvion.setLocation(50, bolaY);
        lblAvion.setVisible(true);
        this.add(lblAvion);
        
        //SUELO
        lblSuelo=new JLabel(imgSuelo);
        lblSuelo.setSize(900, 400);
        lblSuelo.setLocation(0, 650);
        lblSuelo.setVisible(true);
        this.add(lblSuelo);
        //CIELO
        lblCielo=new JLabel(imgCielo);
        lblCielo.setSize(900, 100);
        lblCielo.setLocation(0, 0);
        lblCielo.setVisible(true);
        this.add(lblCielo);
        
        
        tmrMovimiento = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (cont == 0 || (cont % 80 == 0)) {

                    randSizeY = (int) (Math.random() * 480 + 1);
                    randLocY = randSizeY + 200;

                    lblBarrera = new JLabel(imgBarrera);
                    lblBarrera.setSize(50, randSizeY);
                    lblBarrera.setLocation(900, 100);
                    alBarreras.add(lblBarrera);

                    lblBarrera2 = new JLabel(imgBarrera);
                    lblBarrera2.setSize(50, (800));
                    lblBarrera2.setLocation(900, randLocY);
                    alBarreras2.add(lblBarrera2);

                    //NO HACE FALTA INDEX PORQUE HACE REFERENCIA A SU PROPIA POSICION DE MEMORIA
                    Fondo.this.add(lblBarrera);
                    Fondo.this.add(lblBarrera2);

                }
                
                cont++;
                for (JLabel barrera : alBarreras) {
                    barrera.setLocation(barrera.getX() - 5, 100);
                }
                for (JLabel barrera : alBarreras2) {
                    barrera.setLocation(barrera.getX() - 5, barrera.getY());
                }

                if (flag) {
                    lblAvion.setIcon(imgSube);
                    lblAvion.setLocation(50, lblAvion.getY() - 5);
                    if (lblAvion.getY() == 100) {
                        lblAvion.setIcon(imgAvion);
                        lblAvion.setLocation(50, lblAvion.getY() + 5);
                    }
                }
                if (!flag) {
                    lblAvion.setIcon(imgBaja);
                    lblAvion.setLocation(50, lblAvion.getY() + 5);
                    if (lblAvion.getY() == 600) {
                        lblAvion.setIcon(imgAvion);
                        lblAvion.setLocation(50, lblAvion.getY() - 5);
                    }
                    System.err.println("AVION   "+lblAvion.getBounds());
                    System.err.println("BARRERA   "+lblBarrera.getBounds());
                    System.err.println("BARRERA22    "+lblBarrera2.getBounds());
                }
                if ((lblAvion.getX()==(lblBarrera2.getX()/100))||(lblAvion.getY()==lblBarrera2.getY())) {
                   lblAvion.setIcon(imgExplosion);
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
