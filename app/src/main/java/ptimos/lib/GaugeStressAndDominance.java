package ptimos.lib;

public class GaugeStressAndDominance {
    private String[] resultStress = {"(détendu)","(méfiant)","(nerveux)","(paniqué)"};
    private String[] resultDominance = {"(inoffensif)","(neutre)","(féroce)","(dangeureux)"};
    private String[] tabResult = new String[resultStress.length];
    private String finalResult;
    private int stress;
    private int dominance;
    private int element;

    public GaugeStressAndDominance(int stress, int dominance) {
        this.stress = stress;
        this.dominance = dominance;
    }

    // renvoie le bon therme en fonction du stress et de la dominance
    // !complexity
    public void gauge(boolean isStress) {
        isStress(isStress);
        this.finalResult = this.element < 26 ? this.tabResult[0] : this.element < 51 ? this.tabResult[1] : this.element < 76 ? this.tabResult[2] : this.tabResult[3];
    }

    // vérifie si on calcul le stress ou la dominance
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