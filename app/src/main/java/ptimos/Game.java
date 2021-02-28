package ptimos;

import ptimos.factory.PtimoFactory;
import ptimos.lib.Human;
import ptimos.lib.Ptimos;
import ptimos.lib.RandomNum;
import ptimos.lib.UsersReadLine;

public class Game {
    public Human player;
    public Ptimos ptimo;
    public UsersReadLine usersResponse = new UsersReadLine();
    int range;

    public Game(Human player) {
        this.player = player;
    }

    public void init() {
        this.selectPtimos();
        this.range = new RandomNum(8, 15).generateRandomNum();
        System.out.println("Un " + this.ptimo.getType() + " se cache dans ce bois, voulez-vous le capturer ?");
        System.out.println("[o] - Oui");
        System.out.println("[n] - Non");
        System.out.println("[q] - Quitter");
        usersResponse.userReadLine();
        this.checkUsersResponse(this.usersResponse);
    }

    public void selectPtimos() {
        int result = new RandomNum(1, 100).generateRandomNum();
        PtimoFactory factoryPtimo = PtimoFactory.getPtimoFactory();

        if (result < 61) {
            System.out.println("sacbleu");
            this.ptimo = factoryPtimo.getPtimo("sacbleu");
        } else if (result > 61 && result < 91) {
            System.out.println("pyralia");
            this.ptimo = factoryPtimo.getPtimo("pyralia");
        } else {
            System.out.println("pokrand");
            this.ptimo = factoryPtimo.getPtimo("pokrand");
        }
        
    }

    public void checkUsersResponse(UsersReadLine response) {
        if (response.isStartFight) {
            response.isStartFight = false;
            this.startRound();
        } else if(response.isWatching) {
            response.isWatching = false;
            this.player.watching(this.ptimo);
        } else if (response.isMoving) {
            response.isMoving = false;
            this.range -= this.player.moveforward();
        } else if(response.isLaunchCandy) {
            response.isLaunchCandy = false;
            this.player.launchCandy(this.ptimo,this.range);
        } else if(response.isDancing) {
            response.isDancing = false;
            this.player.awesomeDance(this.ptimo);
        } else if(response.isShotArrow) {
            response.isShotArrow = false;
            this.player.shotArrow(this.ptimo);
        } else if(response.isEscape) {
            response.isEscape = false;
            this.init();
        }
    }

    public void startRound() {
        System.out.println(this.player.getName() + " (" + this.player.getLife() + "pv)");
        System.out.println("Vous êtes à " + this.range + "m d'un " + this.ptimo.getType());
        System.out.println(" ");
        System.out.println("[1] - Observer");
        System.out.println("[2] - Se rapprocher");
        System.out.println("[3] - Lancer une friandise (x" + this.player.getCandy() + ")");
        System.out.println("[4] - Faire une danse imprésionnnate");
        System.out.println("[5] - Tirer une flechette endormante (x" + this.player.getSleepingArrow() + ")");
        System.out.println(" ");
        System.out.println("[0] - Laisser le " + this.ptimo.getType() + " en liberté");
        manageEndgame();
    }

    public void manageEndgame() {
        if (this.player.getLife() <= 0) {
            this.gameOver();
        } else if(this.range <= 0) {
            this.init();
        } else {
            this.usersResponse.userReadLine();
            this.checkUsersResponse(usersResponse);
            this.startRound();
        }
    }

    public void gameOver() {
        System.out.println("gameOver");
    }
}
