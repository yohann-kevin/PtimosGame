package ptimos.poker;

// roi -> k -> king
// dame -> d -> dame
// valet -> v -> valet
// as -> a -> as

// spade -> s -> pique
// diamonds -> d -> carreau
// heart -> h -> coeur
// clover -> c -> trèfle

public class PokerPack {
    String[] allCards = new String[52];

    public void initPack() {
        int counter = 0;
        int index = 13;
        String result = "";
        for (int i = 0; i < 4; i++) {
            int value = 0;
            counter++;
            for (int j = 0; j < 13;j++) {
                String symbol = this.getSymbol(i);
                value++;
                if (value == 1 || value == 11 || value == 12 ||value == 13) {
                    String otherValue = this.transformValue(value);
                    result = otherValue + symbol;
                } else {
                    result = value + symbol;
                }
                this.allCards[j + (i * 13)] = result;
            }
        }
        this.testCard();
    }

    public void testCard() {
        for (int i = 0; i < this.allCards.length; i++) {
            System.out.println(this.allCards[i]);
        }
    }

    public String getSymbol(int index) {
        if (index == 0) {
            return "d";
        } else if (index == 1) {
            return "h";
        } else if (index == 2) {
            return "c";
        } else {
            return "s";
        }
    }

    public String transformValue(int value) {
        if (value == 1) {
            return "A";
        } else if (value == 11) {
            return "V";
        } else if(value == 12) {
            return "D";
        } else {
            return "K";  
        }
    }
}