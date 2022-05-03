package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase{

    public GroupHelper(ChromeDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        clickElement(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        clickElement(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.name());
        type(By.name("group_header"), groupData.name());
        type(By.name("group_footer"), groupData.name());
    }

    public void initGroupCreation() {
        clickElement(By.name("new"));
    }

    public void deleteSelectedGroup() {
        clickElement(By.name("delete"));
    }

    public void selectGroup() {
        clickElement(By.name("selected[]"));
    }

    public void initGroupModification() {
        clickElement(By.name("edit"));
    }

    public void submitGroupModification() {
        clickElement(By.name("update"));
    }
}
