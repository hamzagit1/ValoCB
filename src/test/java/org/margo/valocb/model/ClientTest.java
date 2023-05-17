package org.margo.valocb.model;

import org.junit.jupiter.api.Test;


import static fixtures.ClientFixtures.*;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    @Test
    void getCapitalTest() {
        assertEquals(C1.getCapital(), 4620);
        assertEquals(C2.getCapital(), 16);
        assertEquals(C3.getCapital(), 229);
        assertEquals(C4.getCapital(), 100);
        assertEquals(C5.getCapital(), 794);
    }
}