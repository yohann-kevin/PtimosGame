package ptimos.factory;

import ptimos.lib.Ptimos;
import ptimos.lib.SacBleu;
import ptimos.lib.Pyralia;
import ptimos.lib.Human;
import ptimos.lib.Pokrand;

public class PtimoFactory {
    private static PtimoFactory instance = new PtimoFactory();

    private PtimoFactory() {};

    // retourne l'instance
    public static PtimoFactory getPtimoFactory() {
        return instance;
    }

    // choisi la bonne instance a crée en fonction du type
    public Ptimos getPtimo(String type,Human target) {
        if (type.equals("sacbleu")) {
            return new SacBleu("sacbleu",target);
        } else if(type.equals("pyralia")) {
            return new Pyralia("pyralia",target);
        } else {
            return new Pokrand("pokrand",target);
        }
    }
}
