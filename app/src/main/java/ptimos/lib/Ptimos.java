package ptimos.lib;

import ptimos.Game;
import ptimos.poker.MainCards;

import static org.fusesource.jansi.Ansi.*;

abstract public class Ptimos {
    private String type;
    protected int stress;
    protected int dominance;
    private Human target;
    public ColorsCustomer colorCmd = new ColorsCustomer();
    public Game game;

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
        this.game = game;
        Ia ia = new Ia(this.type,this.game,this);
        if (this.game.range > 0) ia.launchIa();
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
        if (this.getType().equals("pokrand")) {
            this.checkMainPoker();
        } else {
            this.atkMagicNormal(); 
        }
    }

    public void checkMainPoker() {
        System.out.println("Le " + this.getType() + " sort un jeux de poker");
        MainCards poker = new MainCards();
        System.out.println("Le " + this.getType() + " pioche cinq carte");
        String result = poker.getMainCards();
        String[] cards = poker.getCards();
        System.out.println(cards[0] + " " + cards[1] + " " + cards[2] + " " + cards[3] + " " + cards[4]);
        this.verifyCombo(result);
    }

    public void verifyCombo(String result) {
        if (result.equals("assome")) {
            System.out.println("Le " + this.getType() + " vous assome et s'en va avec vos ptimos :)");
            this.target.setPokrandCaptured(0);
            this.target.setPyraliaCaptured(0);
            this.target.setSacbleuCaptured(0);
        } else if (result.equals("fuit")) {
            this.game.range = 16;
            System.out.println("Le " + this.getType() + " prend la fuite !");
        } else {
            atkMagicNormal();
        }
    }

    public void atkMagicNormal() {
        int dps = new RandomNum(0, 20).generateRandomNum();
        this.target.setLife(dps);
        this.dominance += dps; 
        if (this.dominance > 100) this.dominance = 100;
        System.out.println(ansi().fg(this.colorCmd.blue()).a("Le " + this.getType() + " lance une attaque magique"));
    }
    
}
