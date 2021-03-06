package ptimos.lib;

import ptimos.Game;

public class Ia {
    private String type;
    private int range;
    private int probaRoar;
    private int probaAtk;
    private int probaMove;
    private int probaAtkMagic;
    private Game game;
    private Ptimos ptimo;

    public Ia(String type,Game game,Ptimos ptimo) {
        this.type = type;
        this.range = game.range;
        this.game = game;
        this.ptimo = ptimo;
    }

    // démarre l'IA
    public void launchIa() {
        System.out.println(" ");
        this.checkAtk();
        this.checkRoar();
        this.checkMove();
        this.checkAtkMagic();
        this.getHighProba();
    }

    // calcul la proba attaque
    public void checkAtk() {
        if (this.ptimo.getDominance() > 55 || this.ptimo.getStress() > 85) {
            this.probaAtk = 60;
        } else if (this.ptimo.getDominance() > 30 && this.ptimo.getDominance() < 56) {
            this.probaAtk = 30;
        } else {
            this.probaAtk = 15;
        }
    }

    // calcul la proba roar
    public void checkRoar() {
        if (this.ptimo.getDominance() < 31 && this.range > 3 && this.range < 10) {
            this.probaRoar = 60;
        }
    }

    // calcul la proba move
    // !complexity
    public void checkMove() {
        if (this.ptimo.getStress() > 85) {
            this.probaAtkMagic = 30;
        } else if (this.ptimo.getStress() < 86 && this.ptimo.getStress() > 75) {
            this.probaMove = 60;
        } else if (this.ptimo.getStress() < 76 && this.ptimo.getStress() > 54) {
            this.probaMove = 30;
        } else if (this.ptimo.getStress() < 55) {
            this.probaMove = 0;
        }
    }

    // calcul la proba d'attaque magique
    public void checkAtkMagic() {
        if (this.ptimo.getDominance() == 100) {
            this.probaAtkMagic = 100;
        } else if (this.range < 3) {
            this.probaAtkMagic = 60;
        }
    }

    // récupère la proba la plus éléver
    public void getHighProba() {
        int[] allProba = {this.probaRoar,this.probaAtk,this.probaMove,this.probaAtkMagic};
        int bigNumIndex = 0;
        for (int i = 0; i < allProba.length; i++) {
            if (allProba[i] >= allProba[bigNumIndex]) bigNumIndex = i;
        }
        this.makeDecision(bigNumIndex);
    }

    // décide de l'action a activer enf fonction de l'index de la meilleur proba
    public void makeDecision(int index) {
        switch (index) {
            case 0 :
                this.ptimo.roar();
                break;
            case 1 :
                this.ptimo.attack();
                break;
            case 2 : 
                this.ptimo.moveAway(this.game);
                break;
            case 3 :
                this.ptimo.magicAttack();
                // this.ptimo.plop();
                break;
            default : 
                this.ptimo.roar();
        }
    }

    // affiche les proba (debug)
    public void printProba() {
        System.out.println("dominance : " + this.ptimo.getDominance());
        System.out.println("stress : " + this.ptimo.getStress());
        System.out.println("range : " + this.range);

        System.out.println("probaRoar : " + this.probaRoar);
        System.out.println("probaAtk : " + this.probaAtk);
        System.out.println("probaMove : " + this.probaMove);
        System.out.println("probaAtkMagic : " + this.probaAtkMagic);
    }
}
