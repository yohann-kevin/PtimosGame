package ptimos.lib;

abstract public class Ptimos {
    String type;
    public int stress;
    public int dominance;

    public Ptimos(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void attack(Human target) {
        int dps = 10;
        target.setLife(dps);
    }

    public void roar() {}

    public void moveAway() {}

    public void magicAttack() {}
}
