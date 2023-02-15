package repredatosficherobarras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RepreDatosFicheroBarras extends Application {

    private static File fichero;
    private static boolean bandera = false;
    private BarChart grafBarras = null;
    private static int[] listaDatos = {0,0,0};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox principal = new VBox();

        principal.getChildren().add(new Label("Escoger fichero: "));

        HBox datos = new HBox();

        HBox botonera = new HBox();

        Button btnFichero = new Button("Abrir");
        Button btnPuntos = new Button("Puntos");
        Button btnLineas = new Button("Lineas");
        Button btnBarras = new Button("Barras");

        btnFichero.setOnAction(event -> {
            abrirFichero(stage);
        });

        btnPuntos.setDisable(true);
        btnPuntos.setOnAction(event -> {
            //pintaPuntos(principal, listaDatos);
        });

        btnLineas.setDisable(true);
        btnLineas.setOnAction(event -> {
            //pintaLineas(principal, listaDatos);
        });

        btnBarras.setOnAction(event -> {
            pintaBarras(principal);
        });

        botonera.setSpacing(10);
        botonera.getChildren().addAll(btnFichero, btnPuntos, btnLineas, btnBarras);

        principal.getChildren().addAll(datos, botonera);

        Scene scene = new Scene(principal, 400, 400);

        stage.setScene(scene);
        stage.setTitle("Representación de datos");
        stage.show();
    }

    private void pintaBarras(VBox principal) {
        
        if(bandera){
        
            CategoryAxis xEje = new CategoryAxis();
            xEje.setLabel("Eje X");
            
            NumberAxis yEje = new NumberAxis();
            yEje.setLabel("Eje Y");
            
            if(grafBarras == null){
                
                grafBarras = new BarChart(xEje, yEje);
                principal.getChildren().add(grafBarras);
            }

            XYChart.Series seriesDatos = new XYChart.Series();
            seriesDatos.setName("Datos altura");
            
            for (int i = 0; i < 3; i++) {
                seriesDatos.getData().add(new XYChart.Data("Serie"+i,listaDatos[i]));
            }
            grafBarras.getData().add(seriesDatos);
        }
    }

    private void abrirFichero(Stage stage) {

        FileChooser vtnFicheroNuevo = new FileChooser();
        vtnFicheroNuevo.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Ficheros de texto.", "*.csv")
        );
        fichero = vtnFicheroNuevo.showOpenDialog(stage);
        try {
            BufferedReader fLectura = new BufferedReader(new FileReader(fichero));
            String linea = fLectura.readLine();
            while(linea != null){
                switch(linea){
                    case "producto A":
                        listaDatos[0]++;
                        bandera = true;
                        break;
                    case "producto B":
                        listaDatos[1]++;
                        bandera = true;
                        break;
                    case "producto C":
                        listaDatos[2]++;
                        bandera = true;
                        break;
                }
                linea = fLectura.readLine();
            }
            fLectura.close();
        } catch (IOException ex) {
            Logger.getLogger(RepreDatosFicheroBarras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
