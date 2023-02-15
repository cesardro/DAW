package editordetextov1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EditorDeTextov1 extends Application{

    private static boolean guardado = true;
    private static TextArea campo;
    private static File fichero=null;
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    
        Button btnNuevo = new Button("Nuevo");
        Button btnGuardar = new Button("Guardar");
        Button btnAbrir = new Button("Abrir");
        Button btnSalir = new Button("Salir");
        
        campo = new TextArea();
        
        campo.setOnKeyPressed(event -> {
        
            if (guardado ) {
                
                guardado = false;
                stage.setTitle(stage.getTitle()+"*");
            }     
        });
        
        stage.setHeight(250);
        stage.setWidth(500);
        
        HBox botonera = new HBox(btnNuevo, btnAbrir, btnGuardar, btnSalir);
        
        VBox principal = new VBox(botonera, campo);
        
        principal.setPadding(new Insets(7));
        
        principal.setSpacing(5);
        botonera.setSpacing(10);
        
        Scene scene = new Scene(principal, 600, 250);
        
        btnNuevo.setOnAction(event ->{
           
            ficheroNuevo(stage);
        });
        
        btnAbrir.setOnAction(event ->{
           
            ficheroAbrir(stage);
        });
        
        btnGuardar.setOnAction(event ->{
           
            ficheroGuardar(stage);
        });
        
        btnSalir.setOnAction(event ->{
           
            editorSalir();
        });
        
        
        stage.setScene(scene);
        stage.setTitle("Editor de Texto - Fichero Nuevo");
        stage.show();
    }

    private void ficheroNuevo(Stage stage) {
        
        if (guardado) {
            
            campo.setText("");
            stage.setTitle("Editor de texto - Nuevo");
        }else{
            Alert alerta = new Alert(AlertType.CONFIRMATION);
            alerta.setHeaderText("¿Quieres guardar el fichero?");
            alerta.setTitle("Confirmación");
            ButtonType btnSi = new ButtonType("Si", ButtonData.YES);
            ButtonType btnNo = new ButtonType("No", ButtonData.NO);
            ButtonType btnCancelar = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
            
            alerta.getButtonTypes().setAll(btnSi, btnNo, btnCancelar);
            Optional<ButtonType> action = alerta.showAndWait();
            
            if (action.get() == btnSi) {
                System.out.println("Guardar");
                ficheroGuardar(stage);
                campo.setText("");
            }else if(action.get() == btnNo){
                System.out.println("No guardar");
            }else{
                System.out.println("Cancelar");
            }
        }
    }

    private void ficheroGuardar(Stage stage) {
        if(fichero == null){
            FileChooser vtnFicheroNuevo = new FileChooser();
            fichero = vtnFicheroNuevo.showSaveDialog(stage);
        }
        
        try {
            BufferedWriter fEscritura = new BufferedWriter(new FileWriter(fichero));
            fEscritura.write(campo.getText());
            fEscritura.close();
            guardado = true;
            stage.setTitle("Editor de texto - "+fichero.getName());
        } catch (IOException ex) {
            Logger.getLogger(EditorDeTextov1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void ficheroAbrir(Stage stage) {

        boolean abrir = true;
        if(!guardado){
            Alert alerta = new Alert(AlertType.CONFIRMATION);
            alerta.setHeaderText("¿Quieres guardar el fichero?");
            alerta.setTitle("Alerta de Guardado.");
            ButtonType btnSi = new ButtonType("Si", ButtonData.YES);
            ButtonType btnNo = new ButtonType("No", ButtonData.NO);
            ButtonType btnCancelar = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
            
            alerta.getButtonTypes().setAll(btnSi, btnNo, btnCancelar);
            Optional<ButtonType> action = alerta.showAndWait();
            
            if (action.get() == btnSi) {
                System.out.println("Guardar");
                ficheroGuardar(stage);
                campo.setText("");
            }else if(action.get() == btnNo){
                System.out.println("No guardar");
            }else{
                System.out.println("Cancelar");
            }
            guardado = true;
            stage.setTitle("Editor de texto - Nuevo");
        }
        
        if (abrir) {
            FileChooser vtnFicheroNuevo = new FileChooser();
            vtnFicheroNuevo.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Ficheros de texto.", "*.txt"),
                    new FileChooser.ExtensionFilter("Ficheros de HTML.", "*.html"));
            fichero = vtnFicheroNuevo.showOpenDialog(stage);

            try {
                BufferedReader fLectura = new BufferedReader(new FileReader(fichero));
                
                char[] linea = new char[(int)fichero.length()];
                fLectura.read(linea, 0, (int)fichero.length());
                
                /*String linea = fLectura.readLine();
                String contenido = "";
                campo.setText("");
                while (linea != null) {
                    contenido = contenido + linea + "\n";
                    linea = fLectura.readLine();
                }
                campo.setText(contenido);*/
                campo.setText(new String(linea));
                stage.setTitle("Editor de texto - "+fichero.getName());
                fLectura.close();
            } catch (IOException ex) {
                Logger.getLogger(EditorDeTextov1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    private void editorSalir() {
        
        System.exit(0);
    }
    
}
