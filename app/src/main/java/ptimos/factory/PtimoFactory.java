package ptimos.factory;

import ptimos.lib.Ptimos;
import ptimos.lib.SacBleu;

public class PtimoFactory {
    private static PtimoFactory instance = new PtimoFactory();

    private PtimoFactory() {};

    public static PtimoFactory getPtimoFactory() {
        return instance;
    }

    public Ptimos getPtimo(String type) {
        if (type.equals("sacbleu")) return new SacBleu("sacbleu");
        return null;
    }
}
