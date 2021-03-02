package ptimos.poker;

public class Combo {
    public String[] cards = new String[5];
    public String[] value = new String[5];
    public String[] symbol = new String[5];

    public Combo(String[] mainCards) {
        this.cards = mainCards;
    }

    public void initCombo() {
        String[] tab = new String[2];
        for (int i = 0; i < this.cards.length; i++) {
            tab = this.cards[i].split("-");
            this.value[i] = tab[0];
            this.symbol[i] = tab[1];
        }
    }

    public String checkCombo() {
        String result = "";
        if (this.checkQuinteFlush()) {
            result = "quinte-flush";
        } else if (this.checkFull()) {
            result = "full";
        } else if (this.checkFlush()) {
            result = "flush";
        } else if (this.checkQuinte()) {
            result = "quinte";
        } else if (this.checkBrelan()) {
            result = "brelan";
        } else if (this.checkSquare()) {
            result = "carré";
        } else {
            result = "pair";
        }
        return result;
    }

    public String decideAction() {
        String result = this.checkCombo();
        if (result.equals("full") || result.equals("carré") || result.equals("quinte-flush")) {
            return "assome";
        } else if (result.equals("brelan") || result.equals("quinte") || result.equals("flush")) {
            return "fuit";
        } else {
            return "atkMagic";
        }
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
        
        if (counter == 2 || counter == 8) {
            return true;
        } else if (counter == 4) {
            return this.pairOrSquare();
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
        
        if ((counter / 2) == 3 || counter == 8) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkQuinte() {
        int counter = 0;
        for (int i = 0; i < this.value.length; i++) {
            if ( i != 0) {
                int value = convertSymbolToInt(this.value[i]);
                int oldValue = convertSymbolToInt(this.value[i - 1]);
                if (value == (oldValue + 1)) counter++;
            }
        }
        if (counter == 4) return true;
        return false;
    }

    public int  convertSymbolToInt(String valueString) {
        int value = 0;
        if (valueString.equals("A")) {
            value = 1;
        } else if (valueString.equals("V")) {
            value = 11;
        } else if (valueString.equals("D")) {
            value = 12;
        } else if (valueString.equals("K")) {
            value = 13;
        } else {
            value = Integer.parseInt(valueString);
        }
        return value;
    }

    public boolean checkFlush() {
        int counter = 0;
        for (int i = 0; i < this.symbol.length; i++) {
            for (int j = 0; j < this.symbol.length; j++) {
                if (i != j && this.symbol[i].equals(this.symbol[j])) counter++;
            }
        }
        if ((counter / 4) == 5) return true;
        return false;
    }

    public boolean pairOrSquare() {
        int counter = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < this.value.length; j++) {
                if ( i != j && this.value[i] == this.value[j]) counter++;
            }
        }
        if (counter == 4 || counter == 8) return false;
        return true;
    }

    public boolean checkSquare() {
        if (!this.checkPair() && this.pairOrSquare()) return true;
        return false;
    }

    public boolean checkQuinteFlush() {
        if (this.checkQuinte() && this.checkFlush()) return true;
        return false;
    }

    public boolean checkFull() {
        if (this.checkPair() && this.checkBrelan()) return true;
        return false;
    }
}
