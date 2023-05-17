package org.margo.valocb.model;
import org.junit.jupiter.api.Test;

import static fixtures.UnderlyingFixtures.*;
import static org.junit.jupiter.api.Assertions.*;


class UnderlyingTest {

    @Test
    void getPriceTest() {
        assertEquals(U1.getPrice(), 5);
        assertEquals(U2.getPrice(), 5);
        assertEquals(U3.getPrice(), 10);
        assertEquals(U4.getPrice(), 16);
        assertEquals(U5.getPrice(), 200);
        assertEquals(U6.getPrice(), 3);
    }
}