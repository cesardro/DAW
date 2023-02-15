package sumaventana;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SumaVentana extends Application{

    
    private static Scene scene;    // Escena
    private static VBox verticalBoxPN;      // Caja vertical
    private static HBox horizontalBox;      // Caja horizontal 
    private static Button button;  // Botón
    private static Label label;    // Etiqueta
    private static TextField sumando1, sumando2; //Campos de texto.
    
    
    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        //Creamos el boton.
        button = new Button();
        button.setText("Sumar");
        
        //Acción para controlar el evento del boton y hacer la suma. 
        button.setOnAction((event) -> {
           
            int resultado;
            resultado = Integer.parseInt(sumando1.getText()) + Integer.parseInt(sumando2.getText());
            
            label.setText("Resultado: "+ resultado);
        }); 
        
        //Creamos la etiqueta.
        label = new Label("0");
        
        //Creamos los campos de texto.
        sumando1 = new TextField();
        sumando2 = new TextField();
        sumando1.setPromptText("Sumando 1");
        sumando2.setPromptText("Sumando 2");
        
        //Creamos la caja horizontal.
        horizontalBox = new HBox(sumando1, sumando2);
        
        //Creamos la caja vertical (Nodo Principal)
        verticalBoxPN = new VBox(horizontalBox, button, label);
        
        //Creamos la escena.
        scene = new Scene(verticalBoxPN);

        //Creamos ventana y tamaño.
        stage.setHeight(500);
        stage.setWidth(500);
        
        //Seteamos la escena.
        stage.setScene(scene);
        
        //Muestra la ventana.
        stage.show();
    }
    
}
