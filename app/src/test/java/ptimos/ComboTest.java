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
}
