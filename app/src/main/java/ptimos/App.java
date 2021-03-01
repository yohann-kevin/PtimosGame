package ptimos;

import ptimos.factory.HumanFactory;
import ptimos.lib.Human;
import ptimos.poker.MainCards;

public class App {
    public static void main(String[] args) {
        // gère l'encodage
        System.setProperty( "file.encoding", "UTF-8" );

        MainCards poker = new MainCards();
        poker.getCards();
        
        // création de juliette
        HumanFactory factoryHuman = HumanFactory.getHumanFactory();
        Human juliette = factoryHuman.getHuman("Juliette");

        // test
        System.out.println(juliette.getName());

        // création du jeux
        Game game = new Game(juliette);
        
        // game.test();
        game.init();
    }
}
