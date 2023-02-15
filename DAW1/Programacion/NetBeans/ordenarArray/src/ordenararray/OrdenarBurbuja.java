package ordenararray;

public class OrdenarBurbuja {

    public static int[] burbuja(int[] desordenado) {

        for (int i = desordenado.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (desordenado[j] > desordenado[j + 1]) {
                    int aux = desordenado[j];
                    desordenado[j] = desordenado[j + 1];
                    desordenado[j + 1] = aux;
                }
            }
        }
        return desordenado; //Aquí el array tiene que estar ya ordenado.
    }

    public static int[] burbujaAlReves(int[] desordenado) {

        for (int i = desordenado.length - 1; i >= 0; i--) {
            for (int j = desordenado.length - 1; j > 0; j--) {
                if (desordenado[j] > desordenado[j - 1]) {
                    int aux = desordenado[j];
                    desordenado[j] = desordenado[j - 1];
                    desordenado[j - 1] = aux;
                }
            }
        }

        return desordenado;
    }

    public static int[] insercion(int[] desordenado) {
        
        for (int i = 1; i < desordenado.length; i++) {
            int aux = desordenado[i];
            int j = i - 1;
            while((j >= 0) && (aux < desordenado[j])){
                
                desordenado[j+1] = desordenado[j];
                j--;
            }
            desordenado[j+1] = aux;
        }
        
        return desordenado;
    }
}
