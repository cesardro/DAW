package cajerosb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private AnchorPane principal;
    @FXML
    private Label ibanTitulo;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnSacar;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnMov;

    private File fichero;
    @FXML
    private ListView<String> listaCuenta;
    @FXML
    private ListView<String> listaTitular;
    
    @FXML
    private TextField textField;
    
    public static HashMap<String, Cuenta> mapaDatos = new HashMap<>();
        
    private Cuenta cuenta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ibanTitulo.setText(CajeroSB.iban);
        textField.setText(CajeroSB.saldo);
        
        try {
            BufferedReader cuentasDat = new BufferedReader(new FileReader("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\cuentas.dat"));
            String linea = cuentasDat.readLine();
            while (linea != null) {
                BufferedReader ibanCuenta = new BufferedReader(new FileReader("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\" + linea + ".cuenta"));
                String lineaCuenta = ibanCuenta.readLine();
                listaCuenta.getItems().addAll(linea);
                listaTitular.getItems().addAll(lineaCuenta);
                guardarInformacion(linea, lineaCuenta, ibanCuenta);
                linea = cuentasDat.readLine();
                ibanCuenta.close();
            }
            cuentasDat.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ingresar(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Ingresar.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setTitle("Ingresar dinero");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sacar(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Sacar.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setTitle("Sacar dinero");
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void crear(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Crear.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setTitle("Crear Datos Usuario");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void borrar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Borrar.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setTitle("Crear Datos Usuario");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void mov(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Movimientos.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setTitle("Movimientos");
        stage.setScene(scene);
        stage.show();
    }

    private void guardarInformacion(String linea, String lineaCuenta, BufferedReader ibanCuenta) throws IOException {
        String saldo = ibanCuenta.readLine();
        if (saldo != null) {
            cuenta = new Cuenta(linea, lineaCuenta, Double.parseDouble(saldo));
            String historial = ibanCuenta.readLine();
            while (historial != null) {
                if (historial != null) {
                    cuenta.añadirHistorial(Double.parseDouble(historial));
                    historial = ibanCuenta.readLine();
                }
            }
            mapaDatos.put(linea, cuenta);
        } else {
            cuenta = new Cuenta(linea, lineaCuenta);
            mapaDatos.put(linea, cuenta);
        }
    }

    @FXML
    private void cuentaClick(MouseEvent event) {
        CajeroSB.iban = listaCuenta.getSelectionModel().getSelectedItem();
        ibanTitulo.setText(CajeroSB.iban);
        cuenta = mapaDatos.get(CajeroSB.iban);
        textField.setText(Double.toString(cuenta.getSaldo()));
        CajeroSB.saldo = Double.toString(cuenta.getSaldo());
    }

    public void reescribirFichero(ArrayList<String> temporal) {
        try {
            BufferedWriter fichero = new BufferedWriter(new FileWriter("C:\\Users\\aleja\\OneDrive\\Escritorio\\Cajero SB\\" + CajeroSB.iban + ".cuenta"));
            for (int i = 0; i < temporal.size(); i++) {
                fichero.append(temporal.get(i) + "\n");
            }
            fichero.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
