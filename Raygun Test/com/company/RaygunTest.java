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

    @Test
    public void RechargeRaygun_Test() {

        //Arrange


        //Act


        //Assert

    }

    //explicit use of expectedResult to avoid confusion
    public void IsCharged_Test_idealGun() {

        //Arrange
        Raygun idealGun = new Raygun(10,5); //raygun has 5/10 charges and can be fired.
        boolean expectedResult = true;
        boolean actualResult;

        //Act
        actualResult = idealGun.isCharged();

        //Assert
        Assert.assertEquals(actualResult, expectedResult);
    }

    //explicit use of expectedResult to avoid confusion
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