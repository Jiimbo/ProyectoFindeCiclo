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
public class Juego extends JDialog implements ActionListener {

    private boolean flagMovimiento, flagColision = true;
    private JLabel lblAvion, lblBarrera, lblBarrera2, lblSuelo, lblCielo, lblFondo, lblContador, lblFinal, lblContinue;
    private JButton btnSi, btnNo;
    private ArrayList<JLabel> alBarreras, alBarreras2;
    private Timer tmrMovimiento;
    private int bolaY = 400, cont = 0, randSizeY, randLocY, record = 0;

    public Juego(Inicio ventanaInicio) {
        super(ventanaInicio,"Airplane Dodge", true);
        this.setLayout(null);
        this.setFocusable(true);

        ImageIcon imgCielo = new ImageIcon(Juego.class.getResource("/main/imagenes/cielo.png"));
        ImageIcon imgSuelo = new ImageIcon(Juego.class.getResource("/main/imagenes/suelo.png"));
        ImageIcon imgBarrera = new ImageIcon(Juego.class.getResource("/main/imagenes/columna.png"));
        ImageIcon imgAvion = new ImageIcon(Juego.class.getResource("/main/imagenes/avion.png"));
        ImageIcon imgSube = new ImageIcon(Juego.class.getResource("/main/imagenes/avionsube.png"));
        ImageIcon imgBaja = new ImageIcon(Juego.class.getResource("/main/imagenes/avionbaja.png"));
        ImageIcon imgExplosion = new ImageIcon(Juego.class.getResource("/main/imagenes/explosion.png"));
        ImageIcon imgFinal = new ImageIcon(Juego.class.getResource("/main/imagenes/gameover.png"));

        alBarreras = new ArrayList();
        alBarreras2 = new ArrayList();
        //PAJARO
        lblAvion = new JLabel(imgAvion);
        lblAvion.setSize(30, 30);
        lblAvion.setLocation(50, bolaY);
        lblAvion.setVisible(true);
        this.add(lblAvion);

        //CONTADOR PUNTUACIÓN
        lblContador = new JLabel("Puntuación : " + Integer.toString(record));
        lblContador.setSize(600, 50);
        lblContador.setLocation(350, 50);
        lblContador.setVisible(true);
        this.add(lblContador);

        //GAME OVER
        lblFinal = new JLabel(imgFinal);
        lblFinal.setSize(500, 300);
        lblFinal.setLocation(150, 200);
        lblFinal.setVisible(false);
        this.add(lblFinal);

        //CONTINUE?
        lblContinue = new JLabel("¿Volver a jugar?");
        lblContinue.setSize(200, 50);
        lblContinue.setLocation(330, 450);
        lblContinue.setVisible(false);
        this.add(lblContinue);

        //BOTON SI
        btnSi = new JButton("Si");
        btnSi.setSize(100, 50);
        btnSi.setLocation(280, 500);
        btnSi.setVisible(false);
        btnSi.addActionListener(this);
        this.add(btnSi);

        //BOTON NO
        btnNo = new JButton("No");
        btnNo.setSize(100, 50);
        btnNo.setLocation(390, 500);
        btnNo.setVisible(false);
        btnNo.addActionListener(this);
        this.add(btnNo);

        //SUELO
        lblSuelo = new JLabel(imgSuelo);
        lblSuelo.setSize(900, 400);
        lblSuelo.setLocation(0, 670);
        lblSuelo.setVisible(true);
        this.add(lblSuelo);
        //CIELO
        lblCielo = new JLabel(imgCielo);
        lblCielo.setSize(900, 100);
        lblCielo.setLocation(0, 0);
        lblCielo.setVisible(true);
        this.add(lblCielo);

        this.getContentPane().addKeyListener(new KeyHelper());
        //FONDO
//        lblFondo = new JLabel(imgFondo);
//        lblFondo.setSize(600, 500);
//        lblFondo.setLocation(0, 0);
//        lblFondo.setVisible(true);
//        this.add(lblFondo);

        tmrMovimiento = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (cont == 0 || (cont % 90 == 0)) {
                    creaBarrera();
                }
                cont++;
                for (JLabel barrera : alBarreras) {
                    barrera.setLocation(barrera.getX() - 5, 100);
                    if (barrera.getX() < 50) {
                        record++;
                        lblContador.setText("Puntuación : " + Integer.toString(record));
                    }
                    if (lblAvion.getBounds().intersects(barrera.getBounds())) {
                        flagColision = false;
                    }

                }
                for (JLabel barrera : alBarreras2) {
                    barrera.setLocation(barrera.getX() - 5, barrera.getY());
                    if (barrera.getX() < 50) {
                        record++;
                        lblContador.setText("Puntuación : " + Integer.toString(record));
                    }
                    if (lblAvion.getBounds().intersects(barrera.getBounds())) {
                        flagColision = false;
                    }
                }

                if (flagMovimiento) {
                    lblAvion.setIcon(imgSube);
                    lblAvion.setLocation(50, lblAvion.getY() - 5);
                    if (lblAvion.getY() == 100) {
                        lblAvion.setIcon(imgAvion);
                        lblAvion.setLocation(50, lblAvion.getY() + 5);
                    }
                }
                if (!flagMovimiento) {
                    lblAvion.setIcon(imgBaja);
                    lblAvion.setLocation(50, lblAvion.getY() + 5);
                    if (lblAvion.getY() == 640) {
                        lblAvion.setIcon(imgAvion);
                        lblAvion.setLocation(50, lblAvion.getY() - 5);
                    }
//                    System.err.println("AVION   " + lblAvion.getBounds());
//                    System.err.println("BARRERA   " + lblBarrera.getBounds());
//                    System.err.println("BARRERA22    " + lblBarrera2.getBounds());
                }
                if (!flagColision) {
                    lblContador.setLocation(335, 420);
                    lblAvion.setIcon(imgExplosion);
                    hazVisible(true);
                    tmrMovimiento.stop();
                }

            }

