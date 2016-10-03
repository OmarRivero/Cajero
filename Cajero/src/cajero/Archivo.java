/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.io.*;
import java.util.ArrayList;

public class Archivo implements Serializable {

    private ArrayList<Persona> ListaUsuarios = new ArrayList<Persona>();

    public ArrayList<Persona> leer() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Datos.dat"));
            ListaUsuarios = (ArrayList<Persona>) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("Inicio");
        }
        return ListaUsuarios;
    }
    void Serializar (ArrayList<Persona> ListaSeriar){
       try{
           FileOutputStream out = new FileOutputStream("Datos.dat");
           ObjectOutputStream obj = new ObjectOutputStream(out);
           obj.writeObject(ListaSeriar);
           obj.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
        
    }
}
