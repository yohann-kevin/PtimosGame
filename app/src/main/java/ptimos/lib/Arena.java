package ptimos.lib;

import ptimos.Game;

public class Arena extends Game {
    Human player;
    Ptimos ptimo;
    int range =  new RandomNum(8, 15).generateRandomNum();

    public Arena(Human player, Ptimos ptimo) {
        super(player);
        this.player = player;
        this.ptimo = ptimo;
    }

    public void startCapture() {
        System.out.println(this.player.getName() + " (" + this.player.getLife() + "pv)");
        System.out.println("Vous êtes à " + this.range + "m d'un " + this.ptimo.type);
        System.out.println(" ");
        System.out.println("[1] - Observer");
        System.out.println("[2] - Se rapprocher");
        System.out.println("[3] - Lancer une friandise (x" + this.player.getCandy() + ")");
        System.out.println("[4] - Faire une danse imprésionnnate");
        System.out.println("[5] - Tirer une flechette endormante (x" + this.player.getSleepingArrow() + ")");
        System.out.println(" ");
        System.out.println("[0] - Laisser le " + this.ptimo.getType() + " en liberté");
        this.usersResponse = new UsersReadLine();
        this.usersResponse.userReadLine();
    }
}
