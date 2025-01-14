package main.java;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AboutPage {

    private final Stage stage;

    public AboutPage(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // About Content
        Label titleLabel = new Label("About MJD Stock");
        titleLabel.setFont(Font.font("Arial", 24));
        titleLabel.setStyle("-fx-text-fill: black;");

        Label descriptionLabel = new Label("MJD Stock is a warehouse management system designed for efficiency.");
        descriptionLabel.setFont(Font.font("Arial", 16));
        descriptionLabel.setWrapText(true);

        Button backButton = new Button("Back to Home");
        backButton.setFont(Font.font("Arial", 14));
        backButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
        backButton.setOnAction(e -> {
            Main mainPage = new Main();
            mainPage.start(stage);
        });

        VBox contentBox = new VBox(20, titleLabel, descriptionLabel, backButton);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setPadding(new Insets(20));

        BorderPane layout = new BorderPane();
        layout.setCenter(contentBox);

        // Scene for About Page
        Scene aboutScene = new Scene(layout, 800, 600, Color.LIGHTGRAY);
        stage.setScene(aboutScene);
    }
}
