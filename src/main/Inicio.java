/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Victor
 */
public class Inicio extends JFrame implements ActionListener {

    private JButton btnJugar;

    public Inicio() {
        super("Menú de Juego ---- Airplane Dodge");
        this.setLayout(null);

        btnJugar = new JButton("Jugar");
        btnJugar.setSize(70, 30);
        btnJugar.setLocation(160, 50);
        btnJugar.addActionListener(this);
        this.add(btnJugar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnJugar) {
            Juego juego = new Juego(this);
            juego.setSize(800, 800);
            juego.setLocationRelativeTo(null);
            juego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            juego.setVisible(true);
        }
    }

}
