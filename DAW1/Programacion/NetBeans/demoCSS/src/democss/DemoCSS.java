package democss;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class DemoCSS extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Label etiq1 = new Label("Etiqueta uno");
        Button btn1 = new Button("Boton 1");
        
        HBox principal = new HBox(etiq1);
        
        Scene scene = new Scene(principal);
        
        scene.getStylesheets().add("estilos/aplicacion.css");
        
        stage.setScene(scene);
        stage.setTitle("Demo de CSS");
        stage.show();
    }
    
}
