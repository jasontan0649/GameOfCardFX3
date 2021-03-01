package TCP1201;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.*;

public class Game {
    private ArrayList<Player> players;
    private int nameMaxLen; //For CLI purpose only, nice output
    private int phaseInt;

    public Game(String p1Name,String p2Name,String p3Name) {
        ArrayList<String> playersName = new ArrayList<>();
        playersName.add(p1Name);
        playersName.add(p2Name);
        playersName.add(p3Name);
        players = new ArrayList<Player>();
        nameMaxLen = 0;
        for (String playerName : playersName) {
            players.add(new Player(playerName));
            nameMaxLen = Math.max(playerName.length(), nameMaxLen);
        }
        phaseInt = 3;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getNameMaxLen() {
        return nameMaxLen;
    }

    public void dealCards() {
        Stack<Card> cards = Card.newShuffleCards();
        //temporary store cards for players
        Stack<Card>[] playersCards =  new Stack[players.size()];
        for (int i = 0; i < players.size(); i++)
            playersCards[i] = new Stack<Card>();

        //deal cards
        for(int i = 0; !cards.isEmpty(); i++)
            playersCards[i % players.size()].push(cards.pop());

        //player divide its own cards
        for(int i = 0; i < players.size(); i++)
            players.get(i).setCards(playersCards[i]);
    }


    public void removeWeakest() throws IOException {
        ArrayList<Player> weakPlayers = getWeakPlayers();
        //check if more than 1 worst player, if more than 1, proceed to else
        if (weakPlayers.size() == 1)
            players.remove(weakPlayers.get(0));
        else
        if (phaseInt == 3) //unlucky draw only for 3rd phase
            Main.switchScene("resources/unluckyDraw.fxml");
    }

    public ArrayList<Player> getWeakPlayers(){
        ArrayList<Player> weakPlayers = new ArrayList<>();
        int lowestScore = Integer.MAX_VALUE;

        for (Player p : players) {
            if (p.getScore() <= lowestScore) {
                if (p.getScore() < lowestScore)
                    weakPlayers.clear();
                lowestScore = p.getScore();
                weakPlayers.add(p);
            }
        }
        return weakPlayers;
    }

    public Player unluckyDraw(ArrayList<Player> weakPlayers) {
        Random r = new Random();
        Player unluckyPlayer =  weakPlayers.get(r.nextInt(weakPlayers.size()));
        players.remove(unluckyPlayer);

        return unluckyPlayer;
    }
}
