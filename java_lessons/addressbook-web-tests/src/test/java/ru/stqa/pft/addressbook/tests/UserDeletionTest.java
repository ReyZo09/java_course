package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class UserDeletionTest extends TestBase{
    @Test(enabled = false)
    public void testUserDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getUsersHelper().isThereAUser()) {
            app.getNavigationHelper().goToAddNewUser();
            app.getUsersHelper().createUser();
            app.getNavigationHelper().goToHomePage();
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
