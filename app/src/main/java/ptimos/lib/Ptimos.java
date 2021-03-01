package ptimos.lib;

import ptimos.Game;
import static org.fusesource.jansi.Ansi.*;

abstract public class Ptimos {
    String type;
    protected int stress;
    protected int dominance;
    Human target;
    public ColorsCustomer colorCmd = new ColorsCustomer();

    public Ptimos(String type,Human target) {
        this.type = type;
        this.target = target;
    }

    // getter and setter
    public String getType() {
        return this.type;
    }

    public int getStress() {
        return this.stress;
    }

    public void setStress(int malus) {
        this.stress -= malus;
    }

    public int getDominance() {
        return this.dominance;
    }

    public void setDominance(int malus) {
        this.dominance -= malus;
    }

    // all method
    public void feedback(Game game) {
        Ia ia = new Ia(this.type,game,this);
        if (game.range > 0) ia.launchIa();
    }

    public void roar() {
        int bonus  = new RandomNum(0, 20).generateRandomNum();
        this.dominance += bonus;
        if (this.dominance > 100) this.dominance = 100;
        this.stress -= bonus;
        if (this.stress < 0) this.stress = 0;
        System.out.println(ansi().fg(this.colorCmd.red()).a(this.getType() + " pousse un cri féroce qui le rend plus sûr de lui").reset());
    }

    public void attack() {
        int dps = new RandomNum(0, 20).generateRandomNum();
        System.out.println(ansi().fg(this.colorCmd.red()).a("Le " + this.getType() + " passe à l'attaque").reset());
        this.target.setLife(dps);
    }

    public void moveAway(Game game) {
        int move = new RandomNum(2, 5).generateRandomNum();
        System.out.println(ansi().fg(this.colorCmd.yellow()).a("Le " + this.getType() + " s'éloigne de " + move + "m").reset());
        game.range += move;
    }

    public void magicAttack() {
        System.out.println(ansi().fg(this.colorCmd.blue()).a("atack magic").reset());
    }
}
