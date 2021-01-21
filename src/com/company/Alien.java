/*
 * Classname: Alien.java
 *
 * Version information: 1.0
 *
 * Date: 21/01/2021
 *
 * Description: The class implements an Alien for a game. The health of the alien object determines if the alien is
 * alive and or dodging. If the health attribute is 0 then the alien attribute 'dead' MUST be true. The alien cannot be
 * dodging if they are dead. Likewise, the alien cannot be dead if they health value is >0.
 * Author: Dr. Shane Wilson
 *
 */
//Jack will take Alien and build unit tests to raygun
package com.company;

public class Alien {
    //Data members
    private boolean dead;
    private boolean dodging;
    private int alienHealth;

    //Class constructors
    public Alien(boolean dodging, int alienHealth) {
        //TODO: Construct the Alien object and initialise the data members appropriately.
        //J: alienHealth > 0, or set to default value.
        //dodging is true
    }

    // Methods
    //TODO: Implement appropriate getters and setters for the class

    public void dodge() {
        //TODO: Implement the method
        /*Set dodging to true if the alien is alive*/
        //J: alien will be able to doge once at the start, then subsequent shots will hit, as miss() sets to false.
        //will add rng to compliment after initial code passes as expected.

    }

    public void hit() {
        //TODO: Implement the method
        /*Reduces the alien health by 1. Minimum Alien health should 0.*/
        //j: test to see if alien is dead or not after each hit.
    }

    public void miss() {
        //TODO: Implement the method
        /*Sets dodging to false*/
        //J: set dodging to false if if the previous shot was dodged.
    }

}
