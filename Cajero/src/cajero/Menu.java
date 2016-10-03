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
public class Menu extends JFrame implements ActionListener{
    
    JLabel label;
    JButton transaccion, cerrarSession;
    JLabel etiqueta, fondo;
    
    public Menu(){
        
        super();
        setLayout(null);
        setBounds(480, 240, 480, 420);
        setTitle("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        label = new JLabel("Elija una opción");
        label.setBounds(170, 70, 200, 30);
        label.setFont(new Font("Century Ghotic", Font.BOLD, 20));
        label.setForeground(Color.black);
        label.setBackground(Color.black);
        add(label);
        
        transaccion = new JButton("Movimiento Bancario");
        transaccion.setBounds(165, 170, 170, 30);
        transaccion.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        transaccion.setBackground(Color.white);
        add(transaccion);
        transaccion.addActionListener(this);
        
        cerrarSession = new JButton("Cerrar Sesión");
        cerrarSession.setBounds(165, 220, 170, 30);
        cerrarSession.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        cerrarSession.setBackground(Color.white);
        add(cerrarSession);
        cerrarSession.addActionListener(this);
        
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
        if(e.getActionCommand().equals("Cerrar Sesión")){
            Login l = new Login();
            this.dispose();
        }
        
        if(e.getActionCommand().equals("Movimiento Bancario")){
            MovBancario mov = new MovBancario();
            this.dispose();
        }
    }
}
