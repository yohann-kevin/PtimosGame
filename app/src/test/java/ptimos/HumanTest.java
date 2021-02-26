package ptimos;

import org.junit.Test;

import ptimos.factory.HumanFactory;
import ptimos.lib.Human;

import static org.junit.Assert.*;

public class HumanTest {
    @Test
    public void testGetName() {
        HumanFactory factoryHuman = HumanFactory.getHumanFactory();
        Human juliette = factoryHuman.getHuman("Juliette");
        assertEquals("Juliette",juliette.getName());
    }

    @Test
    public void testGetLife() {
        HumanFactory factoryHuman = HumanFactory.getHumanFactory();
        Human juliette = factoryHuman.getHuman("Juliette");
        assertEquals(100,juliette.getLife());
    }

    @Test
    public void testGetPtimoCage() {
        HumanFactory factoryHuman = HumanFactory.getHumanFactory();
        Human juliette = factoryHuman.getHuman("Juliette");
        assertEquals(10,juliette.getPtimoCage());
    }
}
