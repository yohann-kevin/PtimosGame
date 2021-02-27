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
        System.out.println("Stress perçu : ");
        System.out.println(" ");
        System.out.println(target.getStress() + " " + this.gaugeStress(target.getStress()));
        System.out.println(" ");
        System.out.println("Dominance perçu : ");
        System.out.println(" ");
        System.out.println(target.getDominance() + " " + this.gaugeDominance(target.getDominance()));
    }

    public String gaugeStress(int stress) {
        if (stress < 26) {
            return "(détendu)";
        } else if (stress > 25 && stress < 51) {
            return "(méfiant)";
        } else if (stress > 50 && stress < 76) {
            return "(nerveux)";
        } else {
            return "(paniqué)";
        }
    }

    public String gaugeDominance(int stress) {
        if (stress < 26) {
            return "(inoffensif)";
        } else if (stress > 25 && stress < 51) {
            return "(neutre)";
        } else if (stress > 50 && stress < 76) {
            return "(féroce)";
        } else {
            return "(dangeureux)";
        }
    }

    public void moveforward() {}

    public void launchCandy(Ptimos target) {
        target.setStress(10);
        System.out.println(target.getStress());
    }

    public void awesomeDance() {}

    public void shotArrow() {}

    public void Escape() {}
}
