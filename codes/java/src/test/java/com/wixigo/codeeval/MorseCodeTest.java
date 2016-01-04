package com.wixigo.codeeval;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test de la classe {@link MorseCode}
 * 
 * @author jcatric
 */
public class MorseCodeTest {

    /**
     * Test de la méthode {@link MorseCode#decodeMorse()}
     */
    @Test
    public void testDecodeMorse() {
        assertEquals("AV2WHIECX 45", MorseCode.decodeMorse(".- ...- ..--- .-- .... .. . -.-. -..-  ....- ....."));
        assertEquals("BH3", MorseCode.decodeMorse("-... .... ...--"));
    }
}
