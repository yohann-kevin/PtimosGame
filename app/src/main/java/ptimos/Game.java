package ptimos;

import ptimos.factory.PtimoFactory;
import ptimos.lib.Arena;
import ptimos.lib.Human;
import ptimos.lib.Ptimos;
import ptimos.lib.RandomNum;
import ptimos.lib.UsersReadLine;

public class Game {
    public Human player;
    public Ptimos ptimo;
    public UsersReadLine usersResponse;

    public Game(Human player) {
        this.player = player;
    }

    public void init() {
        this.selectPtimos();
        System.out.println(ptimo);
        System.out.println("Un " + this.ptimo.getType() + " se cache dans ce bois, voulez-vous le capturer ?");
        System.out.println("[o] - Oui");
        System.out.println("[n] - Non");
        System.out.println("[q] - Quitter");
        this.usersResponse = new UsersReadLine();
        usersResponse.userReadLine();
        this.checkUsersResponse(this.usersResponse);
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

    public void checkUsersResponse(UsersReadLine response) {
        if (response.isStartFight) {
            response.isStartFight = false;
            this.startFight();
        } else if(response.isWatching) {
            response.isWatching = false;
            this.player.watching(this.ptimo);
        }
    }

    public void startFight() {
        Arena arena = new Arena(this.player, this.ptimo);
        arena.startCapture();
    }
}
