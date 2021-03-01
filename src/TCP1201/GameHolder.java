package TCP1201;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class GameHolder {
    private Game game;
    private final static GameHolder INSTANCE = new GameHolder();

    private GameHolder() {}

    public static GameHolder getInstance() {
        return INSTANCE;
    }

    public void setGame(Game g) {
        this.game = g;
    }

    public Game getGame() {
        return this.game;
    }
}
