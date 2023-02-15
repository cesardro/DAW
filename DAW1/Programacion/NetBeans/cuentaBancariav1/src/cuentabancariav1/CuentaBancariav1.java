package cuentabancariav1;
import java.util.Scanner;
public class CuentaBancariav1 {
    public static void main(String[] args) {
        //sc es para preguntar al usuario
        Scanner sc = new Scanner(System.in);
        String resp = "";
        
        System.out.println("¿Quiere crear una cuenta? (S/N)");
        
        resp = sc.next();
        
        if(resp.toUpperCase().equals("S")){
            String titular;
            double cantidad;
            
            System.out.print("Nombre del titular: ");
            titular = sc.next();
            
            System.out.print("Cantidad inicial: ");
            cantidad = sc.nextDouble();
            
            Cuenta ct = new Cuenta(titular, cantidad);
            
            System.out.println("¿Quiere operar con la cuenta? (S/N)");
            resp = sc.next();
            
            if(resp.toUpperCase().equals("S")){
                boolean oper = true;
                while(oper){
                    System.out.println("¿Ingresar o retirar? (I/R)");
                    resp = sc.next();
                    switch(resp.toUpperCase()){
                        case "I":
                            System.out.print("Cantidad a ingresar: ");
                            cantidad = sc.nextInt();
                            ct.ingresar(cantidad);
                            System.out.println("Nueva cantidad: "+ct.getCantidad());
                            break;
                        case "R":
                            System.out.println("Cantidad a retirar: ");
                            cantidad = sc.nextInt();
                            ct.retirar(cantidad);
                            System.out.println("Nueva cantidad: "+ct.getCantidad());
                            break;
                        default:
                            System.out.println("Operación no contemplada.");
                            break;
                    }
                    System.out.println("¿Seguir operando? (S/N)");
                    resp = sc.next();
                    if(resp.toUpperCase().equals("N")){
                        oper = false;
                    }
                }
                System.out.println("Gracias por usar nuestros servicios.");
            }else{
                System.out.println("Hasta luego, Lucas.");
            }
        }else{
            System.out.println("A otra cosa, mariposa...");
        }
    }
}
