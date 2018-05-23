/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author victor
 */
public class Fondo extends JFrame implements ActionListener {

    private boolean flag = false;
    private JLabel lblBola;
    private Timer tmrMovimiento;
    private int tiempo = 30, bolaY = 400;

    public Fondo() {
        super("BeatBall");
        this.setLayout(null);
        this.setBackground(Color.cyan);
        lblBola = new JLabel("O.O");
        lblBola.setSize(30, 10);
        lblBola.setLocation(50, bolaY);
        lblBola.setVisible(true);
        this.add(lblBola);
        tmrMovimiento = new Timer(tiempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (flag) {
                    bolaY = bolaY - 5;
                    lblBola.setLocation(50, bolaY);
                    lblBola.setText("O.O");
                    System.err.println(bolaY);
                }
                if (!flag) {
                    bolaY = bolaY + 5;
                    lblBola.setLocation(50, bolaY);
                    lblBola.setText("O.O");
                    System.err.println(bolaY);
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
            flag=true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            flag=false;
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
