package blancoynegro;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BlancoYNegro extends Application{

    private Image surf;
    private ImageView imgSurf;
    private WritableImage imagenNueva;
    
    private int ancho, alto;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        BorderPane principal = new BorderPane();
        
        HBox botonera = new HBox();
        
        surf = new Image("imagenes/surf.jpg");
        
        ancho=(int)surf.getWidth();
        alto=(int)surf.getHeight();
               
        imgSurf = new ImageView(surf);
        
        imgSurf.setFitHeight(400);
        imgSurf.setFitWidth(700);
        
        principal.setCenter(imgSurf);
        
        Button btnOrig = new Button("Original");
        btnOrig.setOnAction(event -> {
            imgSurf.setRotate(0);
            imgSurf.setImage(surf);
        });
        
        Button btnColor = new Button("Color");
        ColorPicker selColor = new ColorPicker();
        btnColor.setOnAction(event -> {
            color(selColor.getValue());
        });
        
        Button btnBN = new Button("Blanco y negro");
        btnBN.setOnAction(event -> {
            conBlancoYNegro();
        });
        
        Button btnDegraGris = new Button("Degradado con grises");
        btnDegraGris.setOnAction(event -> {
            degradadoGris();
        });
        
        Button btnEspejo = new Button("Espejo");
        btnEspejo.setOnAction(event -> {
            imagenEspejo();
        });
        
        Button btnRojo = new Button("Rojo");
        btnRojo.setOnAction(event -> {
            cambioRojo();
        });
        
        Button btnVerde = new Button("Verde");
        btnVerde.setOnAction(event -> {
            cambioVerde();
        });
        
        Button btnAzul = new Button("Azul");
        btnAzul.setOnAction(event -> {
            cambioAzul();
        });
        
        botonera.getChildren().addAll(btnOrig, btnColor, selColor, btnDegraGris, btnBN, btnEspejo, btnRojo, btnVerde, btnAzul);
        
        principal.setTop(botonera);
        
        Scene scene = new Scene(principal);
        
        stage.setScene(scene);
        stage.setTitle("Modificando fotos");
        stage.show();
        
    }

    private void color(Color color) {
        
        imagenNueva = new WritableImage((int)surf.getWidth(), (int)surf.getHeight());
        PixelWriter pw = imagenNueva.getPixelWriter();
        
        for (int i = 0; i < imagenNueva.getWidth(); i++) {
            for (int j = 0; j < imagenNueva.getHeight(); j++) {
                pw.setColor(i, j, color);
            }
        }
        imgSurf.setImage(imagenNueva);
    }

    private void conBlancoYNegro() {
        PixelReader pr = surf.getPixelReader();
        
        imagenNueva = new WritableImage(ancho, alto);
        PixelWriter pw = imagenNueva.getPixelWriter();
        
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Color cp = pr.getColor(i, j);
                double rojo = cp.getRed();
                double verde = cp.getGreen();
                double azul = cp.getBlue();
                double media = (rojo+verde+azul)/3;
                pw.setColor(i, j, Color.color(media, media, media));
            }
        }
        imgSurf.setImage(imagenNueva);
    }

    private void degradadoGris() {
        
        imagenNueva = new WritableImage(ancho, alto);
        PixelWriter pw = imagenNueva.getPixelWriter();
        
        int intervalo = ancho/256;
        int contador = 0;
        
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pw.setColor(i, j, Color.rgb(contador, contador, contador));
            }
            if((int)i/intervalo != contador){
                contador++;
                if(contador > 255){
                    contador=255;
                }
            }
        }
        imgSurf.setImage(imagenNueva);
    }

    private void imagenEspejo() {
        
        PixelReader pr = surf.getPixelReader();
        
        imagenNueva = new WritableImage(ancho, alto);
        PixelWriter pw = imagenNueva.getPixelWriter();
        
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Color cp = pr.getColor(i, j);
                pw.setColor((ancho-i-1), j, cp);
            }
        }
        imgSurf.setImage(imagenNueva);
    }

    private void cambioRojo() {
        PixelReader pr = surf.getPixelReader();
        
        imagenNueva = new WritableImage(ancho, alto);
        PixelWriter pw = imagenNueva.getPixelWriter();
        
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Color cp = pr.getColor(i, j);
                double rojo = cp.getRed();
                pw.setColor(i, j, Color.color(rojo, 0, 0));
            }
        }
        imgSurf.setImage(imagenNueva);
    }

    private void cambioVerde() {
        PixelReader pr = surf.getPixelReader();
        
        imagenNueva = new WritableImage(ancho, alto);
        PixelWriter pw = imagenNueva.getPixelWriter();
        
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Color cp = pr.getColor(i, j);
                double verde = cp.getGreen();
                pw.setColor(i, j, Color.color(0, verde, 0));
            }
        }
        imgSurf.setImage(imagenNueva);
    }

    private void cambioAzul() {
    PixelReader pr = surf.getPixelReader();
        
        imagenNueva = new WritableImage(ancho, alto);
        PixelWriter pw = imagenNueva.getPixelWriter();
        
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Color cp = pr.getColor(i, j);
                double azul = cp.getBlue();
                pw.setColor(i, j, Color.color(0, 0, azul));
            }
        }
        imgSurf.setImage(imagenNueva);
    }
    
}
