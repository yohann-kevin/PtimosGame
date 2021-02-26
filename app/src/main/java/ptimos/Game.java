package ptimos;

import java.util.Scanner; 
import ptimos.lib.Human;
import ptimos.lib.Ptimos;

public class Game {
    Human player;
    Ptimos ptimo;

    public Game(Human player, Ptimos ptimo) {
        this.player = player;
        this.ptimo = ptimo;
    }

    public void test() {
        System.out.println("Stress : " + ptimo.stress);
        this.player.launchCandy(this.ptimo);
        System.out.println("Stress : " + ptimo.stress);
        System.out.println("Life : " + player.getLife());
        this.ptimo.attack(player);
        System.out.println("Life : " + player.getLife());
    }

    public void init() {
        System.out.println("Un " + this.ptimo.getType() + " se cache dans ce bois, voulez-vous le capturer ?");
        System.out.println("[a] - Oui");
        System.out.println("[b] - Non");
        System.out.println("[q] - Quitter");
        Object response = new Scanner(System.in).nextLine();
        verifyResponse(response);
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
            case "a" :
                System.out.println("Le jeux continue");
                break;
            case "b" :
                System.out.println("Vous partez à la recherche d'autre Ptimos");
                break;
            default : 
                System.out.println("Au revoir !");
        }
    }
}
