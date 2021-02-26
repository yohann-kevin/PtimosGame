package ptimos.lib;

public class SacBleu extends Ptimos {
    
    public SacBleu(String type) {
        super(type);
        this.dominance = new RandomNum(50, 80).generateRandomNum();
        this.stress = new RandomNum(50, 80).generateRandomNum();
    }
}