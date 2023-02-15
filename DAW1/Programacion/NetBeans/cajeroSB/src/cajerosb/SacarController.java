package cajerosb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SacarController implements Initializable {

    @FXML
    private AnchorPane principal;
    @FXML
    private TextField textField;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label iban;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        iban.setText(CajeroSB.iban);
    }

    @FXML
    private void aceptar(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Parent root = loader.load();

        FXMLController controller = loader.getController();

        if ("" != textField.getText() && textField.getText().matches("^[0-9]+\\.?[0-9]*")) {
            int saldoField = Integer.parseInt(textField.getText());
            ArrayList<String> temporal = new ArrayList<String>();
            BufferedReader recogerDatos = new BufferedReader(new FileReader("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\" + iban.getText() + ".cuenta"));
            String linea = recogerDatos.readLine();
            temporal.add(linea);
            linea = recogerDatos.readLine();
            int saldoTemp = Integer.parseInt(linea);
            saldoTemp = saldoTemp - saldoField;
            if (saldoTemp >= 0) {
                CajeroSB.saldo = Integer.toString(saldoTemp);
                temporal.add(String.valueOf(saldoTemp));
                linea = recogerDatos.readLine();
                while (linea != null) {
                    if (linea != null) {
                        temporal.add(linea);
                        linea = recogerDatos.readLine();
                    }
                }
                temporal.add("-" + String.valueOf(saldoField));
                controller.reescribirFichero(temporal);
                System.out.println(temporal);
            } else {
                Alert alerta = new Alert(AlertType.CONFIRMATION);
                alerta.setHeaderText("El monto a retirar es mayor al saldo en cuenta.");
                alerta.setTitle("Alerta del banco");
                ButtonType btnSi = new ButtonType("Entendido", ButtonData.YES);

                alerta.getButtonTypes().setAll(btnSi);
                Optional<ButtonType> action = alerta.showAndWait();

                root = FXMLLoader.load(getClass().getResource("Sacar.fxml"));

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                Scene scene = new Scene(root);

                stage.setTitle("Ingresar dinero");
                stage.setScene(scene);
                stage.show();
            }
            recogerDatos.close();
        } else {
            System.out.println("No valido");
        }

        root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

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
