package ptimos;

import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

import ptimos.factory.PtimoFactory;
import ptimos.lib.Ptimos;





public class PtimoTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testGetType() {
        PtimoFactory factoryPtimo = PtimoFactory.getPtimoFactory();
        Ptimos machin = factoryPtimo.getPtimo("sacbleu");
        assertEquals("sacbleu",machin.getType());
    }

    @Test
    public void testGetLife() {
        PtimoFactory factoryPtimo = PtimoFactory.getPtimoFactory();
        Ptimos machin = factoryPtimo.getPtimo("sacbleu");
        assertEquals(100,machin.getLife());
           
    }

    @Test
    public void testGetRarity() {
        PtimoFactory factoryPtimo = PtimoFactory.getPtimoFactory();
        Ptimos machin = factoryPtimo.getPtimo("sacbleu");
        assertEquals(1,machin.getRarity());
    }
}