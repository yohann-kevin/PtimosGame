package ptimos;

import java.util.Scanner;

import ptimos.factory.PtimoFactory;
import ptimos.lib.Arena;
import ptimos.lib.Human;
import ptimos.lib.Ptimos;
import ptimos.lib.RandomNum;

public class Game {
    Human player;
    Ptimos ptimo;

    public Game(Human player) {
        this.player = player;
    }

    public void init() {
        this.selectPtimos();
        System.out.println("Un " + this.ptimo.getType() + " se cache dans ce bois, voulez-vous le capturer ?");
        System.out.println("[o] - Oui");
        System.out.println("[n] - Non");
        System.out.println("[q] - Quitter");
        this.userReadLine();
    }

    public void selectPtimos() {
        int result = new RandomNum(1, 100).generateRandomNum();
        if (result < 61) {
            System.out.println("sacbleu");
        } else if (result > 61 && result < 91) {
            System.out.println("pyralia");
        } else {
            System.out.println("pokrand");
        }
        PtimoFactory factoryPtimo = PtimoFactory.getPtimoFactory();
        this.ptimo = factoryPtimo.getPtimo("sacbleu");
    }

    public void userReadLine() {
        Object response = new Scanner(System.in).nextLine();
        this.verifyResponse(response);
    }

    public void verifyResponse(Object response) {
        boolean checked = false;
        if (response.getClass().getName() == "java.lang.String" && ((String) response).length() == 1) checked = true;
        if (checked) {
            this.manageResponse(response);
        } else {
            this.errorResponse();
        }
    }

    public void errorResponse() {
        System.out.println("Le programme ne reconnait pas votre réponse");
        this.init();
    }

    public void manageResponse(Object response) {
        switch ((String) response) {
            case "q" :
                System.out.println("Au revoir !");
                break;
            case "o" :
                System.out.println("Le jeux continue");
                Arena arena = new Arena(this.player, this.ptimo);
                arena.startCapture();
                break;
            case "n" :
                System.out.println("Vous partez à la recherche d'autre Ptimos");
                break;
            default : 
                System.out.println("Au revoir !");
        }
    }
}
