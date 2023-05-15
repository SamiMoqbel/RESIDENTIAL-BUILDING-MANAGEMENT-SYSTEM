package com.example.database1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScenes extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(MainScenes.class.getResource("Login.fxml"));
        ///Scene scene = new Scene(fxmlLoader.load());
        Parent root = FXMLLoader.load((getClass().getResource("Login.fxml")));
        Scene scene=new Scene((root)) ;
        stage.setTitle("Real Estate Data Base!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}