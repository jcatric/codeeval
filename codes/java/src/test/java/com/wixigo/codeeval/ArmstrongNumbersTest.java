package com.wixigo.codeeval;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test de la classe {@link ArmstrongNumbers}
 * 
 * @author jcatric
 */
public class ArmstrongNumbersTest {

    /**
     * Test de la méthode {@link ArmstrongNumbers#isAmstrongNumber()}
     */
    @Test
    public void testIsAmstrongNumber() {
        assertTrue(ArmstrongNumbers.isAmstrongNumber("6"));
        assertTrue(ArmstrongNumbers.isAmstrongNumber("153"));
        assertFalse(ArmstrongNumbers.isAmstrongNumber("351"));
    }
}
