package ptimos.lib;

public class Arena {
    Human player;
    Ptimos ptimo;
    int range =  new RandomNum(8, 15).generateRandomNum();

    public Arena(Human player, Ptimos ptimo) {
        this.player = player;
        this.ptimo = ptimo;
    }

    public void startCapture() {
        System.out.println(this.player.getName() + " (" + this.player.getLife() + "pv)");
        System.out.println("Vous êtes à " + this.range + "m d'un " + this.ptimo.type);
    }
}
