package cajerosb;

import java.io.BufferedReader;
import java.io.FileReader;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IngresarController implements Initializable {

    @FXML
    private AnchorPane principal;
    @FXML
    private Label iban;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField textField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        iban.setText(CajeroSB.iban);
    }

    @FXML
    private void aceptar(ActionEvent event) throws IOException {
        try {
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
                if (linea != null) {
                    int saldoTemp = Integer.parseInt(linea);
                    saldoTemp = saldoTemp + saldoField;
                    CajeroSB.saldo = Integer.toString(saldoTemp);
                    temporal.add(String.valueOf(saldoTemp));
                    linea = recogerDatos.readLine();
                    while (linea != null) {
                        if (linea != null) {
                            temporal.add(linea);
                            linea = recogerDatos.readLine();
                        }
                    }
                    temporal.add(String.valueOf(saldoField));
                    controller.reescribirFichero(temporal);
                    System.out.println(temporal);
                }else{
                    temporal.add(String.valueOf(saldoField));
                    temporal.add(String.valueOf(saldoField));
                    controller.reescribirFichero(temporal);
                    System.out.println(temporal);
                }
                recogerDatos.close();
            } else {
                System.out.println("No valido");
            }
        } catch (IOException ex) {
            System.out.println("Error");
        }
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

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
