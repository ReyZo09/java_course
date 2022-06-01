package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
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
        type(By.name("group_header"), groupData.header());
        type(By.name("group_footer"), groupData.footer());
    }

    public void initGroupCreation() {
        clickElement(By.name("new"));
    }

    public void deleteSelectedGroup() {
        clickElement(By.name("delete"));
    }

    public void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        clickElement(By.name("edit"));
    }

    public void submitGroupModification() {
        clickElement(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);   //данные, которыми заполнится форма группы
        submitGroupCreation();
        returnToGroupPage();
    }
    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);   //данные, которыми заполнится форма группы
        submitGroupModification();
        groupsCache = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    private Groups groupsCache = null;

    public Groups all() {
        if (groupsCache != null) {
            return new Groups(groupsCache);
        }
        groupsCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupsCache.add(new GroupData().withName(name).withId(id));
        }
        return new Groups(groupsCache);
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroup();
        groupsCache = null;
        returnToGroupPage();
    }
}
