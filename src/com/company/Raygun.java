/*
* Classname: Raygun.java
*
* Version information: 1.0
*
* Date: 21/01/2021
*
* Description: The class implements a ray gun for a game
*
* Author: Dr. Shane Wilson
*
*/
//Michael to take raygun and build unit tests for alien
package com.company;

public class Raygun {
    //Data members
    private int mChrg; //The maximum charge the Raygun can hold
    private int cChrg; //The current level of charge the Raygun has

    //Class constructors
    public Raygun(int mChrg, int cChrg) {
        //TODO: Construct the Raygun object and initialise the attributes
        this.mChrg = mChrg;
        this.cChrg = cChrg;
    }

    // Methods
    //TODO: Implement appropriate getters and setters for the class

    public void fireAt(Alien a) {
        //TODO: Implement the method
        /*The gun should only fire if it is charged. Firing the gun will reduce the charge by 1. If the bug isDodging
        * bug.miss() should be called, otherwise bug.hit
        *
        *  */
        if(isCharged()) {
            if (a.isDodging()) {
                a.miss();
            } else a.hit();
            this.cChrg--;
            }
        }


    public void recharge() {
        //TODO: Implement the method
        /*Increases the current charge by 1*/
        if(!isFullyCharged())
        this.cChrg = this.cChrg + 1;
    }

    public boolean isCharged() {
        //TODO: Implement the method
        /*Returns true if the gun has a charge*/
        if (cChrg > 0 )  return true;
        return false;
    }

    public boolean isFullyCharged() {
        //TODO: Implement the method
        /*Returns true if the gun is fully charged*/
        if(cChrg == mChrg) return true;
        return  false;
    }

    public int getcChrg() {
        return cChrg;
    }
}
