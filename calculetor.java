package javaapplication20;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class NewClass extends Application {

    private TextField display = new TextField();
    private double firstNumber = 0;
    private String operator = "";

    @Override
    public void start(Stage stage) {

        display.setPrefHeight(50);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(display, 0, 0, 4, 1);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        int row = 1;
        int col = 0;

        for (String text : buttons) {
            Button button = new Button(text);
            button.setPrefSize(60, 60);

            button.setOnAction(e -> handleButton(text));

            grid.add(button, col, row);

            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        Scene scene = new Scene(grid, 300, 350);

        stage.setTitle("JavaFX Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void handleButton(String value) {

        if (value.matches("[0-9]")) {
            display.appendText(value);
        }

        else if (value.matches("[+\\-*/]")) {
            firstNumber = Double.parseDouble(display.getText());
            operator = value;
            display.clear();
        }

        else if (value.equals("=")) {

            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;

                case "-":
                    result = firstNumber - secondNumber;
                    break;

                case "*":
                    result = firstNumber * secondNumber;
                    break;

                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }

            display.setText(String.valueOf(result));
        }

        else if (value.equals("C")) {
            display.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
