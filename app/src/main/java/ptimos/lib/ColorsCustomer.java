package ptimos.lib;

import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;

public class ColorsCustomer {
    private Color ANSI_RED = Color.RED;
    private Color ANSI_GREEN = Color.GREEN;
    private Color ANSI_YELLOW = Color.YELLOW;
    private Color ANSI_BLUE = Color.CYAN;

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

    // renvoie une couleur en fonction de la vie
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

    // renvoie une couleur par rapport au stress et de la dominance
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

    // renvoie une couleur en fonction du nombre de ptimos total
    public Color checkAllPtimos(int numberPtimos) {
        if (numberPtimos > 4) {
            return this.green();
        } else if(numberPtimos > 0 && numberPtimos < 5) {
            return this.yellow();
        } else {
            return this.red();
        }
    }

    // renvoie une couleur en fonction du nombre de ptimo
    public Color checkPtimo(int numPtimo) {
        if (numPtimo > 3) {
            return this.green();
        } else if (numPtimo < 4 && numPtimo > 0) {
            return this.yellow();
        } else {
            return this.red();  
        }
    }
}
