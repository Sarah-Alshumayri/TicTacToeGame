/*
Description:
This code represents the main class TicTacToe for a Tic-Tac-Toe game application.
It creates a graphical user interface using JavaFX, including a vertical box layout
with buttons for single player and multiplayer modes. The UI features a title label,
an image, and applies styling effects. It also sets up the scene, loads external CSS stylesheets,
and displays the game window.

Students:
- Ameera Attiah S21107316
- Leen Sharab S21107195
- Sarah Alshumayri S20106125
*/
package com.example.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.io.File;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {

        //vertical box
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(335, 600);
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.setStyle("-fx-background-color: WHITE;");

        //welcome title
        Label welcomeText = new Label("TIC-TAC-TOE");
        welcomeText.setPrefSize(221, 73);
        welcomeText.setFont(Font.font("Copperplate Gothic Bold", 31));
        welcomeText.setTextFill(Color.web("#000000"));
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        welcomeText.setTranslateY(25);
        welcomeText.setTranslateX(0);
        welcomeText.setEffect(new Glow(0.7));

        //image
        Image img = new Image("/xo.gif");
        ImageView imageView = new ImageView(img);
        imageView.setImage(img);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setTranslateY(-225);
        imageView.setTranslateX(0);

        //Singleplayer button
        Button singlePlayerButton = new Button("Single Player");
        singlePlayerButton.setPrefSize(167, 37);
        singlePlayerButton.setStyle("-fx-background-color: BLUE;");
        singlePlayerButton.setTextFill(Color.web("#ffffff"));
        singlePlayerButton.setTranslateY(270);
        singlePlayerButton.setFont(Font.font("Copperplate Gothic Bold", 19));
        singlePlayerButton.setPadding(new Insets(10, 7, 10, 7));
        singlePlayerButton.setEffect(new InnerShadow());
        singlePlayerButton.setOnAction(e -> {
            DifficultyS s = new DifficultyS();
            s.start(primaryStage);
        });

        //Multiplayer button
        Button multiPlayersButton = new Button("Multi-Player");
        multiPlayersButton.setPrefSize(171, 43);
        multiPlayersButton.setStyle("-fx-background-color: red;");
        multiPlayersButton.setTextFill(Color.web("#f5f5f6"));
        multiPlayersButton.setTextAlignment(TextAlignment.CENTER);
        multiPlayersButton.setTranslateY(260);
        multiPlayersButton.setFont(Font.font("Copperplate Gothic Bold", 19));
        multiPlayersButton.setPadding(new Insets(10, 5, 10, 5));
        multiPlayersButton.setEffect(new InnerShadow());
        multiPlayersButton.setOnAction(e -> {
            Multiplayer multiplayer = new Multiplayer();
            multiplayer.start(primaryStage);
        });

        //option label
        Label welcomeText1 = new Label("Select An option");
        welcomeText1.setPrefSize(228, 73);
        welcomeText1.setFont(Font.font("Copperplate Gothic Bold", 21));
        welcomeText1.setTextFill(Color.BLACK);
        welcomeText1.setTextAlignment(TextAlignment.CENTER);
        welcomeText1.setTranslateY(80);
        welcomeText1.setEffect(new Glow(0.7));
        welcomeText1.setPadding(new Insets(0, 0, 0, 10));

        //shadow effect
        InnerShadow effect = new InnerShadow();
        effect.setHeight(34.63);
        effect.setWidth(81.34);
        effect.setRadius(28.4925);

        root.getChildren().addAll(welcomeText, singlePlayerButton, multiPlayersButton, welcomeText1, imageView);
        root.setEffect(effect);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        File f = new File("C:\\Users\\samal\\Desktop\\projectf\\src\\main\\resources\\com\\example\\project\\style.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        primaryStage.setTitle("Tic-Tac-toe Game ");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

