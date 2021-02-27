package ptimos.lib;

abstract public class Ptimos {
    String type;
    protected int stress;
    protected int dominance;

    public Ptimos(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public int getStress() {
        return this.stress;
    }

    public void setStress(int malus) {
        this.stress -= malus;
    }

    public int getDominance() {
        return this.dominance;
    }

    public void setDominance(int malus) {
        this.dominance -= malus;
    }

    public void attack(Human target) {
        int dps = 10;
        target.setLife(dps);
    }

    public void roar() {}

    public void moveAway() {}

    public void magicAttack() {}
}
