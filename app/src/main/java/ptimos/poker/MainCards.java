package ptimos.poker;

public class MainCards extends PokerPack {
    String[] cards = new String[5];

    public void getCards() {
        this.cards = this.getFiveCards();
        for (int i = 0; i < this.cards.length; i++) {
            System.out.println(this.cards[i]);
        }
    }
}
