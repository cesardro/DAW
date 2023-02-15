package ferreteriapedidosherencia;

import pedido.PedidoPeso;
import pedido.PedidoUnidades;

public class FerreteriaPedidosHerencia {

    public static void main(String[] args) {

        //crear pedido por unidades
        PedidoUnidades pUnid1 = new PedidoUnidades("taladro",250, 2);

        //crear pedido por peso
        PedidoPeso pPeso1 = new PedidoPeso("cemento", 9, 4.5);

        //sacar la información de cada pedido
        System.out.println(pUnid1.toString());
        System.out.println(pPeso1.toString());
    }

}
