package ptimos.lib;

public class GaugeStressAndDominance {
    String[] resultStress = {"(détendu)","(méfiant)","(nerveux)","(paniqué)"};
    String[] resultDominance = {"(inoffensif)","(neutre)","(féroce)","(dangeureux)"};
    String[] tabResult = new String[resultStress.length];
    String finalResult;
    int stress;
    int dominance;
    int element;

    public GaugeStressAndDominance(int stress, int dominance) {
        this.stress = stress;
        this.dominance = dominance;
    }

    public void gauge(boolean isStress) {
        isStress(isStress);
        if (this.element < 26) {
            this.finalResult = this.tabResult[0];
        } else if (this.element > 25 && this.element < 51) {
            this.finalResult = this.tabResult[1];
        } else if (this.element > 50 && this.element < 76) {
            this.finalResult = this.tabResult[2];
        } else {
            this.finalResult = this.tabResult[3];
        }
    }

    public void isStress(boolean isStress) {
        if (isStress) {
            this.tabResult = this.resultStress;
            this.element = this.stress;
        } else {
            this.tabResult = this.resultDominance;
            this.element = this.dominance;
        }
    }

    public String getFinalResult() {
        return this.finalResult;
    }
}