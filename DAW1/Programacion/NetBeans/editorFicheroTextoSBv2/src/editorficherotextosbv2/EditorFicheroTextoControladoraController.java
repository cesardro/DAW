/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorficherotextosbv2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zx21student278
 */
public class EditorFicheroTextoControladoraController implements Initializable {

    @FXML
    private Button btnSalir;
    @FXML
    private Button btnAbrir;
    @FXML
    private TextArea textArea;
    @FXML
    private VBox principal;
    
    Stage stage;
    
    private static File fichero;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void abrirFichero(ActionEvent event) {
        FileChooser vtnFicheroNuevo = new FileChooser();
        vtnFicheroNuevo.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Ficheros de texto.", "*.txt"),
                new FileChooser.ExtensionFilter("Ficheros de HTML.", "*.html"));
        fichero = vtnFicheroNuevo.showOpenDialog(stage = (Stage) principal.getScene().getWindow());

        try {
            BufferedReader fLectura = new BufferedReader(new FileReader(fichero));

            char[] linea = new char[(int) fichero.length()];
            fLectura.read(linea, 0, (int) fichero.length());
            textArea.setText(new String(linea));
            fLectura.close();
        } catch (IOException ex) {
        }
    }
    
}
