package ptimos.lib;

public class Pokrand extends Ptimos {
    
    public Pokrand(String type,Human target) {
        super(type,target);
        this.dominance = new RandomNum(60, 90).generateRandomNum();
        this.stress = new RandomNum(60, 90).generateRandomNum();
    }
}
