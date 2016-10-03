package cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener, Serializable {

    JButton altas, iniciar, regresar;
    JTextField user, pin;
    JLabel label, etiqueta, fondo;
    private ArrayList<Persona> personaList;
    private Archivo obj = new Archivo();
    

    public Login() {

        this.getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Inicio de Sesion / Registro");
        setResizable(false);
        personaList = new ArrayList();
        setBounds(480, 240, 480, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Usuario");
        label.setBounds(35, 70, 75, 30);
        label.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        label.setForeground(Color.black);
        label.setBackground(Color.black);
        add(label);
        
        label = new JLabel("PIN");
        label.setBounds(250, 70, 75, 30);
        label.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        label.setForeground(Color.black);
        label.setBackground(Color.black);
        add(label);

        altas = new JButton("Registro");
        altas.setBounds(100, 200, 90, 30);
        altas.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        altas.setBackground(Color.white);
        add(altas);
        altas.addActionListener(this);

        iniciar = new JButton("Iniciar Sesion");
        iniciar.setBounds(280, 200, 120, 30);
        iniciar.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        iniciar.setBackground(Color.white);
        add(iniciar);
        iniciar.addActionListener(this);

        pin = new JPasswordField();
        pin.setBounds(300, 70, 100, 30);
        add(pin);
        pin.setEnabled(false);

        user = new JTextField();
        user.setBounds(100, 70, 100, 30);
        add(user);
        user.setEnabled(false);

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
        if (e.getActionCommand().equals("Registro")) {
            user.setEnabled(true);
            pin.setEnabled(true);
            user.requestFocus();
            iniciar.setEnabled(false);
            altas.setText("Agregar");
            altas.setFont(new Font("Century Ghotic", Font.BOLD, 12));
        } else if (e.getActionCommand().equals("Regresar")) {
            regresar.setEnabled(true);
            altas.setEnabled(true);
            altas.setText("Registro");
            iniciar.setEnabled(true);
            iniciar.setText("Iniciar Sesion");
            user.setEnabled(false);
            pin.setEnabled(false);
            regresar.setEnabled(false);
        } else {
            if (e.getActionCommand().equals("Agregar")) {
                if (pin.getText().isEmpty() || user.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No se aceptan casillas vacias");
                } else {
                    System.out.println("Registrando a: " + user.getText());
                    Persona empleadito = new Persona();
                    empleadito.setClave(pin.getText());
                    empleadito.setBoleta(user.getText());
                    getAlistito().add(empleadito);
                    obj.Serializar(personaList);
                    JOptionPane.showMessageDialog(null, "Usuario dado de alta");
                    pin.setText("");
                    user.setText("");
                    pin.setEnabled(false);
                    user.setEnabled(false);
                    iniciar.setEnabled(true);
                    altas.setText("Registro");
                }
            } else if (e.getActionCommand().equals("Iniciar Sesion")) {
                user.requestFocus();
                altas.setEnabled(false);
                pin.setEnabled(true);
                user.setEnabled(true);
                iniciar.setText("Entrar");
            } else if (e.getActionCommand().equals("Regresar")) {
                iniciar.setText("Iniciar Sesion");
                iniciar.setEnabled(true);
                user.setEnabled(false);
                pin.setEnabled(false);
            } else {
                if (e.getActionCommand().equals("Entrar")) {
                    if (pin.getText().isEmpty() || user.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No se aceptan casillas vacias");
                        //Deshabilitan los inputs o algo
                    } else {
                        boolean existe = false;
                        int cuantos = getAlistito().size();
                        for (int i = 0; i < cuantos; i++) {
                            Persona d = null;
                            if (pin.getText().equals(getAlistito().get(i).getClave()) && user.getText().equals(getAlistito().get(i).getBoleta())) {
                                d = getAlistito().get(i);
                                existe = true;
                                Menu m = new Menu();
                                this.dispose();
                                break;
                            }
                        }
                        if (!existe) {
                            JOptionPane.showMessageDialog(this, "Este usuario no existe, favor de registrarse");
                            pin.setEnabled(false);
                            user.setEnabled(false);
                            iniciar.setText("Iniciar Sesion");
                            iniciar.setEnabled(true);
                            altas.setEnabled(true);
                            pin.setText("");
                            user.setText("");
                        }
                    }
                }
            }
        }

    }

    public void Grabar() {
        getObj().Serializar(personaList);
    }

    public ArrayList<Persona> getAlistito() {
        return personaList;
    }

    public void setAlistito(ArrayList<Persona> personaList) {
        this.personaList = personaList;
    }

    public Archivo getObj() {
        return obj;
    }

    public void setObj(Archivo obj) {
        this.obj = obj;
    }
}
