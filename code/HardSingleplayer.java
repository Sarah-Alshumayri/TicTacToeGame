/*
Description:
This code represents the implementation of the Hard Singleplayer mode for a
Tic-Tac-Toe game. It extends the JavaFX Application class, loads the corresponding
FXML file for the user interface, sets a shadow effect on the root element, and
applies a CSS stylesheet for styling. The game is launched in a new stage/window
titled "Hard Single Player."

Students:
- Ameera Attiah S21107316
- Leen Sharab S21107195
- Sarah Alshumayri S20106125
*/
package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HardSingleplayer extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hardS.fxml"));
        primaryStage.setTitle("Hard Single Player");
        //shadow effect
        InnerShadow effect = new InnerShadow();
        effect.setHeight(34.63);
        effect.setWidth(81.34);
        effect.setRadius(28.4925);
        root.setEffect(effect);

        primaryStage.setScene(new Scene(root));
        File f = new File("C:\\Users\\samal\\Desktop\\projectf\\src\\main\\resources\\com\\example\\project\\style.css");
        root.getStylesheets().clear();
        root.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
