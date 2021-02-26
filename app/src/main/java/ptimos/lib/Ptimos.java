package ptimos.lib;

abstract public class Ptimos {
    String type;
    int stress;
    int life = 100;
    int dominance;
    int rarity;

    public Ptimos(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public int getLife() {
        return this.life;
    }

    public int getRarity() {
        return this.rarity;
    }

    // fonction récursive
    public int generateRandomNum(int min, int max) {
        System.out.println("randomNum");
        double coef = Math.random();
        int index = String.valueOf(max).length();
        int result = (int) (coef * 10);
        System.out.println(result);
        if (result < min || result > max) {
            return generateRandomNum(min, max);
        } else {
            return result;
        }

    }

    public void attack() {}

    public void roar() {}

    public void moveAway() {}

    public void magicAttack() {}
}
