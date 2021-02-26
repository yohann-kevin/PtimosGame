package ptimos.lib;

public class SacBleu extends Ptimos {
    private int sacbleuRarity = 1;
    
    public SacBleu(String type) {
        super(type);
        this.rarity = sacbleuRarity;
    }
}
