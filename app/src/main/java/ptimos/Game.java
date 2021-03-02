package ptimos;

import ptimos.factory.PtimoFactory;
import ptimos.lib.ColorsCustomer;
import ptimos.lib.Human;
import ptimos.lib.Ptimos;
import ptimos.lib.RandomNum;
import ptimos.lib.UsersReadLine;

// test
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;


public class Game {
    public Human player;
    public Ptimos ptimo;
    public UsersReadLine usersResponse = new UsersReadLine();
    public int range;
    public ColorsCustomer colorCmd = new ColorsCustomer();

    public Game(Human player) {
        this.player = player;
    }

    // initialise le jeux
    public void init() {
        colorCmd.initJansi();
        this.selectPtimos();
        this.range = new RandomNum(8, 15).generateRandomNum();
        System.out.println("Un " + this.ptimo.getType() + " se cache dans ce bois, voulez-vous le capturer ?");
        System.out.println(ansi().fg(this.colorCmd.green()).a("[o] - Oui").reset());
        System.out.println(ansi().fg(this.colorCmd.yellow()).a("[n] - Non").reset());
        System.out.println(ansi().fg(this.colorCmd.blue()).a("[r] - Regarder combien de ptimos vous avez capturer").reset());
        System.out.println(ansi().fg(this.colorCmd.red()).a("[q] - Quitter").reset());
        usersResponse.userReadLine();
        this.checkUsersResponse(this.usersResponse);
    }

    // sélctionne un ptimo aléatoirement
    public void selectPtimos() {
        int result = new RandomNum(1, 100).generateRandomNum();
        PtimoFactory factoryPtimo = PtimoFactory.getPtimoFactory();

        if (result < 61) {
            this.ptimo = factoryPtimo.getPtimo("sacbleu",this.player);
        } else if (result > 61 && result < 91) {
            this.ptimo = factoryPtimo.getPtimo("pyralia",this.player);
        } else {
            this.verifyPtimosForPokrand(factoryPtimo);
        }
    }

    // vérifie si l'on a bien capturer 5 ptimo dont un pyralia et un sacbleu minimum
    public void verifyPtimosForPokrand(PtimoFactory factoryPtimo) {
        if (this.player.getAllPtimos() > 2 && this.player.getSacBleuCaptured() > 0 && this.player.getPyraliaCaptured() > 0) {
            this.ptimo = factoryPtimo.getPtimo("pokrand",this.player);
        } else {
            this.selectPtimos();
        }
    }

    // vérifie les réponse utilisateurs
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
            this.player.shotArrow(this.ptimo,this);
        } else if(response.isChecking) {
            response.isChecking = false;
            this.player.checkMyPtimos();
            this.init();
        } else if(response.isEscape) {
            response.isEscape = false;
            this.init();
        }
    }

    // démarre un round
    public void startRound() {
        System.out.println(" ");
        System.out.println(ansi().fg(this.colorCmd.checkLifeForColor(this.player.getLife())).a(this.player.getName() + " (" + this.player.getLife() + "pv)").reset());
        System.out.println("Vous êtes à " + this.range + "m d'un " + this.ptimo.getType());
        System.out.println(" ");
        System.out.println("[1] - Observer");
        System.out.println("[2] - Se rapprocher");
        System.out.println("[3] - Lancer une friandise (x" + this.player.getCandy() + ")");
        System.out.println("[4] - Faire une danse imprésionnnate");
        System.out.println("[5] - Tirer une flechette endormante (x" + this.player.getSleepingArrow() + ")");
        System.out.println(" ");
        System.out.println(ansi().fg(this.colorCmd.red()).a("[0] - Laisser le " + this.ptimo.getType() + " en liberté").reset());
        manageEndgame();
    }

    // gère la fin du jeux 
    public void manageEndgame() {
        if (this.player.getLife() <= 0) {
            this.gameOver();
        } else if(this.range <= 0) {
            this.player.capture(this.ptimo);
            this.init();
        } else if(this.range > 14) {
            this.init();
        } else {
            this.usersResponse.userReadLine();
            System.out.println(" ");
            this.checkUsersResponse(this.usersResponse);
            this.usersExitGame();
        }
    }

    // vérifie si l'utilisateur vuex quitter le jeux
    public void usersExitGame() {
        if (!this.usersResponse.isExit) {
            this.ptimo.feedback(this);
            this.startRound();
        } else {
            this.gameOver();
        }
    }

    public void gameOver() {
        AnsiConsole.systemInstall();
        System.out.println("éééééé");
        System.out.println(ansi().fg(this.colorCmd.red()).a("Game Over !").reset());
    }
}
