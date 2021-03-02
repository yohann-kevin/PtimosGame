package ptimos.poker;

public class MainCards extends PokerPack {
    String[] cards = new String[5];

    public void getMainCards() {
        this.cards = this.getFiveCards();
        Combo combo = new Combo(this.cards);
        combo.testCombo();
    }
}
