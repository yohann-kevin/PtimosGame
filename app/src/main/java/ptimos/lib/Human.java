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

    // getter and setter
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

    // all method
    public void watching(Ptimos target) {
        GaugeStressAndDominance gauge = new GaugeStressAndDominance(target.getStress(), target.getDominance());
        System.out.println("Stress perçu : ");
        System.out.println(" ");
        gauge.gauge(true);
        System.out.println(target.getStress() + " " + gauge.getFinalResult());
        System.out.println(" ");
        System.out.println("Dominance perçu : ");
        System.out.println(" ");
        gauge.gauge(false);
        System.out.println(target.getDominance() + " " + gauge.getFinalResult());
    }

    public int moveforward() {
        return new RandomNum(3,8).generateRandomNum();
    }

    public void launchCandy(Ptimos target) {
        target.setStress(10);
        System.out.println(target.getStress());
    }

    public void awesomeDance() {}

    public void shotArrow() {}

    public void Escape() {}
}
