package ptimos.poker;

public class MainCards extends PokerPack {
    private String[] cards = new String[5];

    public String[] getCards() {
        return this.cards;
    }

    // récupère 5 cartes et lance le combo
    public String getMainCards() {
        this.cards = this.getFiveCards();
        Combo combo = new Combo(this.cards);
        combo.initCombo();
        return combo.decideAction();
    }
}
