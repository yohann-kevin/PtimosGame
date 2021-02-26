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
        Scanner scanner = new Scanner(System.in);
        Object response = scanner.nextLine();
        System.out.println(response);
    }

    public void verifyResponse(Object response) {
        
    }
}
