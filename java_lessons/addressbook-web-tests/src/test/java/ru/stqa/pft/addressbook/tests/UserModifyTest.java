package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class UserModifyTest extends TestBase {
    @Test
    public void testUserModification() {
        app.getUsersHelper().initUserModification();
        app.getUsersHelper().fillFirstName("TestModified");
        app.getUsersHelper().submitUserModification();
    }
}
