package leerficherov1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LeerFicherov1 extends Application{
    
    private static String nomFich = "C:\\Users\\zx21student278\\Desktop\\Datos\\ficherov3.txt";
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
    
        Button btnLeer = new Button("Leer del fichero");
        
        TextArea textArea = new TextArea();
                
        btnLeer.setOnAction(event -> {
            
            leer(textArea);
        });
        
        HBox botonera = new HBox(btnLeer);
        
        VBox principal = new VBox(textArea, botonera);
        
        principal.setPadding(new Insets(30));
        
        Scene scene = new Scene(principal, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Guarda en fichero");
        stage.show();
    }

    private void leer(TextArea textArea) {
        
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(nomFich));
            String linea = lectura.readLine();
            
            while(linea != null){
                if(!textArea.getText().equals("")){
                    textArea.setText(textArea.getText()+"\n"+linea);
                }else{
                    textArea.setText(linea);
                }            
                linea = lectura.readLine();     
            }
            
            lectura.close();
        } catch (IOException ex) {
            System.out.println("Error en la lecura del fichero: "+ex.getMessage());
        }
    }
    
}
