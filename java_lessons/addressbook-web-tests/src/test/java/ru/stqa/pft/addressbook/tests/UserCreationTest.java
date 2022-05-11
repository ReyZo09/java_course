package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class UserCreationTest extends TestBase {
    @Test
    public void testUserCreation() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        app.getNavigationHelper().goToAddNewUser();
        app.getUsersHelper().createUser();
        app.getNavigationHelper().goToHomePage();
    }
}