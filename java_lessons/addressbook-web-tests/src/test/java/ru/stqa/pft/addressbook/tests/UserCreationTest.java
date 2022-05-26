package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class UserCreationTest extends TestBase {
    @Test(enabled = false)
    public void testUserCreation() {
        app.goTo().groupPage();
        GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
        if (!app.group().isThereAGroup()) {
            app.group().create(group);
        }
        app.goTo().goToAddNewUser();
        app.getUsersHelper().createUser();
        app.goTo().goToHomePage();
    }
}