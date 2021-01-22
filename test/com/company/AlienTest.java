package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    private Alien alien;

    @BeforeEach
    public void init(){
        this.alien = new Alien(true,3);
    }

    @Test
    @DisplayName("dodge test case, Set dodging to true if the alien is alive")
    void dodge_test_case() {
        alien.dodge();
        boolean actual = alien.isDead();
        assertFalse(actual);
    }

    @DisplayName("hit test case, Reduces the alien health by 1")
    @Test
    void hit_test_case() {
        alien.hit();
        int actual = alien.getAlienHealth();
        assertEquals(2, actual);
    }

    @DisplayName("miss test case, Sets dodging to false")
    @Test
    void miss_test_case() {
        alien.miss();
        boolean actual = alien.isDodging();
        assertFalse( actual);
    }

    @DisplayName("set dead test case, Sets dead to true if alien Health is < 0")
    @Test
    void setDead_test_case() {
        alien.setDead(0);
        boolean actual = alien.isDead();
        assertTrue( actual);
    }
}