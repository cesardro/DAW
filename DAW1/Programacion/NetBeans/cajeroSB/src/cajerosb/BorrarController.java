package cajerosb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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

public class BorrarController implements Initializable {

    @FXML
    private AnchorPane principal;
    @FXML
    private Label labelIBAN;
    @FXML
    private Label labelNombre;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelIBAN.setText(CajeroSB.iban);
        Cuenta cuenta = FXMLController.mapaDatos.get(CajeroSB.iban);
        labelNombre.setText(cuenta.getTitular());
    }    

    @FXML
    private void aceptar(ActionEvent event) throws IOException {
                
        ArrayList<String> temporal = new ArrayList<>();
        BufferedReader recogerDatos = new BufferedReader(new FileReader("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\cuentas.dat"));
        String linea = recogerDatos.readLine();
        while(linea != null){
            if(!linea.equals(labelIBAN.getText())){
                temporal.add(linea);
            }
            linea = recogerDatos.readLine();
        }
        reescribirFicheroIBAN(temporal);
        
        CajeroSB.iban = "IBAN";
        CajeroSB.saldo = "";

        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        Files.delete(Paths.get("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\"+labelIBAN.getText()+".cuenta"));
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    private void reescribirFicheroIBAN(ArrayList<String> temporal) throws IOException {
        try (BufferedWriter fichero = new BufferedWriter(new FileWriter("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\cuentas.dat"))) {
            for (int i = 0; i < temporal.size(); i++) {
                if(i+1!=temporal.size()){
                    fichero.append(temporal.get(i)+"\n");
                }else{
                    fichero.append(temporal.get(i));
                }
            }
        }
    }
}
