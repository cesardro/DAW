package ventanaregistropacientes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaRegistroPacientes extends Application {

    private TextField usuario;
    private PasswordField pass;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox vLogin = new VBox();

        vLogin.setPadding(new Insets(10));
        vLogin.setSpacing(10);

        usuario = new TextField();
        usuario.setPromptText("Usuario");

        pass = new PasswordField();
        pass.setPromptText("Contraseña");

        Button btnEntrar = new Button("Entrar");

        Label error = new Label("");
        error.setId("errorLogin");

        vLogin.getChildren().addAll(usuario, pass, btnEntrar, error);

        Scene loginScene = new Scene(vLogin, 400, 200);
        loginScene.getStylesheets().add("estilos/aplicacion.css");

        btnEntrar.setOnAction(event -> {
            if (validaUsuario(usuario.getText(), pass.getText())) {
                entrar(stage);
            } else {
                errorLogin(error, "Error en usuario o contraseña.");
            }
        });

        stage.setScene(loginScene);
        stage.setTitle("Registro Pacientes - Login");
        stage.show();
    }

    private boolean validaUsuario(String usu, String pass) {

        boolean resp = false;        
                
        if((usu.equals("pepe")&&(pass.equals("1234")))){
            resp=true;
        }
        return resp;
    }

    private void entrar(Stage stage) {

        Label ingresoPaciente = new Label("Ingreso de paciente");
        ingresoPaciente.setId("ingresoPaciente");

        Label[] label = {new Label("Nombre del paciente: "), new Label("Fecha de ingreso: "), new Label("Síntomas: "),
            new Label("Doctor: "), new Label("Análisis: "), new Label("Radiografía"), new Label("Traslado: ")};

        BorderPane borderPane = new BorderPane();

        BorderPane.setAlignment(ingresoPaciente, Pos.CENTER);
        borderPane.setTop(ingresoPaciente);

        GridPane principal = new GridPane();
        principal.setHgap(20);
        principal.setVgap(15);

        for (int i = 0; i < label.length; i++) {
            principal.add(label[i], 0, i);
        }
        TextField campoPaciente = new TextField();
        principal.add(campoPaciente, 1, 0);

        DatePicker ingreso = new DatePicker();
        ingreso.setCursor(Cursor.HAND);
        principal.add(ingreso, 1, 1);

        TextArea campoSintomas = new TextArea();
        campoSintomas.setPrefHeight(100);
        campoSintomas.setPrefWidth(225);
        principal.add(campoSintomas, 1, 2);

        TextField campoDoctor = new TextField();
        principal.add(campoDoctor, 1, 3);

        RadioButton radioAnalisisSi = new RadioButton("Si");
        radioAnalisisSi.setCursor(Cursor.HAND);
        RadioButton radioAnalisisNo = new RadioButton("No");
        radioAnalisisNo.setCursor(Cursor.HAND);
        ToggleGroup analisisGrupo = new ToggleGroup();
        radioAnalisisSi.setToggleGroup(analisisGrupo);
        radioAnalisisNo.setToggleGroup(analisisGrupo);
        HBox hAnalisis = new HBox(radioAnalisisSi, radioAnalisisNo);
        hAnalisis.setSpacing(10);
        principal.add(hAnalisis, 1, 4);

        RadioButton radioRadiografiaSi = new RadioButton("Si");
        radioRadiografiaSi.setCursor(Cursor.HAND);
        RadioButton radioRadiografiaNo = new RadioButton("No");
        radioRadiografiaNo.setCursor(Cursor.HAND);
        ToggleGroup radiografiaGrupo = new ToggleGroup();
        radioRadiografiaSi.setToggleGroup(radiografiaGrupo);
        radioRadiografiaNo.setToggleGroup(radiografiaGrupo);
        HBox hRadiografia = new HBox(radioRadiografiaSi, radioRadiografiaNo);
        hRadiografia.setSpacing(10);
        principal.add(hRadiografia, 1, 5);

        RadioButton radioTrasladoSi = new RadioButton("Si");
        radioTrasladoSi.setCursor(Cursor.HAND);
        RadioButton radioTrasladoNo = new RadioButton("No");
        radioTrasladoNo.setCursor(Cursor.HAND);
        ToggleGroup trasladoGrupo = new ToggleGroup();
        radioTrasladoSi.setToggleGroup(trasladoGrupo);
        radioTrasladoNo.setToggleGroup(trasladoGrupo);
        HBox hTraslado = new HBox(radioTrasladoSi, radioTrasladoNo);
        hTraslado.setSpacing(10);
        principal.add(hTraslado, 1, 6);

        borderPane.setCenter(principal);

        Button btnBorrarDatos = new Button("Borrar Datos");
        btnBorrarDatos.setCursor(Cursor.HAND);
        Button btnGuardar = new Button("Guardar");
        btnGuardar.setCursor(Cursor.HAND);

        HBox botonera = new HBox(btnGuardar, btnBorrarDatos);
        botonera.setSpacing(20);
        botonera.setPadding(new Insets(20, 0, 20, 200));

        borderPane.setBottom(botonera);

        Scene principalScene = new Scene(borderPane, 400, 400);

        borderPane.setPadding(new Insets(10));
        BorderPane.setMargin(ingresoPaciente, (new Insets(10)));

        principalScene.getStylesheets().add("estilos/aplicacion2.css");

        btnBorrarDatos.setOnAction(event -> {
            borrarDatos(campoPaciente, ingreso, campoSintomas, campoDoctor, analisisGrupo, radiografiaGrupo, trasladoGrupo);
        });

        btnGuardar.setOnAction(event -> {
            guardarDatos(campoPaciente, ingreso, campoSintomas, campoDoctor, analisisGrupo, radiografiaGrupo, trasladoGrupo);
        });

        stage.setScene(principalScene);
        stage.setTitle("Registro Pacientes - Registrar");
    }

    private void errorLogin(Label entrar, String err) {
        entrar.setText(err);
    }

    private void guardarDatos(TextField campoPaciente, DatePicker ingreso, TextArea campoSintomas, TextField campoDoctor, ToggleGroup analisisGrupo, ToggleGroup radiografiaGrupo, ToggleGroup trasladoGrupo) {

        try {
            BufferedWriter fichero = new BufferedWriter(new FileWriter("C:\\Users\\zx21student278\\Desktop\\Datos\\registroEntrada.dat", true));
            String linea = campoPaciente.getText() + "," + ingreso.getValue() + "," + campoSintomas.getText() + "," + campoDoctor.getText() + "," + ((RadioButton) analisisGrupo.getSelectedToggle()).getText() + "," + ((RadioButton) radiografiaGrupo.getSelectedToggle()).getText() + "," + ((RadioButton) trasladoGrupo.getSelectedToggle()).getText();
            fichero.write(linea + "\n");
            borrarDatos(campoPaciente, ingreso, campoSintomas, campoDoctor, analisisGrupo, radiografiaGrupo, trasladoGrupo);
            fichero.close();
        } catch (IOException ex) {
            Logger.getLogger(VentanaRegistroPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void borrarDatos(TextField campoPaciente, DatePicker ingreso, TextArea campoSintomas, TextField campoDoctor, ToggleGroup analisisGrupo, ToggleGroup radiografiaGrupo, ToggleGroup trasladoGrupo) {
        
        campoPaciente.setText("");
        ingreso.getEditor().clear();
        campoSintomas.setText("");
        campoDoctor.setText("");
        analisisGrupo.selectToggle(null);
        radiografiaGrupo.selectToggle(null);
        trasladoGrupo.selectToggle(null);
    }

}
