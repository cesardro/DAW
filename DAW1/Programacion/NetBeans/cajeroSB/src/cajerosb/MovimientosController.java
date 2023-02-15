package cajerosb;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MovimientosController implements Initializable {

    @FXML
    private AnchorPane principal;
    @FXML
    private Label movimientos;
    @FXML
    private Button btnSalir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Cuenta cuenta = FXMLController.mapaDatos.get(CajeroSB.iban);
        String historial = "";
        for (int i = 0; i < cuenta.getHistOper().size(); i++) {
            historial += cuenta.getHistOper().get(i)+"\n";
        }
        movimientos.setText(historial);
        
    }    

    @FXML
    private void salir(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    
}
