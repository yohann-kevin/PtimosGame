package ptimos.lib;

public class RandomNum {
    private int max;
    private int min;
    public RandomNum(int min,int max) {
        this.min = min;
        this.max = max;
    }

    // renvoie une valeur aléatoire entre le min et le max
    public int generateRandomNum() {
        double result = Math.random() * ( this.max - this.min ) + this.min;
        return (int) result;
    }
}
