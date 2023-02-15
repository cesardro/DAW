package calculadoraventanav1;

import static java.lang.Integer.parseInt;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculadoraVentanaV1 extends Application {

    private TextField textField;
    private int op1 = 0, op2 = 0, estado = 0;
    private String cadena = "";
    private char operando = ' ';
    private boolean flag = true, cont = true, numNegativo1 = true, numNegativo2 = true;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Button[] btn = {new Button("1"), //0
            new Button("2"), //1
            new Button("3"), //2
            new Button("+"), //3
            new Button("4"), //4
            new Button("5"), //5
            new Button("6"), //6
            new Button("-"), //7
            new Button("7"), //8
            new Button("8"), //9
            new Button("9"), //10
            new Button("*"), //11
            new Button("B"), //12
            new Button("0"), //13
            new Button("="), //14
            new Button("/"), //15
            new Button("+/-")}; //16

        textField = new TextField();
        textField.setMinSize(40, 40);
        GridPane principal = new GridPane();

        principal.add(textField, 0, 0, 4, 1);
        principal.add(btn[0], 0, 1);
        principal.add(btn[1], 1, 1);
        principal.add(btn[2], 2, 1);
        principal.add(btn[3], 3, 1);
        principal.add(btn[4], 0, 2);
        principal.add(btn[5], 1, 2);
        principal.add(btn[6], 2, 2);
        principal.add(btn[7], 3, 2);
        principal.add(btn[8], 0, 3);
        principal.add(btn[9], 1, 3);
        principal.add(btn[10], 2, 3);
        principal.add(btn[11], 3, 3);
        principal.add(btn[12], 0, 4);
        principal.add(btn[13], 1, 4);
        principal.add(btn[14], 2, 4);
        principal.add(btn[15], 3, 4);
        principal.add(btn[16], 1, 5);

        for (Button button : btn) {
            button.setMinSize(40, 40);
        }

        //Espacio entre horizontales.
        principal.setHgap(20);

        //Espacio entre verticales.
        principal.setVgap(10);

        for (Button button : btn) {
            button.setOnAction((event) -> {
                numeros(button.getText());
            });
        }

        principal.setPadding(new Insets(10));
        Scene scene = new Scene(principal);
        stage.setScene(scene);
        stage.show();
    }

    private void numeros(String x) {

        /*
        Esta bandera es para que la calculadora se reinicie despues de darle =
        y que nos arroje un resultado, si no hay resultado no se reinicia porque el 
        = seria invalido
        */
        if(!flag){
            
            estado = 0;
            op1 = 0;
            op2 = 0;
            cadena = "";
            operando = ' ';
            textField.setText(cadena);
            flag = true;
            numNegativo1 = true;
            numNegativo2 = true;
        }
        
        switch(x){
            case "+", "-", "/", "*":
                if(!cont){
                    operando = x.charAt(0);
                    cadena += x;
                    textField.setText(cadena);
                    cont = true;
                    estado = 1;
                    numNega();
                }
                break;
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0":
                if(estado == 0){
                    op1(x);
                    cadena += x;
                    textField.setText(cadena);
                    cont = false;
                }else if(estado == 1){
                    op2(x);
                    cadena += x;
                    textField.setText(cadena);
                }
                break;
            case "=":
                if(operando != ' '){
                    numNega();
                    solucion();
                    flag = false;
                }
                break;
            case "B":
                estado = 0;
                op1 = 0;
                op2 = 0;
                cadena = "";
                operando = ' ';
                textField.setText(cadena);
                numNegativo1 = true;
                numNegativo2 = true;
                break;
            case "+/-":
                if(op1 == 0 && estado == 0){
                    cadena += "-";
                    textField.setText(cadena);
                    numNegativo1 = false;
                }else if(op2 == 0 && estado == 1){
                    cadena += "-";
                    textField.setText(cadena);
                    numNegativo2 = false;
                }
        }
    }

    private void numNega(){
        
        if(!numNegativo1){
            op1 = op1 *(-1);
            numNegativo1 = true;
        }
        
        if(!numNegativo2){
            op2 = op2 *(-1);
            numNegativo1 = true;
        }
    }
    
    private void op1(String x) {

        int num = parseInt(x);
        if (op1 == 0) {
            op1 = num;
        } else {
            op1 = op1 * 10 + num;
        }
    }

    private void op2(String x) {

        int num = parseInt(x);
        if (op2 == 0) {
            op2 = num;
        } else {
            op2 = op2 * 10 + num;
        }
    }

    private void solucion() {

        switch (operando) {
            case '+':
                cadena = cadena + "=" + String.valueOf(op1 + op2);
                textField.setText(cadena);
                break;
            case '-':
                cadena = cadena + "=" + Integer.toString(op1 - op2);
                textField.setText(cadena);
                break;
            case '/':
                cadena = cadena + "=" + Integer.toString(op1 / op2);
                textField.setText(cadena);
                break;
            case '*':
                cadena = cadena + "=" + Integer.toString(op1 * op2);
                textField.setText(cadena);
                break;
            default:
                cadena = "";
                break;
        }
    }

}
