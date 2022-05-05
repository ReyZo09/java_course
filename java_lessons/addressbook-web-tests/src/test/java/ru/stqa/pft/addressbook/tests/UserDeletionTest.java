package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserDeletionTest extends TestBase{
    @Test
    public void testUserDeletion() {
        app.getUsersHelper().selectUser();
        app.getUsersHelper().submitUserDeletion();
        app.getUsersHelper().alertCheck();
        app.getUsersHelper().alertDismiss();
        app.getUsersHelper().submitUserDeletion();
        app.getUsersHelper().alertCheck();
        app.getUsersHelper().alertAccept();
    }
}
