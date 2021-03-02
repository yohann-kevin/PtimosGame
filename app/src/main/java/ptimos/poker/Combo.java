package ptimos.poker;

public class Combo {
    public String[] cards = new String[5];
    public String[] value = new String[5];
    public String[] symbol = new String[5];

    public Combo(String[] mainCards) {
        this.cards = mainCards;
    }

    public void testCombo() {
        String[] tab = new String[2];
        for (int i = 0; i < this.cards.length; i++) {
            System.out.println("Carte : " + this.cards[i]);
            tab = this.cards[i].split("-");
            this.value[i] = tab[0];
            this.symbol[i] = tab[1];
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Value : " + this.value[i]);
            System.out.println("Symbol : " + this.symbol[i]);
        }
        this.checkPair();
    }

    public boolean checkPair() {
        int counter = 0;
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value.length; j++) {
                if (j != i && this.value[i].equals( this.value[j])) {
                    counter++;
                } 
            }
        }
        if (counter == 2 || counter == 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkBrelan() {
        int counter = 0;
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value.length; j++) {
                if (j != i && this.value[i].equals(this.value[j])) {
                    counter++;
                } 
            }
        }
        System.out.println("counter : " + counter);
        if ((counter / 2) == 3) {
            return true;
        } else {
            return false;
        }
    }


}
