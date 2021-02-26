package ptimos.lib;

public class RandomNum {
    int max;
    int min;
    public RandomNum(int max,int min) {
        this.max = max;
        this.min = min;
    }

    public int generateRandomNum() {
        int plop1 = 1;
        int plop2 = 5;
        double result = Math.random() * ( this.max - this.min ) + this.min;
        System.out.println("final result : " + (int) result);
        return (int) result;
    }
}
