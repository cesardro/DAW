package tablero;

import java.io.File;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class Tablero extends Application{
    
    private int ancho, alto;
    private ImageView tablero;

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) {
        
        ancho = 400;
        alto = 400;
        
        BorderPane principal = new BorderPane();
      
        tablero = new ImageView();
        
        crearTablero();
        
        principal.setCenter(tablero);
        
        Scene scene = new Scene(principal);
        
        stage.setScene(scene);
        stage.setTitle("Tablero");
        stage.show();   
    }

    private void crearTablero() {
        WritableImage imagenNueva = new WritableImage(ancho, alto);
        
        PixelWriter pw = imagenNueva.getPixelWriter();
        
        boolean bandera = true;
        int contador = 0;
        int columnas = 0;
        for (int i =0; i < ancho; i++) {  
            columnas++;
            for (int j =0; j < alto; j++) {
                if(columnas > 50){
                    bandera=!bandera;
                    columnas=0;
                }
                if(bandera){
                    pw.setColor(i, j, Color.WHITE);
                }else{
                    pw.setColor(i, j, Color.BLACK);
                }
                contador++;
                if(contador >= 50){
                    bandera=!bandera;
                    contador=0;
                }   
            }
            
        }
        tablero.setImage(imagenNueva);
        File file = new File("C:\\Users\\zx21student278\\Desktop\\tablero.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(imagenNueva, null), "png", file);
        } catch (Exception s) {
        }
    }
    
}
