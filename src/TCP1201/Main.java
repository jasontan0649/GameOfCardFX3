package TCP1201;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {
    private static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("resources/home.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game of Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void switchScene(String fxml) throws IOException {
        // TODO: Screenshot Function here
        Parent root = FXMLLoader.load(Main.class.getResource(fxml));
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(Main.class.getResource("stylesheets/styles.css").toExternalForm());
        primaryStage.setScene(scene);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
