package cajerosb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CajeroSB extends Application {
    
    public static String iban = "IBAN";
    
    public static String saldo = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Cajero SB");
        stage.setScene(scene);
        stage.show();

    }

}
