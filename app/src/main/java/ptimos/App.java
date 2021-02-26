package ptimos;

import ptimos.factory.HumanFactory;
import ptimos.factory.PtimoFactory;
import ptimos.lib.Human;
import ptimos.lib.Ptimos;
import ptimos.lib.RandomNum;

public class App {
    public static void main(String[] args) {
        // création de juliette
        HumanFactory factoryHuman = HumanFactory.getHumanFactory();
        Human juliette = factoryHuman.getHuman("Juliette");

        // test
        System.out.println(juliette.getName());

        // crée un ptimo
        PtimoFactory factoryPtimo = PtimoFactory.getPtimoFactory();
        Ptimos machin = factoryPtimo.getPtimo("sacbleu");

        // test
        System.out.println(machin.getType());
        // machin.generateRandomNum(80, 100);
        System.out.println(machin.dominance);
        System.out.println(machin.stress);

        RandomNum number = new RandomNum(80,100);
        number.generateRandomNum();



        // création du jeux
        Game game = new Game(juliette,machin);
        game.test();
        game.init();
    }
}
