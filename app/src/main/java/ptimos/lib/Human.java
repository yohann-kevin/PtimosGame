package ptimos.lib;

import ptimos.Game;
import static org.fusesource.jansi.Ansi.*;

public class Human {
    private String name;
    private int life = 100;
    private int ptimoCage = 10;
    private int candy = 30;
    private int sleepingArrow = 5;
    private int sacbleuCaptured;
    private int pyraliaCaptured;
    private int pokrandCaptured;
    public boolean ptimoIsCaptured;
    public ColorsCustomer colorCmd = new ColorsCustomer();
    
    public Human(String name) {
        this.name = name;
    }

    // getter and setter
    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int dps) {
        this.life -= dps;
    }

    public int getPtimoCage() {
        return this.ptimoCage;
    }

    public int getCandy() {
        return this.candy;
    }

    public int getSleepingArrow() {
        return this.sleepingArrow;
    }

    public void setPokrandCaptured(int value) {
        this.pyraliaCaptured = value;
    }

    public int getSacBleuCaptured() {
        return this.sacbleuCaptured;
    }

    public void setSacbleuCaptured(int value) {
        this.pyraliaCaptured = value;
    }

    public int getPyraliaCaptured() {
        return this.pyraliaCaptured;
    }

    public void setPyraliaCaptured(int value) {
        this.pyraliaCaptured = value;
    }

    // all method
    // Observer
    public void watching(Ptimos target) {
        GaugeStressAndDominance gauge = new GaugeStressAndDominance(target.getStress(), target.getDominance());
        gauge.gauge(true);
        System.out.println(ansi().fg(this.colorCmd.checkStressAndDominance(gauge.getFinalResult())).a(target.getType() + " semble très " + gauge.getFinalResult()).reset());
        gauge.gauge(false);
        System.out.println(ansi().fg(this.colorCmd.checkStressAndDominance(gauge.getFinalResult())).a("et très " + gauge.getFinalResult() + " !").reset());
    }

    // se rapprocher
    public int moveforward() {
        int rangeMove = new RandomNum(3,8).generateRandomNum();
        System.out.println(ansi().fg(this.colorCmd.green()).a("Vous vous rapprocher de " + rangeMove + "m").reset());
        return rangeMove;
    }

    // lancer une friandise
    public void launchCandy(Ptimos target,int range) {
        this.candy--;
        if (this.candy > 0) {
            int candyPower = 70 / range;
            int probaShot = new RandomNum(0,  100).generateRandomNum();
            if (probaShot < candyPower) {
                target.setStress(candyPower);
                System.out.println(ansi().fg(this.colorCmd.green()).a("vous lancer un bonbon qui enlève " + candyPower + " point de stress au " + target.getType()).reset());
            } else {
                System.out.println(ansi().fg(this.colorCmd.yellow()).a("Vous feriez mieux d'apprendre à viser vous avez rater le " + target.getType()).reset());
            }
        } else {
            System.out.println(ansi().fg(this.colorCmd.red()).a("Vous n'avez plus de bonbon").reset());
        }
        
    }

    // une danse impressionante
    public void awesomeDance(Ptimos target) {
        int dancingPower = new RandomNum(7, 21).generateRandomNum();
        String msg = this.selectMsg(dancingPower);
        System.out.println(ansi().fg(this.colorCmd.green()).a(msg + target.getType() + " de " + dancingPower + " point !").reset());
    }

    // séléctionne un message a afficher en fonction de la puissance de la danse
    public String selectMsg(int dancingPower) {
        if (dancingPower > 15) return "Vous effectuer une dance tellement incroyable qu'elle baisse la dominance du "; 
        return "Vous effectuer une dance asser sympa qui baisse la dominance du "; 
    }

    // tire une fleche
    public void shotArrow(Ptimos target,Game game) {
        if (this.sleepingArrow > 0) {
            System.out.println(ansi().fg(this.colorCmd.green()).a("Vous tirez une fléchette endormante sur le " + target.getType()).reset());
            this.sleepingArrow--;
            game.range = 0;
        } else {
            System.out.println(ansi().fg(this.colorCmd.red()).a("Vous n'avez plus de fléchette endormante").reset());
        }
    }

    // capture un ptimo
    public void capture(Ptimos target) {
        this.ptimoCage --;
        System.out.println(" ");
        System.out.println(ansi().fg(this.colorCmd.green()).a("Vous avez capturer un " + target.getType()).reset());
        if (target.getType().equals("sacbleu")) {
            this.sacbleuCaptured++;
        } else if (target.getType().equals("pyralia")) {
            this.pyraliaCaptured++;
        } else {
            this.pokrandCaptured++;
        }
        this.ptimoIsCaptured = true;
    }

    // reagrde les ptimos capturer
    public void checkMyPtimos() {
        int allPtimos = this.getAllPtimos();
        if (allPtimos > 0) {
            System.out.println(ansi().fg(this.colorCmd.checkAllPtimos(allPtimos)).a("Vous avez capturer " + allPtimos + " ptimos.").reset());
            System.out.println(ansi().fg(this.colorCmd.checkPtimo(this.sacbleuCaptured)).a("- " + this.sacbleuCaptured + " sacbleu").reset());
            System.out.println(ansi().fg(this.colorCmd.checkPtimo(this.pyraliaCaptured)).a("- " + this.pyraliaCaptured + " pyralia").reset());
            System.out.println(ansi().fg(this.colorCmd.checkPtimo(this.pokrandCaptured)).a("- " + this.pokrandCaptured + " pokrand").reset());
        } else {
            System.out.println(ansi().fg(this.colorCmd.red()).a("Vous n'avez pas capturer de ptimos pour le moment.").reset());
        }
    }

    // calcul combien de ptimo juliette a apturer
    public int getAllPtimos() {
        int allPtimos = this.sacbleuCaptured + this.pyraliaCaptured + this.pokrandCaptured;
        return allPtimos;
    }
}
