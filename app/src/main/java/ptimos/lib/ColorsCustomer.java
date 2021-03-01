package ptimos.lib;

import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;

public class ColorsCustomer {
    public Color ANSI_RED = Color.RED;
    public Color ANSI_GREEN = Color.GREEN;
    public Color ANSI_YELLOW = Color.YELLOW;
    public Color ANSI_BLUE = Color.BLUE;

    public void initJansi() {
        AnsiConsole.systemInstall();
    }

    public Color red() {
        return ANSI_RED;
    }

    public Color green() {
        return ANSI_GREEN;
    }

    public Color blue() {
        return ANSI_BLUE;
    }

    public Color yellow() {
        return ANSI_YELLOW;
    }

    public Color checkLifeForColor(int life) {
        if (life > 75) {
            return this.green();
        } else if(life < 76 && life > 50) {
            return this.blue();
        } else if (life < 51 && life > 25) {
            return this.yellow();
        } else {
            return this.red();
        }
    }

    public Color checkStressAndDominance(String value) {
        if (value.equals("(détendu)") || value.equals("(inoffensif)")) {
            return this.green();
        } else if (value.equals("(mefiant)") || value.equals("(neutre)")) {
            return this.blue();
        } else if (value.equals("(nerveux)") || value.equals("féroce")) {
            return this.yellow();
        } else {
            return this.red();
        }
    }

    public Color checkAllPtimos(int numberPtimos) {
        if (numberPtimos > 5) {
            return this.green();
        } else if(numberPtimos > 0 && numberPtimos < 5) {
            return this.yellow();
        } else {
            return this.red();
        }
    }

    public Color checkPtimo(int numPtimo) {
        if (numPtimo > 3) {
            return this.green();
        } else if (numPtimo < 3 && numPtimo > 0) {
            return this.yellow();
        } else {
            return this.red();  
        }
    }
}
