/*
Description:
This code represents the difficulty selection screen for the singleplayer Tic-Tac-Toe game.
It creates a JavaFX application window with buttons for choosing the difficulty level.
The screen includes a title, an image, and two buttons for "Easy" and "Hard" difficulty.
Clicking on the buttons launches different game modes. The layout is styled with colors,
fonts, and effects to enhance the visual appeal.

Students:
- Ameera Attiah S21107316
- Leen Sharab S21107195
- Sarah Alshumayri S20106125
*/
package com.example.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class DifficultyS extends TicTacToe {

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
        Label welcomeText = new Label("Choose the \n difficulty");
        welcomeText.setPrefSize(221, 130);
        welcomeText.setFont(Font.font("Copperplate Gothic Bold", 31));
        welcomeText.setTextFill(Color.web("#000000"));
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        welcomeText.setTranslateY(25);
        welcomeText.setTranslateX(20);
        welcomeText.setEffect(new Glow(0.7));


        //image
        Image img = new Image("/xo.gif");
        ImageView imageView = new ImageView(img);
        imageView.setImage(img);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setTranslateY(-225);
        imageView.setTranslateX(0);

        //Single player button
        Button easyButton = new Button("Easy");
        easyButton.setPrefSize(167, 37);
        easyButton.setStyle("-fx-background-color: BLUE;");
        easyButton.setTextFill(Color.web("#ffffff"));
        easyButton.setTranslateY(270);
        easyButton.setFont(Font.font("Copperplate Gothic Bold", 19));
        easyButton.setPadding(new Insets(10, 7, 10, 7));
        easyButton.setEffect(new InnerShadow());
        easyButton.setOnAction(e -> {
            EasySingleplayer easyS = new EasySingleplayer();
            easyS.start(primaryStage);
        });

        //Multiplayer button
        Button hardButton = new Button("Hard");
        hardButton.setPrefSize(171, 43);
        hardButton.setStyle("-fx-background-color: red;");
        hardButton.setTextFill(Color.web("#f5f5f6"));
        hardButton.setTextAlignment(TextAlignment.CENTER);
        hardButton.setTranslateY(260);
        hardButton.setFont(Font.font("Copperplate Gothic Bold", 19));
        hardButton.setPadding(new Insets(10, 5, 10, 5));
        hardButton.setEffect(new InnerShadow());
        hardButton.setOnAction(e -> {
            HardSingleplayer hardSinglePlayer = new HardSingleplayer();
            try {
                hardSinglePlayer.start(primaryStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
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

        root.getChildren().addAll(welcomeText, easyButton, hardButton, welcomeText1, imageView);
        root.setEffect(effect);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        File f = new File("C:\\Users\\samal\\Desktop\\projectf\\src\\main\\resources\\com\\example\\project\\style.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        primaryStage.setTitle("Tic-Tac-toe Game ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



