package cuatroenraya;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CuatroEnRaya extends Application {

    private boolean turno = true;
    private int[] libre = {5, 5, 5, 5, 5, 5, 5};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        GridPane tablero = new GridPane();

        tablero.setGridLinesVisible(true);

        tablero.setHgap(1);
        tablero.setVgap(1);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                tablero.add(new Rectangle(100, 100, Color.YELLOW), i, j);
            }
        }

        Button btnCol1 = new Button("Ficha");
        Button btnCol2 = new Button("Ficha");
        Button btnCol3 = new Button("Ficha");
        Button btnCol4 = new Button("Ficha");
        Button btnCol5 = new Button("Ficha");
        Button btnCol6 = new Button("Ficha");
        Button btnCol7 = new Button("Ficha");

        btnCol1.setMinWidth(100);
        btnCol2.setMinWidth(100);
        btnCol3.setMinWidth(100);
        btnCol4.setMinWidth(100);
        btnCol5.setMinWidth(100);
        btnCol6.setMinWidth(100);
        btnCol7.setMinWidth(100);

        tablero.add(btnCol1, 0, 6);
        tablero.add(btnCol2, 1, 6);
        tablero.add(btnCol3, 2, 6);
        tablero.add(btnCol4, 3, 6);
        tablero.add(btnCol5, 4, 6);
        tablero.add(btnCol6, 5, 6);
        tablero.add(btnCol7, 6, 6);

        btnCol1.setOnAction(event -> colocaFicha(0, tablero));
        btnCol2.setOnAction(event -> colocaFicha(1, tablero));
        btnCol3.setOnAction(event -> colocaFicha(2, tablero));
        btnCol4.setOnAction(event -> colocaFicha(3, tablero));
        btnCol5.setOnAction(event -> colocaFicha(4, tablero));
        btnCol6.setOnAction(event -> colocaFicha(5, tablero));
        btnCol7.setOnAction(event -> colocaFicha(6, tablero));

        Scene escena = new Scene(tablero);
        
        stage.setScene(escena);
        stage.setTitle("Cuatro En Raya");
        stage.show();
    }

    private void colocaFicha(int col, GridPane tablero) {
        if (libre[col] >= 0) {

            int filaLibre = libre[col];
            
            if (turno) {
                tablero.add(new Circle(50, Color.RED), col, filaLibre);
                turno = false;
            } else {
                tablero.add(new Circle(50, Color.BLUE), col, filaLibre);
                turno = true;
            }

            libre[col]--;
        }
    }

}
