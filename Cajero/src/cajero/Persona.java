/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.io.Serializable;

public class Persona implements Serializable{
    
    private String Boleta;
    private String Clave;

    public String getBoleta() {
        return Boleta;
    }

    public void setBoleta(String Boleta) {
        this.Boleta = Boleta;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    
}
