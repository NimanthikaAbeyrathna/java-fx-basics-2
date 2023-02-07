package lk.ijse.dep10.exp;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginScene(primaryStage);
        primaryStage.show();
    }

    private void loginScene(Stage stage) {
        Label lblTitle = new Label("LOG IN");
        Label lblPassword = new Label("Enter password");
        PasswordField txtPassword = new PasswordField();
        Label lblHint = new Label("Invalid Password, Try Again!");
        Button btnLogIn = new Button("LOG IN");

        btnLogIn.setOnAction(event -> {
            String password = txtPassword.getText();
            if (!password.equals("Admin")) {
                lblHint.setVisible(true);
                txtPassword.selectAll();
            } else {
                mainScene(stage);
            }
        });

        lblTitle.setFont(new Font(44));
        lblTitle.setTextFill(Color.DARKBLUE);
        lblPassword.setPadding(new Insets(25, 0, 0, 0));
        txtPassword.setMaxWidth(350);
        txtPassword.setAlignment(Pos.CENTER);
        lblHint.setTextFill(Color.RED);
        lblHint.setVisible(false);
        btnLogIn.setFont(new Font(16));
        btnLogIn.setDefaultButton(true);

        VBox root = new VBox(lblTitle, lblPassword, txtPassword, lblHint, btnLogIn);

        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPrefWidth(400);
        root.setPrefHeight(400);

        Scene loginScene = new Scene(root);
        stage.setScene(loginScene);
        stage.setTitle("Login");
        stage.sizeToScene();
        stage.centerOnScreen();
    }

    private void mainScene(Stage stage) {
        Label lblGreeting = new Label("Hi! Welcome to the App");
        Label lbl = new Label("Hi! I am moving");

        lbl.setVisible(false);

//        lblGreeting.setFont(new Font(32));
//        lblGreeting.setTextFill(new Color(0, 0, 0, 0.2));
//
//        BorderPane root = new BorderPane(lbl);
//        root.setCenter(lblGreeting);
//        root.setBackground(Background.fill(Color.WHITE));
//        root.setPadding(new Insets(10));
//        root.setPrefHeight(600);
//        root.setPrefWidth(800);

        AnchorPane root = new AnchorPane(lbl);
        root.setBackground(Background.fill(Color.WHITE));
        root.setPadding(new Insets(10));
        root.setPrefHeight(600);
        root.setPrefWidth(800);

        root.setOnMouseEntered(event -> lbl.setVisible(true));
        root.setOnMouseExited(event -> lbl.setVisible(false));
        root.setOnMouseMoved(event -> {
            lbl.setLayoutX(event.getX() + 20);
            lbl.setLayoutY(event.getY() + 20);
        });

        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        stage.sizeToScene();
        stage.setTitle("My App");
        stage.centerOnScreen();
    }
}
