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

    private JButton btnJugar,btnRecord,btnSalir,btnControl;
    private JLabel lblFondo,lblCredit;
    public Inicio() {
        super();
        this.setLayout(null);
        
         ImageIcon imgFondo = new ImageIcon( Inicio.class.getResource("/main/imagenes/fondo.gif"));
 
        //JUGAR
        btnJugar = new JButton("Jugar");
        btnJugar.setSize(100, 30);
        btnJugar.setLocation(45, 30);
        btnJugar.addActionListener(this);
        this.add(btnJugar);
        
        //RECORD
        btnRecord = new JButton("Récord");
        btnRecord.setSize(100, 30);
        btnRecord.setLocation(45, 70);
        btnRecord.addActionListener(this);
        this.add(btnRecord);
        
        //CONTROLES
        btnControl = new JButton("Controles");
        btnControl.setSize(100, 30);
        btnControl.setLocation(45, 110);
        btnControl.addActionListener(this);
        this.add(btnControl);
        
        //SALIR
        btnSalir = new JButton("Salir");
        btnSalir.setSize(100, 30);
        btnSalir.setLocation(45, 150);
        btnSalir.addActionListener(this);
        this.add(btnSalir);
        
        //CREDITO
        lblCredit=new JLabel("Airplane Dodge - Version 0.1");
        lblCredit.setSize(200, 30);
        lblCredit.setLocation(20, 250);
        lblCredit.setVisible(true);
        this.add(lblCredit);
        
        //FONDO
        lblFondo=new JLabel(imgFondo);
        lblFondo.setSize(200, 300);
        lblFondo.setLocation(0, 0);
        lblFondo.setVisible(true);
        this.add(lblFondo);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnJugar) {
            Juego juego = new Juego(this);
            juego.setSize(800, 800);
            juego.setResizable(false);
            juego.setLocationRelativeTo(null);
            juego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            juego.setVisible(true);
        }
        if (e.getSource()==btnRecord) {
            Auxiliar aux = new Auxiliar(this);
            aux.setSize(220, 120);
            aux.setResizable(false);
            aux.setLocationRelativeTo(null);
            aux.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            aux.setVisible(true);
            
        }
        if (e.getSource()==btnControl) {
            Auxiliar aux = new Auxiliar(this);
            aux.setSize(220, 120);
            aux.setResizable(false);
            aux.setLocationRelativeTo(null);
            aux.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            aux.setVisible(true);
            
        }
        if (e.getSource()==btnSalir) {
            System.exit(0);
        }
    }

}
