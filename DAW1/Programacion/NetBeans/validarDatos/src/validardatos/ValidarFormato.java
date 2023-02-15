package validardatos;

public class ValidarFormato {

    private static Character[] rule = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', '-', 'ñ', 'Ñ', 'á', 'Á', 'é', 'É', 'í',
        'Í', 'ó', 'Ó', 'ú', 'Ú', 'ü', 'Ü', ' '};

    public static boolean validarNombre(String texto) {
        
        boolean resultados = true;

        if (texto.length() > 20) {

            resultados = false;
        } else {
            validarAlfabeto(texto);
        }

        return resultados;
    }

    public static boolean validarApellidos(String texto) {

        boolean resultados = true;

        if (texto.length() > 50) {

            resultados = false;
        } else {
            validarAlfabeto(texto);
        }

        return resultados;
    }

    public static boolean validarCorreo(String texto) {

        boolean resultados = true;
        return resultados;
    }

    public static boolean validarUsuario(String texto) {

        boolean resultados = true;
        return resultados;
    }

    public static boolean validarContraseña(String texto) {

        boolean resultados = true;
        return resultados;
    }

    public static boolean validarAlfabeto(String texto) {

        boolean resultados = true;

        char letra;
        for (int i = 0; i < texto.length(); i++) {

            letra = texto.charAt(i);
            boolean check = false;
            for (int j = 0; j < rule.length; j++) {

                if (letra == rule[j]) {
                    check = true;
                }
            }
            if (!check) {

                resultados = false;
                break;
            }
        }
        return resultados;
    }
}
