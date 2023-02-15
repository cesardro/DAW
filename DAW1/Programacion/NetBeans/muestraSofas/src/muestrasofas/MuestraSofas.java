package muestrasofas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MuestraSofas extends Application{
    
    private double ratio = 10;
    
    
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage stage){
        
        
        
        BorderPane borderPane = new BorderPane();
        
        //Cargar imagen y mostrar 400x400
        
        Image sofaGris = new Image("imagenes/sofaGris.jpg");
        Image sofaAzul = new Image("imagenes/sofaAzul.jpg");
        Image sofaBlanco = new Image("imagenes/sofaBlanco.jpg");
        
        Button btnGris = new Button("Gris");
        Button btnAzul = new Button("Azul");
        Button btnBlanco = new Button("Blanco");
        
        Button btnAumentar = new Button("Aumentar");
        Button btnReducir = new Button("Reducir");
        
        ImageView imgSofa = new ImageView(sofaGris);
        
        imgSofa.setFitWidth(400);
        imgSofa.setFitHeight(400);
        
        borderPane.setCenter(imgSofa);
  
        btnAumentar.setOnAction(event->{
            imgSofa.setFitHeight(600);
            imgSofa.setFitWidth(600);
            
        });
       
        btnReducir.setOnAction(event->{
            imgSofa.setFitHeight(300);
            imgSofa.setFitWidth(300);
            
        });
        
        btnGris.setOnAction(event->{
            imgSofa.setImage(sofaGris);
            
        });
        btnAzul.setOnAction(event->{
            imgSofa.setImage(sofaAzul);
            
        });
        btnBlanco.setOnAction(event->{
            imgSofa.setImage(sofaBlanco);
            
        });
        
        Button btnMas = new Button("+");
        btnMas.setOnAction(event->{
            borderPane.setCenter(imgSofa);
            imgSofa.setFitHeight(imgSofa.getFitHeight()+ratio);
            imgSofa.setFitWidth(imgSofa.getFitWidth()+ratio);
        });
        
        Button btnMenos = new Button("-");
        btnMenos.setOnAction(event->{
            borderPane.setCenter(imgSofa);
            imgSofa.setFitHeight(imgSofa.getFitHeight()-ratio);
            imgSofa.setFitWidth(imgSofa.getFitWidth()-ratio);
        });
        
        HBox botonera = new HBox(btnAumentar, btnReducir, btnMas, btnMenos, btnGris, btnAzul, btnBlanco);
        borderPane.setTop(botonera);
        
        Scene scene = new Scene(borderPane);
        
        stage.setScene(scene);
        stage.setTitle("Muestrario Sofás");
        stage.show();
    }
    
}
