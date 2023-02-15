package graficos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Graficos extends Application {

    final int TAMDATOS = 8;
    private ScatterChart grafPuntos = null;
    private LineChart grafLineas = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox principal = new VBox();

        principal.getChildren().add(new Label("Práctica de representación gráfica de datos"));

        HBox datos = new HBox();

        TextField[] listaDatos = new TextField[this.TAMDATOS];
        for (int i = 0; i < TAMDATOS; i++) {
            listaDatos[i] = new TextField();
            listaDatos[i].setMaxWidth(60);
            listaDatos[i].setPromptText("0");
            datos.getChildren().add(listaDatos[i]);
        }

        HBox botonera = new HBox();
        
        Button btnPuntos = new Button("Puntos");
        Button btnLineas = new Button("Lineas");
        Button btnBarras = new Button("Barras");

        btnPuntos.setOnAction(event -> {
            pintaPuntos(principal, listaDatos);
        });

        btnLineas.setOnAction(event -> {
            pintaLineas(principal, listaDatos);
        });

        btnBarras.setOnAction(event -> {
            pintaBarras(principal, listaDatos);
        });

        botonera.getChildren().addAll(btnPuntos, btnLineas, btnBarras);

        principal.getChildren().addAll(datos, botonera);

        Scene scene = new Scene(principal, 400, 400);

        stage.setScene(scene);
        stage.setTitle("Representación de datos");
        stage.show();
    }

    private void pintaPuntos(VBox principal, TextField[] listaDatos) {

        NumberAxis xEje = new NumberAxis();
        xEje.setLabel("Eje X");

        NumberAxis yEje = new NumberAxis();
        yEje.setLabel("Altura - Eje Y");

        if(grafPuntos == null){
            grafPuntos = new ScatterChart(xEje, yEje);
            principal.getChildren().add(grafPuntos);
        }else{
            grafPuntos.setVisible(true);
        }
        
        if(principal.getChildren().indexOf(grafPuntos)==-1){
            principal.getChildren().remove(grafLineas);
            principal.getChildren().add(grafPuntos);
        }

        XYChart.Series serieDatos = new XYChart.Series();
        serieDatos.setName("Datos de altura");

        for (int i = 0; i < TAMDATOS; i++) {
            int valor = 0;
            if(listaDatos[i].getText().matches("^-?[0-9]+$")){
                valor=Integer.parseInt(listaDatos[i].getText());
                listaDatos[i].setStyle("-fx-control-inner-background: white");
            }else{
                listaDatos[i].setStyle("-fx-control-inner-background: pink");
            }
            serieDatos.getData().add(new XYChart.Data((i + 1) * 10, valor));
        }
        
        grafPuntos.getData().add(serieDatos);
    }

    private void pintaLineas(VBox principal, TextField[] listaDatos) {
        
        NumberAxis xEje = new NumberAxis();
        xEje.setLabel("Eje X");

        NumberAxis yEje = new NumberAxis();
        yEje.setLabel("Altura - Eje Y");

        if(grafLineas == null){
            grafLineas = new LineChart(xEje, yEje);
            principal.getChildren().add(grafLineas);
        }else{
            grafLineas.setVisible(true);
        }

        XYChart.Series serieDatos = new XYChart.Series();
        serieDatos.setName("Datos de altura");

        for (int i = 0; i < TAMDATOS; i++) {
            serieDatos.getData().add(new XYChart.Data((i + 1) * 10, Integer.parseInt(listaDatos[i].getText())));
        }
        
        grafLineas.getData().add(serieDatos);
        
    }

    private void pintaBarras(VBox principal, TextField[] listaDatos) {

    }

}
