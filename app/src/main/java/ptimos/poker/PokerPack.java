package ptimos.poker;

import ptimos.lib.RandomNum;

public class PokerPack {
    private String[] allCards = new String[52];

    // création du paquet de 52 carte
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
                result = this.manageSpecialValue(value, symbol);
                this.allCards[j + (i * 13)] = result;
            }
        }
    }

    // method permettant de gérer les valeur spécial
    public String manageSpecialValue(int value, String symbol) {
        if (value == 1 || value == 11 || value == 12 ||value == 13) {
            String otherValue = this.transformValue(value);
            return otherValue + "-" + symbol;
        } else {
            return value + "-" + symbol;
        }
    }

    // convertie certaine valeur en symbol
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

    // convertie certaine valeur en symbol
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

    // récupère 5 cartes au hasard dans le paquet
    public String[] getFiveCards() {
        this.initPack();
        String[] main = new String[5];
        for (int i = 0; i < main.length; i++) {
            int index = new RandomNum(0, this.allCards.length).generateRandomNum();
            main[i] = this.allCards[index];
        }
        return main;
    }
}