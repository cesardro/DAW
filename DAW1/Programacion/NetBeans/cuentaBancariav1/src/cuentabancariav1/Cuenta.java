/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancariav1;

/**
 *
 * @author zx21student278
 */
public class Cuenta {
    
    private String titular;
    private double cantidad;
    
    //Constructor
    public Cuenta(String t, double c){
        if(c<0){
            this.cantidad = 0;
        }else{
            this.cantidad = c;
        }
        this.titular = t;
    }
    
    //Metodo get de titular
    public String getTitular() {
        return titular;
    }
    
    //Metodo set de titular
    public void setTitular(String titular) {
        this.titular = titular;
    }

    //Metodo get de cantidad
    public double getCantidad() {
        return cantidad;
    }

    //Metodo set de cantidad
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    public void ingresar(double c){
        if(c>=0){
            this.cantidad += c;
        }
    }
    
    public void retirar(double r){
        if(r>=0){
            this.cantidad -= r;
            if(this.cantidad<0){
                this.cantidad = 0;
            }
        }
    }
}
