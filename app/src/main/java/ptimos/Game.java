package ptimos;

import ptimos.factory.PtimoFactory;
import ptimos.lib.Arena;
import ptimos.lib.Human;
import ptimos.lib.Ptimos;
import ptimos.lib.RandomNum;
import ptimos.lib.UsersReadLine;

public class Game {
    Human player;
    Ptimos ptimo;
    UsersReadLine usersResponse;

    public Game(Human player) {
        this.player = player;
    }

    public Game() {}

    public void init() {
        this.selectPtimos();
        System.out.println("Un " + this.ptimo.getType() + " se cache dans ce bois, voulez-vous le capturer ?");
        System.out.println("[o] - Oui");
        System.out.println("[n] - Non");
        System.out.println("[q] - Quitter");
        this.usersResponse = new UsersReadLine();
        usersResponse.userReadLine();
        this.checkUsersResponse();
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

    public void checkUsersResponse() {
        if (this.usersResponse.isStartFight) this.startFight();
    }

    public void startFight() {
        Arena arena = new Arena(this.player, this.ptimo);
        arena.startCapture();
    }
}