            public void creaBarrera() {
                randSizeY = (int) (Math.random() * 480 + 1);
                randLocY = randSizeY + 200;

                lblBarrera = new JLabel(imgBarrera);
                lblBarrera.setSize(50, randSizeY);
                lblBarrera.setLocation(900, 100);
//                    lblBarrera.setComponentZOrder(Juego.this.lblBarrera, 0);
                alBarreras.add(lblBarrera);

                lblBarrera2 = new JLabel(imgBarrera);
                lblBarrera2.setSize(50, (800));
                lblBarrera2.setLocation(900, randLocY);
//                    getContentPane().setComponentZOrder(Juego.this.lblBarrera2, 1);
                alBarreras2.add(lblBarrera2);

//NO HACE FALTA INDEX PORQUE HACE REFERENCIA A SU PROPIA POSICION DE MEMORIA
                Juego.this.add(lblBarrera);
                Juego.this.add(lblBarrera2);
                ;
            }
        });
        tmrMovimiento.start();

        this.getContentPane().addKeyListener(new KeyHelper());
        this.getContentPane().addMouseListener(new MouseHelper());
    }

    public void hazVisible(boolean flag) {
        lblFinal.setVisible(flag);
        btnSi.setVisible(flag);
        btnNo.setVisible(flag);
        lblContinue.setVisible(flag);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSi) {
            for (JLabel barrera : alBarreras) {
                barrera.setVisible(false);
            }
            for (JLabel barrera : alBarreras2) {
                barrera.setVisible(false);
            }
            alBarreras.clear();
            alBarreras2.clear();
            hazVisible(false);
            record = 0;
            lblContador.setText("Puntuación : " + Integer.toString(record));
            lblContador.setLocation(350, 50);
            flagColision = true;
            tmrMovimiento.start();
        }
        if (ae.getSource() == btnNo) {
            this.dispose();
        }
    }

    public class MouseHelper extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            flagMovimiento = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            flagMovimiento = false;
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
