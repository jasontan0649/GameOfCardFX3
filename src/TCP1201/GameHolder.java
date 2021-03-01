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

    public void showShuffleCard(GridPane gridPane){
        game.dealCards();
        ArrayList<Player> players= game.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            int column = 1;
            Label pName = new Label(players.get(i).getName() + " : ");
            gridPane.add(Utils.stylePName(pName),0, i);
            for (ArrayList<Card> cardPart : players.get(i).getCards()) {
                HBox hBoxRow = new HBox();
                ImageView[] imageViewsRow = new ImageView[cardPart.size()];
                for (int z = 0; z < cardPart.size(); z++){
                    imageViewsRow[z] = new ImageView();
                    String fileName = "TCP1201/resources/cards/" + cardPart.get(z)+ ".png";
                    imageViewsRow[z].setImage(new Image(fileName, 59, 100, true, true));
                }
                hBoxRow.getChildren().addAll(imageViewsRow);
                gridPane.add(hBoxRow,column, i);
                column++;
            }
        }
    }

    public void setGame(Game g) {
        this.game = g;
    }

    public Game getGame() {
        return this.game;
    }
}
