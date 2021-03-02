package ptimos;

import org.junit.Test;

import ptimos.poker.Combo;

import static org.junit.Assert.*;

public class ComboTest {

    @Test public void testPair1() {
        String[] cards = {"5-c","5-s","K-d","8-h","4-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(true,combo.checkPair());
    }

    @Test public void testPair2() {
        String[] cards = {"5-c","3-c","K-d","8-h","4-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(false,combo.checkPair());
    }

    @Test public void testPair3() {
        String[] cards = {"3-h","3-s","3-c","4-c","4-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        System.out.println("------test------");
        assertEquals(true,combo.checkPair());
    }

    @Test public void testDoublePair() {
        String[] cards = {"5-c","5-s","K-d","4-d","4-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(true,combo.checkPair());
    }

    @Test public void testBrelan1() {
        String[] cards = {"5-c","5-s","K-d","5-d","4-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(true,combo.checkBrelan());
    }

    @Test public void testBrelan2() {
        String[] cards = {"5-c","5-s","K-d","4-d","4-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(false,combo.checkBrelan());
    }

    @Test public void testBrelan3() {
        String[] cards = {"3-h","3-s","3-c","4-c","4-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(true,combo.checkBrelan());
    }

    @Test public void testQuinte1() {
        String[] cards = {"2-c","3-s","4-d","5-d","6-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(true,combo.checkQuinte());
    }

    @Test public void testQuinte2() {
        String[] cards = {"A-c","2-s","3-d","4-d","5-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(true,combo.checkQuinte());
    }

    @Test public void testQuinte3() {
        String[] cards = {"8-c","2-s","3-d","4-d","5-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(false,combo.checkQuinte());
    }

    @Test public void testFlush1() {
        String[] cards = {"8-c","2-c","3-c","4-c","5-c"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(true,combo.checkFlush());
    }

    @Test public void testFlush2() {
        String[] cards = {"8-s","2-c","3-c","4-c","5-c"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(false,combo.checkFlush());
    }

    @Test public void testFull1() {
        String[] cards = {"3-h","3-s","3-c","4-c","4-h"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(true,combo.checkFull());
    }

    @Test public void testFull2() {
        String[] cards = {"8-s","2-c","3-c","4-c","5-c"};
        Combo combo = new Combo(cards);
        combo.testCombo();
        assertEquals(false,combo.checkFull());
    }
}
