package listadoalumnos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListadoAlumnos extends Application{
    
    private TableView tablaDatos;
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        Label[] label = {new Label("Nombre"), new Label("Ciclo"), new Label("Curso")};
        
        TextField[] campo = {new TextField(), new TextField(), new TextField()};
        
        Button btnGuardar = new Button("Guardar");
        
        tablaDatos = new TableView();
        
        TableColumn<alumnos, String> column1 = new TableColumn<>("Nombre");
        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));     
        
        TableColumn<alumnos, String> column2 = new TableColumn<>("Ciclo");
        column2.setCellValueFactory(new PropertyValueFactory<>("ciclo"));
        
        TableColumn<alumnos, String> column3 = new TableColumn<>("Curso");
        column3.setCellValueFactory(new PropertyValueFactory<>("curso"));
        
        tablaDatos.getColumns().add(column1);
        tablaDatos.getColumns().add(column2);
        tablaDatos.getColumns().add(column3);
        
        btnGuardar.setOnAction(event -> {
            validarInformacion(label, campo);
            rellenarDatos();
        });
        
        VBox principal = new VBox(label[0], campo[0], label[1], campo[1], label[2], campo[2], btnGuardar, tablaDatos);
        
        principal.setSpacing(5);
        
        Scene scene = new Scene(principal);
        
        principal.setPadding(new Insets(15));
        
        rellenarDatos();
        
        stage.setTitle("Listado Alumnos");
        stage.setScene(scene);
        stage.show();
    }

    private void validarInformacion(Label[] label, TextField[] campo) {
        
        if(!"".equals(label[0].getText()) && !"".equals(label[1].getText()) && !"".equals(label[2].getText())){
            if("DAW".equals(campo[1].getText()) || "SMR".equals(campo[1].getText())){
                if("primero".equals(campo[2].getText()) || "segundo".equals(campo[2].getText())){
                    alumnos informacion = new alumnos(campo[0].getText(), campo[1].getText(), campo[2].getText());
                    try {
                        BufferedWriter fichero = new BufferedWriter(new FileWriter("C:\\Users\\zx21student278\\Desktop\\Datos\\datosAlumnos.dat", true));
                        String linea = (campo[0].getText()+";"+campo[1].getText()+";"+campo[2].getText());
                        fichero.write(linea+"\n");
                        tablaDatos.getItems().add(informacion);
                        fichero.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ListadoAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private void rellenarDatos(){
        
        tablaDatos.getItems().clear();
        
        File blocNotas = new File("C:\\Users\\zx21student278\\Desktop\\Datos\\datosAlumnos.dat");
        
        if(blocNotas.exists()){
            try {
                BufferedReader leerInfo = new BufferedReader(new FileReader("C:\\Users\\zx21student278\\Desktop\\Datos\\datosAlumnos.dat"));
                String linea = leerInfo.readLine();
                String contenido = "";
                while(linea != null){
                    contenido = contenido + linea + "\n";
                    if(linea != null){
                        String[] trozos = linea.split(";");
                        tablaDatos.getItems().add(new alumnos(trozos[0], trozos[1], trozos[2]));
                    }
                    linea = leerInfo.readLine();
                }
                leerInfo.close();
            } catch (IOException ex) {
                Logger.getLogger(ListadoAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
