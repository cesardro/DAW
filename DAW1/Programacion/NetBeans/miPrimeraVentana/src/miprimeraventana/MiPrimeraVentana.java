package miprimeraventana;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class MiPrimeraVentana extends Application {
    
    private static Scene escena;
    private static TextField campoTexto;
    private static Button boton; 
    private static Label salida;
    private static VBox vbox;
    
    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage escenario) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               
        //Inicializo campo texto entrada.
        campoTexto = new TextField();
        
        //Inicializo un boton.
        boton = new Button();
        boton.setText("Click me!");
        
        //Cambiar tamaño del boton.
        Scale escalar = new Scale();
        escalar.setX(1.0);
        escalar.setY(1.0);
        boton.getTransforms().add(escalar);
        
        boton.setOnAction((event) -> {
           
            salida.setText(campoTexto.getText());
        }); 
        
        //Inicializo texto-label salida.
        salida = new Label();
        
        //Inicializo caja vertical.
        vbox = new VBox(campoTexto, boton, salida);
        
        //Inicializo escena.
        escena = new Scene(vbox, 800, 500);
        
        escenario.setScene(escena);
        escenario.show();
    }
    
}

