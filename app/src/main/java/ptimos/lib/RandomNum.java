package ptimos.lib;

public class RandomNum {
    int max;
    int min;
    public RandomNum(int min,int max) {
        this.min = min;
        this.max = max;
    }

    public int generateRandomNum() {
        double result = Math.random() * ( this.max - this.min ) + this.min;
        return (int) result;
    }
}
