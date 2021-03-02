package TCP1201;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class PrintCard {
    public static void showAvailableCards(Game game, GridPane gridPane){
        ArrayList<Player> players = game.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            Label pName = new Label(players.get(i).getName() + " : ");
            gridPane.add(Utils.styleContent(pName),0, i);

            int column = 1;
            for (ArrayList<Card> cardPart : players.get(i).getCards()) {
                HBox hBoxRow = Utils.styleHRow(new HBox());
                hBoxRow.getChildren().addAll(imageViewsRow(cardPart, 45, 80));
                gridPane.add(hBoxRow, column, i);
                column++;
            }

        }
    }

    public static ImageView[] createImageViewRow(ArrayList<Card> cardPart, int width, int height) {
        return imageViewsRow(cardPart, width, height);
    }

    private static ImageView[] imageViewsRow(ArrayList<Card> cardPart, int width, int height) {
        ImageView[] imageViewsRow = new ImageView[cardPart.size()];

        for (int z = 0; z < cardPart.size(); z++){
            imageViewsRow[z] = new ImageView();
            String fileName = "TCP1201/resources/cards/" + cardPart.get(z)+ ".png";
            imageViewsRow[z].setImage(new Image(fileName, width, height, true, true));
        }
        return imageViewsRow;
    }
}
