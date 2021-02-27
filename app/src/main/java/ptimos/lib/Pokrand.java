package ptimos.lib;

public class Pokrand extends Ptimos {
    
    public Pokrand(String type) {
        super(type);
        this.dominance = new RandomNum(50, 80).generateRandomNum();
        this.stress = new RandomNum(50, 80).generateRandomNum();
    }
}
