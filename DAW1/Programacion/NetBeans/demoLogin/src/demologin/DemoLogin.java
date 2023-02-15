package demologin;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoLogin extends Application{
    
    private Scene escenaLogin;
    private Scene escenaPrincipal;
    private TextField usuario;
    private PasswordField pass;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        
        VBox vLogin = new VBox();
        
        usuario = new TextField();
        usuario.setPromptText("Usuario");
        
        pass = new PasswordField();
        pass.setPromptText("Contraseña");
        
        Button btnEntrar = new Button("Entrar");
        
        usuario.setFocusTraversable(false);
        pass.setFocusTraversable(false);
        btnEntrar.requestFocus();
        
        Label error = new Label("");
        error.setId("errorLogin"); //Etiqueta para css.
        
        vLogin.getChildren().addAll(usuario, pass, btnEntrar, error);
        
        escenaLogin = new Scene(vLogin, 400, 200);
        escenaLogin.getStylesheets().add("estilos/aplicacion.css");
        
        
        btnEntrar.setOnAction(event -> {
            if (validaUsuario(usuario.getText(), pass.getText())) {
                entrar(stage);
            }else{
                errorLogin(error, "Error en usuario o contraseña.");
            }
        });
        
        vLogin.setPadding(new Insets(10));
        vLogin.setSpacing(10);
        
        stage.setScene(escenaLogin);
        stage.setTitle("Demo de Login");
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
        
        Button btnSalir = new Button("Cerrar sesión");
        
        StackPane ventana = new StackPane(btnSalir);
        
        escenaPrincipal = new Scene(ventana, 800, 400);
        
        stage.setScene(escenaPrincipal);
        
        btnSalir.setOnAction(event -> {
            usuario.setText("");
            pass.setText("");
            stage.setScene(escenaLogin);
        });
    }

    private void errorLogin(Label entrar, String err) {
        entrar.setText(err);
    }
    
}
