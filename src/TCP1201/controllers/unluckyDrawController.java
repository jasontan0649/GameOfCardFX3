package TCP1201.controllers;
import TCP1201.Game;
import TCP1201.GameHolder;
import TCP1201.Main;
import TCP1201.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.io.IOException;


public class unluckyDrawController {
    public Label title;
    public Button nextPhaseBtn;

    private Game game;

    public void initialize(){
       this.game = GameHolder.getInstance().getGame();

    }

    public void onStartUnluckyDraw(MouseEvent mouseEvent) {
        Player unluckyPlayer = game.unluckyDraw(game.getWeakPlayers());
        String header = "The unlucky player is " + unluckyPlayer.getName();
        title.setText(header);
        nextPhaseBtn.setVisible(true);
    }

    public void onStartPhase(MouseEvent mouseEvent) throws IOException {
        Main.switchScene("resources/postFirstPhase.fxml");
    }
}
