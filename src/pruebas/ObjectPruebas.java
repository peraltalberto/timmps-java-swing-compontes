/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.Date;

/**
 *
 * @author aperalta
 */
public class ObjectPruebas {
    
    String texto;
    int numero;
    Date fecha;
    double decimal;
    boolean sino;

    public ObjectPruebas() {
    }

    public ObjectPruebas(String texto, int numero, Date fecha, double decimal, boolean sino) {
        this.texto = texto;
        this.numero = numero;
        this.fecha = fecha;
        this.decimal = decimal;
        this.sino = sino;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean getSino() {
        return sino;
    }

    public void setSino(boolean sino) {
        this.sino = sino;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}
