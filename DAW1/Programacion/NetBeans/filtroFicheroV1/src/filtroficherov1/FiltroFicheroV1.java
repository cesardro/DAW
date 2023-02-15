package filtroficherov1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FiltroFicheroV1 extends Application {
    
    ArrayList<String> categoria1 = new ArrayList<String>();
    ArrayList<String> categoria2 = new ArrayList<String>();

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Button[] btn = {new Button("Recargar Fichero"),
            new Button("Guardar categoria 1"),
            new Button("Guardar categoria 2")};

        ListView izquierdaLV = new ListView();
        ListView derechaLV = new ListView();

        VBox izquierdaVB = new VBox(izquierdaLV, btn[1]);
        VBox derechaVB = new VBox(derechaLV, btn[2]);

        SplitPane splitPane = new SplitPane(izquierdaVB, derechaVB);

        VBox principal = new VBox(btn[0], splitPane);

        Scene scene = new Scene(principal);

        principal.setPadding(new Insets(10));

        btn[0].setOnAction(event -> {
            leerInformacion(izquierdaLV, derechaLV);
        });

        btn[1].setOnAction(event -> {
            crearCategoria1(izquierdaLV, derechaLV);
        });
        
        btn[2].setOnAction(event -> {
            crearCategoria2(izquierdaLV, derechaLV);
        });
        
        stage.setScene(scene);
        stage.setTitle("Filtro de fichero");
        stage.show();
    }

    private void leerInformacion(ListView izquierdaLV, ListView derechaLV) {
        
        try {
                BufferedReader leerFichero = new BufferedReader(new FileReader("C:\\Users\\zx21student278\\Desktop\\Datos\\datos.txt"));
                String linea = leerFichero.readLine();
                String contenido = "";
                while(linea != null){
                    contenido = contenido+linea+"\n";
                    if(linea != null){
                        String[] trozos = linea.split(";");
                        if(Integer.parseInt(trozos[1]) == 1){
                            izquierdaLV.getItems().addAll(trozos[0]);
                            categoria1.add(trozos[0]);
                        }else{
                            derechaLV.getItems().addAll(trozos[0]);
                            categoria2.add(trozos[0]);
                        }
                    }
                    linea = leerFichero.readLine();
                }
                leerFichero.close();
            } catch (IOException ex) {
                Logger.getLogger(FiltroFicheroV1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void crearCategoria1(ListView izquierdaLV, ListView derechaLV) {
        
        try {
            BufferedWriter crearFichero = new BufferedWriter(new FileWriter("C:\\Users\\zx21student278\\Desktop\\Datos\\categoria1.txt", true));
            for (int i = 0; i < categoria1.size(); i++) {
                crearFichero.write(categoria1.get(i)+"\n");
            }
            crearFichero.close();
        } catch (IOException ex) {
            Logger.getLogger(FiltroFicheroV1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void crearCategoria2(ListView izquierdaLV, ListView derechaLV) {
        
        try {
            BufferedWriter crearFichero = new BufferedWriter(new FileWriter("C:\\Users\\zx21student278\\Desktop\\Datos\\categoria2.txt", true));
            for (int i = 0; i < categoria2.size(); i++) {
                crearFichero.write(categoria2.get(i)+"\n");
            }
            crearFichero.close();
        } catch (IOException ex) {
            Logger.getLogger(FiltroFicheroV1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
