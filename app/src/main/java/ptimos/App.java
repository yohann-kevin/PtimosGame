package ptimos;

import ptimos.factory.HumanFactory;
import ptimos.lib.Human;

public class App {
    public static void main(String[] args) {
        // gère l'encodage
        System.setProperty( "file.encoding", "UTF-8" );
        
        // création de juliette
        HumanFactory factoryHuman = HumanFactory.getHumanFactory();
        Human juliette = factoryHuman.getHuman("Juliette");

        // création du jeux
        Game game = new Game(juliette);
        game.init();
    }
}
