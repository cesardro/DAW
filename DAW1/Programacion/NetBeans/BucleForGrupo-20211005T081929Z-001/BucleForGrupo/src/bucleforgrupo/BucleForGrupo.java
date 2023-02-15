/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucleforgrupo;

import java.util.Scanner;

/**
 *
 * @author Perla Celaya Rodrguez
 * @author Liu Retamal Fernandez
 * @author Cesar Alejandro Solano Suarez
 */
public class BucleForGrupo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("******EJERCICIO 1******");
        int num;
        int n;
        System.out.print("Cuantos numeros va a introducir?");
        num = sc.nextInt();

        int mayor;
        if (num > 0) {
            System.out.println("Escriba el primer numero: ");
            n = sc.nextInt();

            for (int i = 1; i < num; i++) {
                System.out.print("Escriba un numero mayor que " + n + ": ");
                mayor = sc.nextInt();
                if (n > mayor) {
                    System.out.println("¡" + mayor + " no es mayor que: " + n + " !");
                }
                n = mayor;
            }
            System.out.println("Gracias por su colaboracion");
        } else {
            System.out.println("No puede ser menor que cero");
        }
        System.out.println("*****EJERCICIO 2******");
        int valores;
        int cont = 0;
        int temp;
        System.out.print("Cuantos valores va a introducir: ");
        valores = sc.nextInt();

        if (valores < 0) {
            System.out.println("¡Imposible!");
        } else {
            for (int j = 1; j <= valores; j++) {
                System.out.print("Escriba el numero: ");
                temp = sc.nextInt();
                if (temp < 0) {
                    cont++;
                }
            }

            if (cont > 0) {
                System.out.println("Ha escrito " + cont + " numeros negativos;");
            } else {
                System.out.println("No ha escrito ningun numero negativo");
            }
        }
        System.out.println("******EJERCICIO 3******");
        int val;
        int impar = 0, par = 0;
        int myNum;
        System.out.print("Cuantos valores va a introducir: ");
        val = sc.nextInt();

        if (val < 0) {
            System.out.println("¡Imposible!");
        } else {
            for (int j = 1; j <= val; j++) {
                System.out.print("Escriba el valor" + j + ": ");
                myNum = sc.nextInt();
                if (myNum % 2 == 0) {
                    par++;
                } else {
                    impar++;
                }
            }

            System.out.println("Ha escrito " + par + " numeros pares y " + impar + " numeros impares\nGraias por su colaboracion");

        }
        System.out.println("*****EJERCICIO 4******");
        int numero;
        int contador = 0;
        System.out.println("NUMERO PRIMO");
        System.out.print("Escriba un numero mayor que 1: ");
        numero = sc.nextInt();

        if (numero <= 1) {
            System.out.println("Le he pedido un numero entero mayor que 1");
        } else {
            for (int j = 1; j <= numero; j++) {
                if (numero % j == 0) {
                    contador++;
                }
            }

            if (contador <= 2) {
                System.out.println(numero + " es primo.");
            } else {
                System.out.println(numero + " no es primo.");
            }
        }
    }
}
