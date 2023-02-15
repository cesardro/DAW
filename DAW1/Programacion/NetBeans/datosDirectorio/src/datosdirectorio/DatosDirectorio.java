package datosdirectorio;

import java.io.File;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DatosDirectorio extends Application {
    
    private TableView dataTable;
    private File fDir;
    private TextField directoryPath;

    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage stage){
        
        String directorio = "C:\\Users\\zx21student278\\Desktop";
        
        fDir = new File(directorio);
        
        Label directoryLbl = new Label("Directorio");
        
        directoryPath = new TextField(fDir.getAbsolutePath());
        
        Button btnUp = new Button("Subir");
        
        btnUp.setOnAction(event->{
            
            subir();
        });
        
        //Ancho del textfield.
        directoryPath.setMinWidth(225);
        
        HBox head = new HBox(directoryLbl, directoryPath, btnUp);
        
        head.setSpacing(15);
        
        dataTable = new TableView();
        
        //Crear las columnas
        TableColumn<ElementoDir, String> column1 = new TableColumn<>("Nombre");
        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));     
        
        TableColumn<ElementoDir, String> column2 = new TableColumn<>("Directorio");
        column2.setCellValueFactory(new PropertyValueFactory<>("dir"));
        
        TableColumn<ElementoDir, String> column3 = new TableColumn<>("Tamaño");
        column3.setCellValueFactory(new PropertyValueFactory<>("tam"));
        
        //Añadir las columnas.
        dataTable.getColumns().add(column1);
        dataTable.getColumns().add(column2);
        dataTable.getColumns().add(column3);

        //Captura el click.
        dataTable.setOnMouseClicked(event->{
            cambiaDatosTabla(event);
        });
        
        //Añadir datos.
        rellenarTabla();

        VBox principal = new VBox(head, dataTable);
        
        Scene scene = new Scene(principal);
        
        principal.setPadding(new Insets(15));
        
        stage.setTitle("Mostrar directorio");
        stage.setScene(scene);
        stage.show();
    }

    private void rellenarTabla() {
        
        //Limpia la tabla.
        dataTable.getItems().clear();
        
        //comprobar si existe el fichero o directorio.
        if(fDir.exists()){
            
            File[] contenidoListado = fDir.listFiles();
            for (File elementoFichero : contenidoListado) {
                
                String d = "Fichero";
                if(elementoFichero.isDirectory()){
                    
                    d = "Directorio";
                }
                dataTable.getItems().add(new ElementoDir(elementoFichero.getName(), d, elementoFichero.length()));
            }
        }
        
    }    

    private void cambiaDatosTabla(MouseEvent event) {
    
        //Saber en que fila ha pinchado.
        TableViewSelectionModel<ElementoDir> seleccion = dataTable.getSelectionModel();
        
        //Filas seleccionadas.
        ObservableList<ElementoDir> filaSeleccionada = seleccion.getSelectedItems();
        
        //Para saber si da doble click.
        if(event.getClickCount() == 2){
            
            if(filaSeleccionada.get(0).getDir().equals("Directorio")){
                
                fDir = new File(fDir.getAbsolutePath()+"//"+filaSeleccionada.get(0).getNombre());
                rellenarTabla();
                directoryPath.setText(fDir.getAbsolutePath());
            }           
        }
    }

    private void subir() {
    
        //Ir al padre del directorio.
        fDir = fDir.getParentFile();
        rellenarTabla();
        directoryPath.setText(fDir.getAbsolutePath());
    }
}
