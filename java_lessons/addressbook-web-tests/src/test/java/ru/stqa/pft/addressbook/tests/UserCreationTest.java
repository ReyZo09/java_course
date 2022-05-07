package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class UserCreationTest extends TestBase {
    @Test
    public void testUserCreation() {

        app.getNavigationHelper().goToAddNewUser();
        app.getUsersHelper().fillFirstName("Test");
        app.getUsersHelper().fillMiddleName("Testovich");
        app.getUsersHelper().fillLastName("Testov");
        app.getUsersHelper().fillAddress("City, street, building 1, apt. 1");
        app.getUsersHelper().fillEMail("test@test.test");
        app.getUsersHelper().fillBirthDay(9);
        app.getUsersHelper().fillBirthMonth("January");
        app.getUsersHelper().fillBirthYear("1990");
        app.getUsersHelper().fillGroupField("test1");
        app.getUsersHelper().submitUserCreation();
        app.getNavigationHelper().goToHomePage();
    }
}