package com.company;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RaygunTest {

    @Test
    public void FireAt_AlienTest() {

        //Arrange


        //Act


        //Assert

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