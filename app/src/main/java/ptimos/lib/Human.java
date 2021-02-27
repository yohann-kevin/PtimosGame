package ptimos.lib;

public class Human {
    private String name;
    private int life = 100;
    private int ptimoCage = 10;
    private int candy = 30;
    private int sleepingArrow = 1;
    
    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int dps) {
        this.life -= dps;
    }

    public int getPtimoCage() {
        return this.ptimoCage;
    }

    public int getCandy() {
        return this.candy;
    }

    public int getSleepingArrow() {
        return this.sleepingArrow;
    }

    public void watch() {}

    public void moveforward() {}

    public void launchCandy(Ptimos target) {
        System.out.println(target.stress -= 10);
    }

    public void awesomeDance() {}

    public void shotArrow() {}

    public void Escape() {}
}
