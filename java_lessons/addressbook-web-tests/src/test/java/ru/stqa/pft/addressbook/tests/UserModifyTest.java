package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class UserModifyTest extends TestBase {
    @Test(enabled = false)
    public void testUserModification() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        app.getNavigationHelper().goToHomePage();
        if (!app.getUsersHelper().isThereAUser()) {
            app.getNavigationHelper().goToAddNewUser();
            app.getUsersHelper().createUser();
            app.getNavigationHelper().goToHomePage();
        }
        app.getUsersHelper().initUserModification();
        app.getUsersHelper().fillFirstName("TestModified");
        app.getUsersHelper().submitUserModification();
    }
}
