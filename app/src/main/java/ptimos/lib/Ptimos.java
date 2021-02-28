package ptimos.lib;

abstract public class Ptimos {
    String type;
    protected int stress;
    protected int dominance;
    Human target;

    public Ptimos(String type,Human target) {
        this.type = type;
        this.target = target;
    }

    // getter and setter
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

    // all method

    public void feedback() {
        System.out.println(this.type + " réagis !");
        this.roar();
    }

    public void roar() {
        int bonus  = new RandomNum(0, 20).generateRandomNum();
        this.dominance += bonus;
        this.stress -= bonus;
    }

    public void attack() {
        int dps = new RandomNum(0, 20).generateRandomNum();
        this.target.setLife(dps);
    }

    public void moveAway() {}

    public void magicAttack() {}
}
