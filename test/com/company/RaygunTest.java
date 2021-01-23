package com.company;

import org.testng.Assert;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.*;

public class RaygunTest {


//need to assume Alien work...
    @Test
    public void FireAt_AlienTest_dodgingAlien_loadedGun() {

        //Arrange
        Alien testAlien = new Alien(true, 10); //init alien w.dodge
        Raygun testGunFull = new Raygun(10,10); //init gun w. ammo
        int alienHealth = testAlien.getAlienHealth(); //set evaluation variable explicit to prevent misunderstanding
        int rayGunAmmo = testGunFull.getcChrg(); //set evaluation variable explicit to prevent misunderstanding
        boolean isAlienDead = testAlien.isDead(); //live and well, and he should stay that way

        //expected returns
        int expectedAlienHealth = alienHealth; //expect alien to dodge, so no change to health
        int expectedRayGunAmmo = rayGunAmmo-1; //gun will fire, expect ammo to reduce by 1
        boolean expectedAlienIsDead = true; // we expect the xeno to still be alive.


        //Act
        testGunFull.fireAt(testAlien);
        alienHealth = testAlien.getAlienHealth(); //re-set to current value
        rayGunAmmo = testGunFull.getcChrg(); //re-set to current value
        isAlienDead = testAlien.isDead(); //check to see if dead

        //Assert
        Assert.assertEquals(alienHealth, expectedAlienHealth);
        Assert.assertEquals(rayGunAmmo, expectedRayGunAmmo);
        Assert.assertEquals(isAlienDead, expectedAlienIsDead);
    }

    @Test
    public void FireAt_AlienTest_dodgingAlien_emptyGun() {

        //Arrange
        Alien testAlien = new Alien(true, 10);
        Raygun testGunEmpty = new Raygun(10,0);
        int alienHealth = testAlien.getAlienHealth();
        int rayGunAmmo = testGunEmpty.getcChrg();
        boolean isAlienDead = testAlien.isDead(); //live and well, and he should stay that way

        //expected returns
        int expectedAlienHealth = alienHealth; //no changes as the shot will not fire or hit
        int expectedRayGunAmmo = rayGunAmmo; //no changes as the gun should not fire
        boolean expectedAlienIsDead = true; // we expect the xeno to still be alive.


        //Act
        testGunEmpty.fireAt(testAlien);
        alienHealth = testAlien.getAlienHealth();
        rayGunAmmo = testGunEmpty.getcChrg();
        isAlienDead = testAlien.isDead(); //check to see if dead

        //Assert
        Assert.assertEquals(alienHealth, expectedAlienHealth);
        Assert.assertEquals(rayGunAmmo, expectedRayGunAmmo);
        Assert.assertEquals(isAlienDead, expectedAlienIsDead);

    }

    @Test
    public void FireAt_AlienTest_incapacitatedAlien_fullGun() {

        //Arrange
        Alien testAlien = new Alien(false, 10); //init alien who cannot dodge
        Raygun testGunFull = new Raygun(10,10); //init gun w. ammo
        int alienHealth = testAlien.getAlienHealth(); //set evaluation variable explicit to prevent misunderstanding
        int rayGunAmmo = testGunFull.getcChrg(); //set evaluation variable explicit to prevent misunderstanding
        boolean isAlienDead = testAlien.isDead(); //live and well, and he should stay that way

        //expected returns
        int expectedAlienHealth = alienHealth-1; //expect alien not to dodge, so health will reduce by 1
        int expectedRayGunAmmo = rayGunAmmo-1; //gun will fire, expect ammo to reduce by 1
        boolean expectedAlienIsDead = true; // we expect the xeno to still be alive.

        //Act
        testGunFull.fireAt(testAlien);
        alienHealth = testAlien.getAlienHealth(); //re-set to current value
        rayGunAmmo = testGunFull.getcChrg(); //re-set to current value
        isAlienDead = testAlien.isDead(); //check to see if dead

        //Assert
        Assert.assertEquals(alienHealth, expectedAlienHealth);
        Assert.assertEquals(rayGunAmmo, expectedRayGunAmmo);
        Assert.assertEquals(isAlienDead, expectedAlienIsDead);
    }

