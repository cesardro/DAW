/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasgeometricas;

/**
 *
 * @author zx21student278
 */
public class Cuadrado {
    
    private double lado;
    
    public Cuadrado(double l){
        if(l<0){
            lado = 0;
        }else{
            lado = l;
        }
    }
    
    public double getLado(){
        return lado;
    }
    
    public void setLado(double l){
        if(l<0){
            lado = 0;
        }else{
            lado = l;
        }
    }
    
    public double perimetro(){
        double perimetro = 0;
        perimetro = 4*lado;
        return perimetro;
    }
    
    public double area(){
        double area = 0;
        area = lado*lado;
        return area;
    }
}
