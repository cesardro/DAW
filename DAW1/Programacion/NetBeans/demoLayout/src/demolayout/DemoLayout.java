package demolayout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DemoLayout extends Application{
    
    private boolean dia = true;
    
    public static void main(String[] args){
        launch(args);       
    }

    @Override
    public void start(Stage stage){
        
        //Formas - shapes.
        
        //Constructor(base, altura, color) - color es opcional.
        Rectangle rec1 = new Rectangle(100, 50, Color.SKYBLUE);
        
        //setTranslateX/Y es para mover el elemento en el panel.
        //rec1.setTranslateY(-150);
        
        Rectangle rec2 = new Rectangle(100, 50, Color.RED);
        Rectangle rec3 = new Rectangle(150, 50, Color.ORANGE);
        Rectangle rec4 = new Rectangle(100, 50, Color.GREEN);
        Rectangle rec5 = new Rectangle(100, 50, Color.PURPLE);
        
        //rec2.setTranslateY(150);
        
        //Constructor(radio, color) - color es opcional.
        Circle circ1 = new Circle(25, Color.YELLOW);
        
        //setTranslateX/Y es para mover el elemento en el panel.
        //circ1.setTranslateX(-300);
        //circ1.setTranslateY(-300);
        
        //StackPane() - te permite color los elementos donde tu quieras.
        //StackPane tablero = new StackPane(rec1, rec2, circ1);
        
        //TilePane() - crea una caja y mete los elementos en orden. No hay posicionamiento libre con X y Y.
        //TilePane tablero = new TilePane(rec1, rec2, circ1);
        
        //Es un panel con centro, arriba, abajo, derecha e izquierda. 
        //BorderPane tablero = new BorderPane();
        
        /*.setTop para poner las posiciones en los ejes. 
        tablero.setTop(rec1);
        tablero.setBottom(rec2);
        tablero.setRight(rec3);
        tablero.setLeft(rec4);
        tablero.setCenter(rec5);
        */
        
        AnchorPane tablero = new AnchorPane(rec3, circ1);
        
        //Basicamente un padding del punto de inicio que es la izquiera superior. 
        AnchorPane.setTopAnchor(rec3, 30.0);
        AnchorPane.setLeftAnchor(rec3, 30.0);
        
        /*
        Esta es otra forma para añadir elementos al StackPane si no lo has hecho
        en el constructor.
        tablero.getChildren().addAll(rec1, circ1);
        */
        
        //Si pincha en el tablero, se cambia de color. 
        /*tablero.setOnMouseClicked(event -> {
            
            //.setFill sirve para cambiar el color del elemento.
            if(dia){
                rec1.setFill(Color.BLACK);
                circ1.setFill(Color.WHITESMOKE);
                dia = false;
            }else{
                rec1.setFill(Color.SKYBLUE);
                circ1.setFill(Color.YELLOW);
                dia = true;
            }
            
        });
        */
        Scene scene = new Scene(tablero);
        
        stage.setScene(scene);
        stage.setTitle("Demos de Layout y elementos.");
        stage.show();
    }
    
}
