package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class UserDeletionTest extends TestBase{
    @Test(enabled = false)
    public void testUserDeletion() {
        app.goTo().goToHomePage();
        if (!app.getUsersHelper().isThereAUser()) {
            app.goTo().goToAddNewUser();
            app.getUsersHelper().createUser();
            app.goTo().goToHomePage();
        }
        app.getUsersHelper().selectUser();
        app.getUsersHelper().submitUserDeletion();
        app.getUsersHelper().alertCheck();
        app.getUsersHelper().alertDismiss();
        app.getUsersHelper().submitUserDeletion();
        app.getUsersHelper().alertCheck();
        app.getUsersHelper().alertAccept();
    }
}
