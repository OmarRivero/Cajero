/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author omari
 */
public class Movimiento extends JFrame implements ActionListener{
    
    private JLabel label;
    private JButton depositar, retirar, donar, salir;
    private JLabel etiqueta, fondo;
    private JTextField monto;
    double cantidad = 0;
    
    public Movimiento(){
        
        super();
        setLayout(null);
        setBounds(480, 240, 480, 420);
        setTitle("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        label = new JLabel("Ingrese la cantidad");
        label.setBounds(160, 70, 200, 30);
        label.setFont(new Font("Century Ghotic", Font.BOLD, 20));
        label.setForeground(Color.black);
        label.setBackground(Color.black);
        add(label);
        
        monto = new JTextField();
        monto.setBounds(200, 120, 100, 30);
        add(monto);
        monto.setEnabled(true);
        monto.requestFocus();
        
        depositar = new JButton("Depositar");
        depositar.setBounds(80, 220, 100, 30);
        depositar.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        depositar.setBackground(Color.white);
        add(depositar);
        depositar.addActionListener(this);
        
        retirar = new JButton("Retirar");
        retirar.setBounds(190, 220, 100, 30);
        retirar.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        retirar.setBackground(Color.white);
        add(retirar);
        retirar.addActionListener(this);
        
        donar = new JButton("Donar");
        donar.setBounds(300, 220, 100, 30);
        donar.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        donar.setBackground(Color.white);
        add(donar);
        donar.addActionListener(this);
        
        salir = new JButton("Salir");
        salir.setBounds(190, 300, 100, 30);
        salir.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        salir.setBackground(Color.white);
        add(salir);
        salir.addActionListener(this);
        
        ImageIcon i = new ImageIcon("/imagenes/imagen.jpg");
        etiqueta = new JLabel();
        etiqueta.setIcon(i);
        etiqueta.setBounds(0, 0, 480, 320);
        add(etiqueta);
        
        fondo = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imagen.jpg"));
        fondo.setIcon(icon);
        fondo.setBounds(0, 0, 1080,720);
        add(fondo);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Salir")){
            Menu m = new Menu();
            this.dispose();
        }
        
        if(e.getActionCommand().equals("Depositar")){
            if(monto.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingresa una cantidad numerica para hacer un movimiento.");
            }
            else{
                cantidad += Double.parseDouble(monto.getText());
                JOptionPane.showMessageDialog(this, "El saldo de tu cuenta es: " + cantidad + "$");
            }
            monto.setText("");
            monto.requestFocus();
        }
        
        if(e.getActionCommand().equals("Retirar")){
            if (monto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingresa una cantidad numerica para hacer un movimiento.");
            } else {
                cantidad -= Double.parseDouble(monto.getText());
                JOptionPane.showMessageDialog(this, "El saldo de tu cuenta es: " + cantidad + "$");
            }
            monto.setText("");
            monto.requestFocus();
        }
        
        if(e.getActionCommand().equals("Donar")){
            if (monto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingresa una cantidad numerica para hacer un movimiento.");
            } else {
                cantidad -= Double.parseDouble(monto.getText());
                JOptionPane.showMessageDialog(this, "El saldo de tu cuenta es: " + cantidad + "$");
            }
            monto.setText("");
            monto.requestFocus();
        }
    }
    
    
}