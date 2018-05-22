/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author victor
 */
public class Fondo extends JFrame {

    private JLabel lblBola,lblPrueba1,lblPrueba2;
    
    public Fondo() {
        super("BeatBall");
        this.setLayout(null);
        
        lblBola=new JLabel("O.O");
        lblBola.setSize(30,10);
        lblBola.setLocation(50, 250);
        lblBola.setVisible(true);
        this.add(lblBola);
    }
    
}
