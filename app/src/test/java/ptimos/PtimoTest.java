package ptimos;

import org.junit.Test;
import static org.junit.Assert.*;

import ptimos.factory.PtimoFactory;
import ptimos.lib.Ptimos;

public class PtimoTest {

    @Test
    public void testGetType() {
        PtimoFactory factoryPtimo = PtimoFactory.getPtimoFactory();
        // Ptimos machin = factoryPtimo.getPtimo("sacbleu");
        // assertEquals("sacbleu",machin.getType());
    }
}