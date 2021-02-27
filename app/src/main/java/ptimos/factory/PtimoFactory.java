package ptimos.factory;

import ptimos.lib.Ptimos;
import ptimos.lib.SacBleu;
import ptimos.lib.Pyralia;
import ptimos.lib.Pokrand;

public class PtimoFactory {
    private static PtimoFactory instance = new PtimoFactory();

    private PtimoFactory() {};

    public static PtimoFactory getPtimoFactory() {
        return instance;
    }

    public Ptimos getPtimo(String type) {
        if (type.equals("sacbleu")) {
            return new SacBleu("sacbleu");
        } else if(type.equals("pyralia")) {
            return new Pyralia("pyralia");
        } else {
            return new Pokrand("pokrand");
        }
    }
}
