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

public class Alien  {

    private boolean dead ;
    private boolean dodging;
    private int alienHealth;



    public Alien(boolean dodging, int alienHealth ) {
        this.dodging = dodging;
//input sanitation:
        if(alienHealth <=0){
            this.alienHealth = 10; //default health used if no valid input.
        }
        else {
            this.alienHealth = alienHealth;
        }
        this.setDead(this.alienHealth);
    }



    public void dodge() {
        /*Set dodging to true if the alien is alive*/
        //J: alien will be able to doge once at the start, then subsequent shots will hit, as miss() sets to false.
        //will add rng to compliment after initial code passes as expected.
        if( this.dodging ){
            this.miss();
        } else {
            this.hit();
        }

    }

    public void hit() {
        /*Reduces the alien health by 1. Minimum Alien health should 0.*/
        //j: test to see if alien is dead or not after each hit.
        if(this.alienHealth >= 1) {
            this.alienHealth--;
            this.setDead(this.alienHealth);
        } else if (this.alienHealth == 0){
            System.out.println("Stop, Stop! He's Already Dead");
        }
    }

    public void miss() {
        /*Sets dodging to false*/
        //J: set dodging to false if if the previous shot was dodged.
        this.dodging = false;
    }

    public void setDead(int alienHealth) {
        if(alienHealth <= 0) {
             this.dead = true;
             this.dodging = false; //dead aliens cannot dodge
            System.out.println("Alien is now dead");
           }
        else {
            this.dead = false;
        }
    }


    //getters for use in testing
    public boolean isDodging() {
        return dodging;
    }

    public boolean isDead() {
        return dead;
    }

    public int getAlienHealth() {
        return alienHealth;
    }

}
