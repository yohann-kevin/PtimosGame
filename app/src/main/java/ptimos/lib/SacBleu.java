package ptimos.lib;

public class SacBleu extends Ptimos {
    private int sacbleuRarity = 1;
    
    public SacBleu(String type) {
        super(type);
        this.rarity = sacbleuRarity;
        // this.dominance = this.generateDominanceAndStress();
        // this.stress = this.generateDominanceAndStress();
    }

    // public int generateDominanceAndStress() {
    //     return this.generateRandomNum(80, 100);
    // }
}