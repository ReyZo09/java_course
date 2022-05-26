package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class UserModifyTest extends TestBase {
    @Test(enabled = false)
    public void testUserModification() {
        app.goTo().groupPage();
        GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
        if (!app.group().isThereAGroup()) {
            app.group().create(group);
        }
        app.goTo().goToHomePage();
        if (!app.getUsersHelper().isThereAUser()) {
            app.goTo().goToAddNewUser();
            app.getUsersHelper().createUser();
            app.goTo().goToHomePage();
        }
        app.getUsersHelper().initUserModification();
        app.getUsersHelper().fillFirstName("TestModified");
        app.getUsersHelper().submitUserModification();
    }
}
