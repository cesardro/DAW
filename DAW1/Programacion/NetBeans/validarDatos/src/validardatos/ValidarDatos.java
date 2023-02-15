package validardatos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ValidarDatos extends Application{
    
    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        //Creamos las etiquetas.
        Label[] label = {new Label("Nombre"),
                         new Label("Apellidos"),
                         new Label("Correo"),
                         new Label("Usuario"),
                         new Label("Contraseña")};
        
        //Creamos los campos de texto.
        TextField[] textField = {new TextField(),
                                 new TextField(),
                                 new TextField(),
                                 new TextField(),
                                 new TextField(),};
        
        //Creamos un nodo ordenado.
        GridPane principal = new GridPane();
        
        //Añadimos las etiquetas al GridPane
        //Funciona como una tabla, el primer numero es la columna y el segundo
        //la fila, se crean segun vamos metiendo columnas o filas.
        for (int i = 0; i < label.length; i++) {
            principal.add(label[i], 0, i);
        }
        
        //Añadimos el TextField al GridPane.
        for (int i = 0; i < label.length; i++) {
            principal.add(textField[i], 1, i);
        }
        
        //Espacio entre horizontales.
        principal.setHgap(10);
        
        //Espacio entre verticales.
        principal.setVgap(10);
        
        //Creamos el boton.
        Button button = new Button();
        
        //Ponemos texto pref al boton.
        button.setText("Registrar");
        
        //Añadimos el boton al GridPane
        principal.add(button, 1, 5);
        
        //Añadimos espacios en los bordes como en HTML.
        principal.setPadding(new Insets(10));
        
        button.setOnAction((event) -> {
            
            validaDatos(event, textField);
        });
        
        //Creamos la escena.
        Scene scene = new Scene(principal);
        
        //Setea la escena que queremos en la ventana.
        stage.setScene(scene);
        
        //Configura el size al escenario automaticamente.
        stage.sizeToScene();
        
        //Muestra la ventana.
        stage.show();
    }

    private void validaDatos(ActionEvent event, TextField[] textField) {
        
        boolean save = true;
        
        for (TextField verificar : textField) {
            
            if(verificar.getText().equals("")){
                
                verificar.setPromptText("Required field.");
                verificar.setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
                save = false;
            }
        }
        
        if(!ValidarFormato.validarNombre(textField[0].getText())){
            
            textField[0].setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
            save = false;
        }
        
        if(!ValidarFormato.validarApellidos(textField[1].getText())){
            
            textField[1].setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
            save = false;
        }
        
        if(!ValidarFormato.validarCorreo(textField[2].getText())){
            
            textField[2].setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
            save = false;
        }
        
        if(!ValidarFormato.validarUsuario(textField[3].getText())){
            
            textField[3].setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
            save = false;
        }
        
        if(!ValidarFormato.validarContraseña(textField[4].getText())){
            
            textField[4].setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
            save = false;
        }
        
        if (save) {
            saveData();
        }
    }

    private void saveData() {
    
        System.out.println("Saving data...");
    }
    
}
