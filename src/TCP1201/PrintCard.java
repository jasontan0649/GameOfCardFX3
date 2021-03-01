package TCP1201;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class PrintCard {
    public static void showAvailableCards(Game game, GridPane gridPane){
        ArrayList<Player> players = game.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            Label pName = new Label(players.get(i).getName() + " : ");
            gridPane.add(Utils.styleContent(pName),0, i);
            int column = 1;
            for (ArrayList<Card> cardPart : players.get(i).getCards()) {
                HBox hBoxRow = Utils.styleHRow(new HBox());
                ImageView[] imageViewsRow = new ImageView[cardPart.size()];
                for (int z = 0; z < cardPart.size(); z++){
                    imageViewsRow[z] = new ImageView();
                    String fileName = "TCP1201/resources/cards/" + cardPart.get(z)+ ".png";
                    imageViewsRow[z].setImage(new Image(fileName, 45, 80, true, true));
                }
                hBoxRow.getChildren().addAll(imageViewsRow);
                gridPane.add(hBoxRow,column, i);
                column++;
            }
        }
    }

}
