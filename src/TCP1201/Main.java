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
        startGame();
    }

    private static void cleanup(){
        GameHolder holder = GameHolder.getInstance();
        holder.setGame(null);
    }

    public static void startGame() throws IOException {
        cleanup();
        Parent root = FXMLLoader.load(Main.class.getResource("resources/home.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(Main.class.getResource("stylesheets/styles.css").toExternalForm());
        primaryStage.setTitle("Game of Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void switchScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(fxml));
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(Main.class.getResource("stylesheets/styles.css").toExternalForm());
        primaryStage.setScene(scene);

        Snapshot.saveAsPng(scene);
    }

    public static void openHistory() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("resources/history.fxml"));
        Stage historyStage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(Main.class.getResource("stylesheets/styles.css").toExternalForm());
        historyStage.setTitle("History");
        historyStage.setScene(scene);
        historyStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
