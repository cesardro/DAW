package escribirficherov1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EscribirFicheroV1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        TextField textField = new TextField();
        textField.setPromptText("Introduce un texto");

        Button btnSave = new Button("Guardar");
        btnSave.setOnAction(event -> {

            guardar(textField.getText());
        });
        
        Button btnAdd = new Button("Añadir");
        btnAdd.setOnAction(event -> {

            anadir(textField.getText());
        });

        HBox botonera = new HBox(btnSave, btnAdd);
        
        VBox principal = new VBox(textField, botonera);

        Scene scene = new Scene(principal, 300, 300);
        principal.setPadding(new Insets(50));

        stage.setTitle("Guardar en fichero");
        stage.setScene(scene);
        stage.show();
    }

    private void guardar(String text) {

        if (!"".equals(text)) {
            try {
                //Abrimos el fichero para escritura con una clase con buffer.
                BufferedWriter fichero = new BufferedWriter(new FileWriter("C:\\Users\\zx21student278\\Desktop\\Datos\\ficherov1.txt"));
                //Escribimos el texto recibido en text dentro del fichero. 
                fichero.write(text);
                //Lo cierro
                fichero.close();
            } catch (IOException ex) {
                
                System.out.println("Error en fichero" + ex.getMessage());
            }
        } else {
            System.out.println("Texto vacio");
        }

    }

    private void anadir(String text) {
        
        if (!"".equals(text)) {
            try {
                //Abrimos el fichero para escritura con una clase con buffer.
                BufferedWriter fichero = new BufferedWriter(new FileWriter("C:\\Users\\zx21student278\\Desktop\\Datos\\ficherov1.txt",true));
                //Escribimos el texto recibido en text dentro del fichero. 
                fichero.append(text);
                //Lo cierro
                fichero.close();
            } catch (IOException ex) {
                
                System.out.println("Error en fichero" + ex.getMessage());
            }
        } else {
            System.out.println("Texto vacio");
        }

    }
}
