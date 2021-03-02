package ptimos.poker;

public class MainCards extends PokerPack {
    private String[] cards = new String[5];

    public String[] getCards() {
        return this.cards;
    }

    public String getMainCards() {
        this.cards = this.getFiveCards();
        Combo combo = new Combo(this.cards);
        combo.initCombo();
        return combo.decideAction();
    }
}
