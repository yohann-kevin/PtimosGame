package ptimos.lib;

public class Pyralia extends Ptimos{
    
    public Pyralia(String type) {
        super(type);
        this.dominance = new RandomNum(50, 80).generateRandomNum();
        this.stress = new RandomNum(50, 80).generateRandomNum();
    }
}
