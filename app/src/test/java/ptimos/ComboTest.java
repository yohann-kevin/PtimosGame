package ptimos;

import org.junit.Test;

import ptimos.poker.Combo;

import static org.junit.Assert.*;

public class ComboTest {

    @Test 
    public void testPair1() {
        String[] cards = {"5-c","5-s","K-d","8-h","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkPair());
    }

    @Test 
    public void testPair2() {
        String[] cards = {"5-c","3-c","K-d","8-h","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(false,combo.checkPair());
    }

    @Test 
    public void testPair3() {
        String[] cards = {"3-h","3-s","3-c","4-c","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        System.out.println("------test------");
        assertEquals(true,combo.checkPair());
    }

    @Test 
    public void testDoublePair() {
        String[] cards = {"5-c","5-s","K-d","4-d","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkPair());
    }

    @Test 
    public void testDoublePair2() {
        String[] cards = {"4-c","4-s","K-d","4-d","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(false,combo.checkPair());
    }

    @Test 
    public void testBrelan1() {
        String[] cards = {"5-c","5-s","K-d","5-d","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkBrelan());
    }

    @Test 
    public void testBrelan2() {
        String[] cards = {"5-c","5-s","K-d","4-d","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(false,combo.checkBrelan());
    }

    @Test 
    public void testBrelan3() {
        String[] cards = {"3-h","3-s","3-c","4-c","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkBrelan());
    }

    @Test 
    public void testQuinte1() {
        String[] cards = {"2-c","3-s","4-d","5-d","6-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkQuinte());
    }

    @Test 
    public void testQuinte2() {
        String[] cards = {"A-c","2-s","3-d","4-d","5-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkQuinte());
    }

    @Test 
    public void testQuinte3() {
        String[] cards = {"8-c","2-s","3-d","4-d","5-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(false,combo.checkQuinte());
    }

    @Test 
    public void testFlush1() {
        String[] cards = {"8-c","2-c","3-c","4-c","5-c"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkFlush());
    }

    @Test 
    public void testFlush2() {
        String[] cards = {"8-s","2-c","3-c","4-c","5-c"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(false,combo.checkFlush());
    }

    @Test 
    public void testFull1() {
        String[] cards = {"3-h","3-s","3-c","4-c","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkFull());
    }

    @Test 
    public void testFull2() {
        String[] cards = {"8-s","2-c","3-c","4-c","5-c"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(false,combo.checkFull());
    }

    @Test 
    public void testSquare1() {
        String[] cards = {"8-s","8-c","3-c","8-h","8-d"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkSquare());
    }

    @Test 
    public void testSquare2() {
        String[] cards = {"7-s","7-c","3-c","8-h","8-d"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(false,combo.checkSquare());
    }

    @Test 
    public void testQuinteFlush1() {
        String[] cards = {"2-c","3-c","4-c","5-c","6-c"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(true,combo.checkQuinteFlush());
    }

    @Test 
    public void testQuinteFlush2() {
        String[] cards = {"2-c","3-c","4-c","5-c","6-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals(false,combo.checkQuinteFlush());
    }

    @Test 
    public void testCombo1() {
        String[] cards = {"2-c","3-c","4-c","5-c","6-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("quinte",combo.checkCombo());
    }

    @Test 
    public void testCombo2() {
        String[] cards = {"3-h","3-c","8-c","9-c","6-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("pair",combo.checkCombo());
    }

    @Test 
    public void testCombo3() {
        String[] cards = {"2-c","3-c","4-c","5-c","6-c"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("quinte-flush",combo.checkCombo());
    }

    @Test 
    public void testCombo4() {
        String[] cards = {"5-c","5-s","K-d","5-d","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("brelan",combo.checkCombo());
    }

    @Test 
    public void testCombo5() {
        String[] cards = {"8-s","8-c","3-c","8-h","8-d"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("carré",combo.checkCombo());
    }

    @Test 
    public void testCombo6() {
        String[] cards = {"8-c","2-c","3-c","4-c","5-c"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("flush",combo.checkCombo());
    }

    @Test 
    public void testCombo7() {
        String[] cards = {"3-h","3-s","3-c","4-c","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("full",combo.checkCombo());
    }

    @Test 
    public void testResult1() {
        String[] cards = {"2-c","3-c","4-c","5-c","6-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("fuit",combo.decideAction());
    }

    @Test 
    public void testResult2() {
        String[] cards = {"3-h","3-c","8-c","9-c","6-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("atkMagic",combo.decideAction());
    }

    @Test 
    public void testResult3() {
        String[] cards = {"2-c","3-c","4-c","5-c","6-c"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("assome",combo.decideAction());
    }

    @Test 
    public void testResult4() {
        String[] cards = {"5-c","5-s","K-d","5-d","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("fuit",combo.decideAction());
    }

    @Test 
    public void testResult5() {
        String[] cards = {"8-s","8-c","3-c","8-h","8-d"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("assome",combo.decideAction());
    }

    @Test 
    public void testResult6() {
        String[] cards = {"8-c","2-c","3-c","4-c","5-c"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("fuit",combo.decideAction());
    }

    @Test 
    public void testResult7() {
        String[] cards = {"3-h","3-s","3-c","4-c","4-h"};
        Combo combo = new Combo(cards);
        combo.initCombo();
        assertEquals("assome",combo.decideAction());
    }
    
}
