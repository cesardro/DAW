package pruebapaquetes;
import empresa.Empresa;
public class PruebaPaquetes {
    public static void main(String[] args) {
        
        Empresa miEmpresa = new Empresa("NoSoyValorant Player");
        
        miEmpresa.aniadirPersona("Juan", "Garcia", "juangarcia29@gmail.com");
        miEmpresa.aniadirPersona("Sebas", "Solano", "holacomoestas@gmail.com");
        
        System.out.println(miEmpresa.toString());
        
    }
}
