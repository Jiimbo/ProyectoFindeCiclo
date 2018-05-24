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
    private JLabel lblBola, lblBarrera, lblBarrera2,lblSuelo,lblCielo;
    private ArrayList<JLabel> alBarreras, alBarreras2;
    private Timer tmrMovimiento;
    private int bolaY = 400, cont = 0, randSizeY, randLocY;

    public Fondo() {
        super("BeatBall");
        this.setLayout(null);

       
        ImageIcon imgCielo = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\imagenes\\cielo.png");
        ImageIcon imgSuelo = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\imagenes\\suelo.png");
        ImageIcon imgBarrera = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\imagenes\\columna.png");
        ImageIcon imgFondo = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\imagenes\\fondo.gif");
        ImageIcon imgAvion = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\imagenes\\avion.png");
        ImageIcon imgSube = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\imagenes\\avionsube.png");
        ImageIcon imgBaja = new ImageIcon("C:\\Users\\Victor\\Documents\\Proyectos\\ProyectoFindeCiclo\\imagenes\\avionbaja.png");
        
        ;
        alBarreras = new ArrayList();
        alBarreras2 = new ArrayList();

        //PAJARO
        lblBola = new JLabel(imgAvion);
        lblBola.setSize(100, 90);
        lblBola.setLocation(50, bolaY);
        lblBola.setVisible(true);
        this.add(lblBola);
        
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
                    //MAXIMO 200 DE Y.SIZE
                    lblBarrera.setSize(50, randSizeY);
                    lblBarrera.setLocation(900, 100);
                    alBarreras.add(lblBarrera);

                    lblBarrera2 = new JLabel(imgBarrera);
                    lblBarrera2.setSize(50, (800));
                    //MAXIMO 600 DE LOCATION
                    lblBarrera2.setLocation(900, randLocY);
                    alBarreras2.add(lblBarrera2);

                    //NO HACE FALTA INDEX PORQUE HACE REFERENCIA A SU PROPIA POSICION DE MEMORIA
                    Fondo.this.add(lblBarrera);
                    Fondo.this.add(lblBarrera2);

                }
                System.err.println("CONTADOR = " + cont);
                System.err.println("SIZE Y= " + randSizeY);
                System.err.println("LOCAT Y= " + randLocY);
                cont++;
                for (JLabel barrera : alBarreras) {
                    barrera.setLocation(barrera.getX() - 5, 100);
                }
                for (JLabel barrera : alBarreras2) {
                    barrera.setLocation(barrera.getX() - 5, barrera.getY());
                }

                if (flag) {
                    lblBola.setIcon(imgSube);
                    lblBola.setLocation(50, lblBola.getY() - 5);
                    if (lblBola.getY() == 100) {
                        lblBola.setIcon(imgAvion);
                        lblBola.setLocation(50, lblBola.getY() + 5);
                    }
                }
                if (!flag) {
                    lblBola.setIcon(imgBaja);
                    lblBola.setLocation(50, lblBola.getY() + 5);
                    if (lblBola.getY() == 600) {
                        lblBola.setIcon(imgAvion);
                        lblBola.setLocation(50, lblBola.getY() - 5);
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
