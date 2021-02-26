package ptimos.factory;

import ptimos.lib.Human;

public class HumanFactory {
    private static HumanFactory instance = new HumanFactory();

    private HumanFactory() {};

    public static HumanFactory getHumanFactory() {
        return instance;
    }

    public Human getHuman(String name) {
        return new Human(name);
    }
}
