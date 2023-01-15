package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GUIApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUIApp.class.getResource("GUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 250);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.show();
    }
}
