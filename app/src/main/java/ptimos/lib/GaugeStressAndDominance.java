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
        this.finalResult = this.element < 26 ? this.tabResult[0] : this.element < 51 ? this.tabResult[1] : this.element < 76 ? this.tabResult[2] : this.tabResult[3];
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