package ptimos.lib;

public class SacBleu extends Ptimos {
    
    public SacBleu(String type,Human target) {
        super(type,target);
        this.dominance = (new RandomNum(50, 80).generateRandomNum()) - this.bonusMalusSacbleu();
        this.stress = (new RandomNum(50, 80).generateRandomNum()) + this.bonusMalusSacbleu();
    }

    public int bonusMalusSacbleu() {
        int bonusMalus = new RandomNum(0, 10).generateRandomNum();
        return bonusMalus;
    }
}