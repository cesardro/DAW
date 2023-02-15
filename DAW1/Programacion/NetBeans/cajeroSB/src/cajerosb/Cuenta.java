package cajerosb;

import java.util.ArrayList;

public class Cuenta {
    private String iban;
    private String titular;
    private double saldo;
    private  ArrayList<Double> histOper = new ArrayList<Double>();

    public Cuenta(String iban, String titular, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
        this.titular = titular;

    }

    public Cuenta(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
    }
    

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public ArrayList<Double> getHistOper() {
        return histOper;
    }
    
    public void añadirHistorial(Double historial){
        histOper.add(historial);
    }
}
