package org.margo.valocb.model;

import org.junit.jupiter.api.Test;

import static fixtures.ProductFixtures.*;
import static fixtures.UnderlyingFixtures.U1;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getPriceTest() {
        assertEquals(P1.getPrice(), 10);
        assertEquals(P2.getPrice(), 226);
        assertEquals(P3.getPrice(), 3);
    }

    @Test
    void productEqualsTest() {
        assertTrue(P1.equals(P1));
        assertFalse(P1.equals(P2));
        assertFalse(P1.equals(U1));
        assertFalse(P1.equals(null));
    }

    @Test
    void productHashCodeTest(){
        assertEquals(P1.hashCode(), 2560);
    }
}