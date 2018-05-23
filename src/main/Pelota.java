/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.*;

/**
 *
 * @author victor
 */
public class Pelota extends JComponent {
    
    private JLabel lblBola;
    private int locY;

    public int getLocY() {
        return locY;
    }

    public void setLocY(int locY) {
        this.locY = locY;
    }
    
    
    public Pelota() {
        
        lblBola=new JLabel("O.O");
        lblBola.setSize(30,10);
        lblBola.setLocation(400,this.locY);
        lblBola.setVisible(true);
        this.add(lblBola);
    }
    
}
