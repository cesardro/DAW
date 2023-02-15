package pruebasbv3;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLpruebaSBv3Controller implements Initializable {
    
    private static File fichero;

    @FXML
    private Button btnAbrir;
    @FXML
    private TextArea textArea;
    @FXML
    private AnchorPane principal;
    
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void abrir(ActionEvent event) {
         
        
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
