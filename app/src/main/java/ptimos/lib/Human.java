package ptimos.lib;

public class Human {
    private String name;
    private int life = 100;
    private int ptimoCage = 10;
    
    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public int getPtimoCage() {
        return this.ptimoCage;
    }

    public void watch() {}

    public void moveforward() {}

    public void launchCandy() {}

    public void awesomeDance() {}

    public void singLullaby() {}

    public void Escape() {}
}
