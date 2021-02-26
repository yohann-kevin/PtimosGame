package ptimos.lib;

abstract public class Ptimos {
    String type;
    public int stress;
    public int dominance;
    int rarity;

    public Ptimos(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public int getRarity() {
        return this.rarity;
    }

    // public int generateRandomNum(int min, int max) {
    //     double coef = Math.random();
    //     int index = String.valueOf(max).length();
    //     int result = (int) (coef * 100);
    //     if (result < min || result > max) {
    //         return generateRandomNum(min, max);
    //     } else {
    //         return result;
    //     }
    // }

    public void attack(Human target) {
        int dps = 10;
        target.setLife(dps);
    }

    public void roar() {}

    public void moveAway() {}

    public void magicAttack() {}
}
