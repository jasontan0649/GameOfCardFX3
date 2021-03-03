package TCP1201;

import java.io.IOException;
import java.util.*;

public class Game {
    private ArrayList<Player> players;
    private int phaseInt;

    public Game(String p1Name,String p2Name,String p3Name) {
        this.players = new ArrayList<Player>();
        players.add(new Player(p1Name));
        players.add(new Player(p2Name));
        players.add(new Player(p3Name));

        phaseInt = 3;
    }

    public ArrayList<Player> getPlayers() {
        return players;
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

    public void removeWeakest() throws IOException {
        ArrayList<Player> weakPlayers = getWeakPlayers();
        //check if more than 1 worst player, if more than 1, proceed to else
        if (weakPlayers.size() == 1){
            players.remove(weakPlayers.get(0));
            if(phaseInt == 3) // for 3-player phase
                showNextPhase();
        } else if (phaseInt == 3) //unlucky draw only for 3-player phase
            showUnluckyDraw();
    }

    private void showNextPhase() throws IOException {
        Main.switchScene("resources/postFirstPhase.fxml");
    }

    private void showUnluckyDraw() throws IOException {
        Main.switchScene("resources/unluckyDraw.fxml");
    }

    public Player unluckyDraw(ArrayList<Player> weakPlayers) {
        Random r = new Random();
        Player unluckyPlayer =  weakPlayers.get(r.nextInt(weakPlayers.size()));
        players.remove(unluckyPlayer);
        return unluckyPlayer;
    }

    public void nextPhase(){
        phaseInt--;
    }

    public void showEndGame() throws IOException {
        Main.switchScene("resources/endGame.fxml");
    }
}
