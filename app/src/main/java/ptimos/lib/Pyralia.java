package ptimos.lib;

public class Pyralia extends Ptimos{
    
    public Pyralia(String type,Human target) {
        super(type,target);
        this.dominance = (new RandomNum(50, 80).generateRandomNum()) + this.bonusMalusPyralia();
        this.stress = (new RandomNum(50, 80).generateRandomNum()) - this.bonusMalusPyralia();
    }

    // calcul le bonus et malus de pyralia
    // pyralia est moin stresse mais plus dominant
    public int bonusMalusPyralia() {
        int bonusMalus = new RandomNum(0, 10).generateRandomNum();
        return bonusMalus;
    }
}
