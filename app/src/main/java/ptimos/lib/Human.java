package ptimos.lib;

public class Human {
    private String name;
    private int life = 100;
    private int ptimoCage = 10;
    private int candy = 30;
    private int sleepingArrow = 1;
    private int sacbleuCaptured;
    private int pyraliaCaptured;
    private int pokrandCaptured;
    public boolean ptimoIsCaptured;
    
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
        System.out.println("Vous vous rapprocher");
        return new RandomNum(3,8).generateRandomNum();
    }

    public void launchCandy(Ptimos target,int range) {
        this.candy--;
        int candyPower = 70 / range;
        int probaShot = new RandomNum(0, 100).generateRandomNum();
        if (probaShot < candyPower) {
            target.setStress(candyPower);
            System.out.println(target.getType() + " perd " + candyPower + " point de stress");
        } else {
            System.out.println("Vous feriez mieux d'apprendre à viser vous avez rater le " + target.getType());
        }
    }

    public void awesomeDance(Ptimos target) {
        int dancingPower = new RandomNum(7, 21).generateRandomNum();
        if (dancingPower < 15) {
            target.setDominance(dancingPower);
            System.out.println("Vous effectuer une dance asser sympa qui baisse la dominance du " + target.getType() + " de " + dancingPower + " point");
        } else {
            target.setDominance(dancingPower);
            System.out.println("Vous effectuer une dance tellement incroyable qu'elle baisse la dominance du " + target.getType() + " de " + dancingPower + " point !");
        }
    }

    public void shotArrow(Ptimos target) {
        System.out.println("Vous tirez une fléchette endormante sur le " + target.getType());
        this.sleepingArrow--;
        this.ptimoCage --;
        if (target.getType().equals("sacbleu")) {
            this.sacbleuCaptured++;
        } else if (target.getType().equals("pyralia")) {
            this.pyraliaCaptured++;
        } else {
            this.pokrandCaptured++;
        }
        this.ptimoIsCaptured = true;
    }

    public void Escape() {}
}
