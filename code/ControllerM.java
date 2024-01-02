/*
Description:
This code is the controller for a multiplayer Tic-Tac-Toe game implemented in JavaFX.
It allows two players to take turns playing the game. The buttons represent
the Tic-Tac-Toe grid, and each player can click on a button to place their symbol
(X or O) on the board. The code checks for winning conditions and disables the
buttons once the game is over. There is an option to restart the game or exit the application.

Students:
- Ameera Attiah S21107316
- Leen Sharab S21107195
- Sarah Alshumayri S20106125
*/
package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class ControllerM implements Initializable {
    Random random = new Random();

    ArrayList<Button> buttons;

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;

    @FXML
    private Text winnerText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));

        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tic-Tac-Toe");
    }

    @FXML
    void exitGame(ActionEvent event) {
        buttons.forEach(this::exitButton);

        // get the current scene
        Scene scene = ((Node) event.getSource()).getScene();
        // get the stage from the scene and close it
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    public void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
        button.setStyle("-fx-background-color: ##FFFFFF;\n");
    }

    public void exitButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }

    private boolean isPlayerOneTurn = true;

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            if (isPlayerOneTurn) {
                winnerText.setText("O's Turn!");
                button.setText("X");
                button.setStyle("-fx-background-color: #FF0000;\n" +
                        "    -fx-text-fill: black;\n" +
                        "    -fx-font-size: 34px;");
                checkIfGameIsOver();
            } else {
                winnerText.setText("X's Turn!");
                button.setText("O");
                button.setStyle("-fx-background-color: #0000FF;\n" +
                        "    -fx-text-fill: black;\n" +
                        "    -fx-font-size: 34px;");
                checkIfGameIsOver();
            }
            button.setDisable(true);

            isPlayerOneTurn = !isPlayerOneTurn;
        });
    }


    public void checkIfGameIsOver() {
        boolean isGameOver = false; // Assume game is not over unless a winning condition is found or there are no empty buttons

        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };

            // X winner
            if (line.equals("XXX")) {
                winnerText.setText("X won!");
                buttons.forEach(button -> {
                    button.setDisable(true);
                });
                isGameOver = true;
                break; // Exit the loop, as the game is already won
            }

            // O winner
            else if (line.equals("OOO")) {
                winnerText.setText("O won!");
                buttons.forEach(button -> {
                    button.setDisable(true);
                });
                isGameOver = true;
                break; // Exit the loop, as the game is already won
            }
        }

        // Check if the game is over due to no winning condition or no empty buttons
        if (!isGameOver) {
            boolean allButtonsFilled = buttons.stream().noneMatch(button -> button.getText().isEmpty());
            if (allButtonsFilled) {
                winnerText.setText("Game Over!"); // Display "Game over!" if no one won and no empty buttons left
            }
        }
    }
}