    @Test
    public void FireAt_AlienTest_toKillAlien_fullGun() {

        //Arrange
        Alien testAlien = new Alien(false, 1); //init alien who cannot dodge
        Raygun testGunFull = new Raygun(10,10); //init gun w. ammo
        int alienHealth = testAlien.getAlienHealth(); //set evaluation variable explicit to prevent misunderstanding
        int rayGunAmmo = testGunFull.getcChrg(); //set evaluation variable explicit to prevent misunderstanding
        boolean isAlienDead = testAlien.isDead(); //expect still alive...for now!
        //expected returns
        int expectedAlienHealth = alienHealth-1; //expect alien not to dodge, so health will reduce by 1
        int expectedRayGunAmmo = rayGunAmmo-1; //gun will fire, expect ammo to reduce by 1
        boolean expectedAlienIsDead = true; // we expect the xeno to die.

        //Act
        testGunFull.fireAt(testAlien);
        alienHealth = testAlien.getAlienHealth(); //re-set to current value
        rayGunAmmo = testGunFull.getcChrg(); //re-set to current value
        isAlienDead = testAlien.isDead(); //check to see if dead

        //Assert
        Assert.assertEquals(alienHealth, expectedAlienHealth);
        Assert.assertEquals(rayGunAmmo, expectedRayGunAmmo);
        Assert.assertEquals(isAlienDead, expectedAlienIsDead);
    }


    //recharge the empty raygun by 1, evaluates if recharge works as expected.
    @Test
    public void RechargeRaygun_Test_emptyGun() {

        //Arrange
        Raygun emptyGun = new Raygun(10,0); //raygun has 0/10 charges, it can be charged, it cannot be fired
        int expectedResult = 1; //expected result for 0+1
        int actualResult;

        //Act
        emptyGun.recharge();
        actualResult = emptyGun.getcChrg(); //use getter to find result

        //Assert
        Assert.assertEquals(actualResult, expectedResult);

    }

    //recharge the raygun by 1, evaluates if its possible to overcharge a gun - expect nothing to happen
    @Test
    public void RechargeRaygun_Test_fullGun() {

        //Arrange
        Raygun fullGun = new Raygun(10,10); //raygun has 10/10 charges, it's full and can be fired
        int expectedResult = 10; //expected result for a gun that is at the limit
        int actualResult;

        //Act
        fullGun.recharge();
        actualResult = fullGun.getcChrg(); //use getter to find result

        //Assert
        Assert.assertEquals(actualResult, expectedResult);

    }

    //recharge the raygun by 1, evaluates if its possible to add one when there are remaining charges - expect 7 to go to 8
    @Test
    public void RechargeRaygun_Test_partiallyFullGun() {

        //Arrange
        Raygun partiallyFullGun = new Raygun(10,7); //raygun has 10/10 charges, it's full and can be fired
        int expectedResult = 8; //expected result for a gun that has 7, and is reloaded by 1, (8)
        int actualResult;

        //Act
        partiallyFullGun.recharge();
        actualResult = partiallyFullGun.getcChrg(); //use getter to find result

        //Assert
        Assert.assertEquals(actualResult, expectedResult);

    }

    //explicit use of expectedResult to avoid confusion
    @Test
    public void IsCharged_Test_fullGun() {

        //Arrange
        Raygun fullGun = new Raygun(10,10); //raygun is full of ammo and wants to be fired
        boolean expectedResult = true;
        boolean actualResult;

        //Act
        actualResult = fullGun.isCharged();

        //Assert
        Assert.assertEquals(actualResult, expectedResult);
    }

    //explicit use of expectedResult to avoid confusion
    @Test
    public void IsCharged_Test_emptyGun() {

        //Arrange
        Raygun emptyGun = new Raygun(10,0); //raygun is out of ammo and cannot be fired.
        boolean expectedResult = false;
        boolean actualResult;

        //Act
        actualResult = emptyGun.isCharged();

        //Assert
        Assert.assertEquals(actualResult, expectedResult);
    }

    //explicit use of expectedResult to avoid confusion
    @Test
    public void IsCharged_Test_loadedButNotFullGun() {

        //Arrange
        Raygun loadedButNotFullGun = new Raygun(10,5); //raygun has 5/10 charges and can be fired.
        boolean expectedResult = true;
        boolean actualResult;

        //Act
        actualResult = loadedButNotFullGun.isCharged();

        //Assert
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void IsFullyCharged_Test_fullGun() {

        //Arrange
        Raygun fullGun = new Raygun(10,10); //raygun has 10/10 charges, is full and can be fired.
        boolean expectedResult = true;
        boolean actualResult;

        //Act
        actualResult = fullGun.isFullyCharged();

        //Assert
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void IsFullyCharged_Test_emptyGun() {

        //Arrange
        Raygun emptyGun = new Raygun(10,0); //raygun has 0/10 charges, is empty and cannot be fired.
        boolean expectedResult = false;
        boolean actualResult;

        //Act
        actualResult = emptyGun.isFullyCharged();

        //Assert
        Assert.assertEquals(actualResult, expectedResult);

    }

    //redundant check to filter for bugs
    @Test
    public void IsFullyCharged_Test_loadedButNotFullGun() {

        //Arrange
        Raygun halfFullGun = new Raygun(10,5); //raygun has 5/10 charges, is partially loaded and can be fired.
        boolean expectedResult = false;
        boolean actualResult;

        //Act
        actualResult = halfFullGun.isFullyCharged();

        //Assert
        Assert.assertEquals(actualResult, expectedResult);

    }


}