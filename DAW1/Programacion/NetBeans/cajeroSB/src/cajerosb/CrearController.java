package cajerosb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrearController implements Initializable {

    @FXML
    private AnchorPane principal;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textIBAN;
    @FXML
    private TextField textSaldo;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void aceptar(ActionEvent event) throws IOException {

        BufferedWriter fCuentas = new BufferedWriter(new FileWriter("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\cuentas.dat", true));
        if (!"".equals(textNombre.getText()) && !"".equals(textIBAN.getText())) {
            if (!"".equals(textSaldo.getText()) && textSaldo.getText().matches("^[0-9]+\\.?[0-9]*")) {
                BufferedWriter fIBAN = new BufferedWriter(new FileWriter("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\" + textIBAN.getText() + ".cuenta"));
                fCuentas.write("\n" + textIBAN.getText());
                fIBAN.write(textNombre.getText() + "\n" + textSaldo.getText() + "\n" + textSaldo.getText());
                fIBAN.close();
            } else if("".equals(textSaldo.getText())){
                BufferedWriter fIBAN = new BufferedWriter(new FileWriter("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\" + textIBAN.getText() + ".cuenta"));
                fCuentas.write("\n" + textIBAN.getText());
                fIBAN.write(textNombre.getText());
                fIBAN.close();
            }
        }
        fCuentas.close();
        

        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

}
