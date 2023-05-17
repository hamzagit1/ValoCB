package org.margo.valocb.model;

import org.junit.jupiter.api.Test;

import static fixtures.PortfolioFixtures.PTF1;
import static fixtures.PortfolioFixtures.PTF2;
import static org.junit.jupiter.api.Assertions.*;

class PortfolioTest {

    @Test
    void getPriceTest() {
        assertEquals(PTF1.getPrice(), 236);
        assertEquals(PTF2.getPrice(), 3);
    }
}