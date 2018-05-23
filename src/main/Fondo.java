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
public class Fondo extends JFrame implements ActionListener{

    private JLabel lblBola,lblPrueba1,lblPrueba2;
    private Timer temporizador;
    private int tiempo=500,cont=100;
    
    public Fondo() {
        super("BeatBall");
        this.setLayout(null);
        
        
        
        temporizador=new Timer(tiempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lblBola.setLocation(cont, 400);
                cont=cont+50;
                if (cont>=500) {
                    temporizador.stop();
                }
            }
        });
                temporizador.start();
    } 

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}
