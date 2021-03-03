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
                String symbol = this.valueOrSymbol(i,false);
                value++;
                result = this.manageSpecialValue(value, symbol);
                this.allCards[j + (i * 13)] = result;
            }
        }
    }

    // method permettant de gérer les valeur spécial
    public String manageSpecialValue(int value, String symbol) {
        if (value == 1 || value == 11 || value == 12 ||value == 13) {
            String otherValue = this.valueOrSymbol(value,true);
            return otherValue + "-" + symbol;
        } else {
            return value + "-" + symbol;
        }
    }

    public String valueOrSymbol(int value,boolean isValue) {
        int[] valueTester = {1,11,12};
        String[] possibleValue = {"A","V","D","K"};
        int[] symbolTester = {0,1,2};
        String[] possibleSymbol = {"d","h","c","s"};
        if (isValue) {
            return this.tarnsfomrChar(value, valueTester, possibleValue);
        } else {
            return this.tarnsfomrChar(value, symbolTester, possibleSymbol);
        }
    }

    public String tarnsfomrChar(int value,int[] valueTest,String[] possibility) {
        if (value == valueTest[0]) {
            return possibility[0];
        } else if (value == valueTest[1]) {
            return possibility[1];
        } else if (value == valueTest[2]) {
            return possibility[2];
        } else {
            return possibility[3];
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