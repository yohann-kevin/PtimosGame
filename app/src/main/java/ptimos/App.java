package ptimos;

import ptimos.factory.HumanFactory;
import ptimos.factory.PtimoFactory;
import ptimos.lib.Human;
import ptimos.lib.Ptimos;

public class App {
    public static void main(String[] args) {
        HumanFactory factoryHuman = HumanFactory.getHumanFactory();
        Human juliette = factoryHuman.getHuman("Juliette");
        System.out.println(juliette.getName());

        PtimoFactory factoryPtimo = PtimoFactory.getPtimoFactory();
        Ptimos machin = factoryPtimo.getPtimo("sacbleu");
        System.out.println(machin.getType());
        machin.generateRandomNum(1, 3);
    }
}
