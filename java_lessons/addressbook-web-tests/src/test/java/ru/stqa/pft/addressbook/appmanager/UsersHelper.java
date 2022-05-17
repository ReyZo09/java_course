package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class UsersHelper extends HelperBase{
    public UsersHelper(WebDriver driver) {
        super(driver);
    }

    public void fillFirstName(String firstName) {
        type(By.name("firstname"), firstName);
    }
    public void fillMiddleName(String middleName) {
        type(By.name("middlename"), middleName);
    }
    public void fillLastName(String lastName) {
        type(By.name("lastname"), lastName);
    }
    public void fillAddress(String address) {
        type(By.name("address"), address);
    }
    public void fillBirthDay(int day) {
        selectMenuByIndex(By.name("bday"), day + 1);
    }
    public void fillBirthMonth(String month) {
        int monthIndex = MonthIntoIndex(month);
        selectMenuByIndex(By.name("bmonth"), monthIndex);
    }
    public void fillBirthYear(String year) {
        type(By.name("byear"), year);
    }
    public void fillEMail(String email) {
        type(By.name("email"), email);
    }
    public void submitUserCreation() {
        clickElement(By.name("submit"));
    }

    public void selectUser() {
        clickElement(By.name("selected[]"));
    }
    public void submitUserDeletion() {
        clickElement(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }
    public void initUserModification() {
        clickElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a"));
    }
    public void submitUserModification() {
        clickElement(By.name("update"));
    }
    public void fillGroupField(String text) {
        if (isElementPresent(By.name("new_group"))) {
            selectMenuByText(By.name("new_group"), text);
        }
    }

    public void createUser() {
        fillFirstName("Test1");
        fillMiddleName("Testovich1");
        fillLastName("Testov1");
        fillAddress("City, street, building 1, apt. 1");
        fillEMail("test@test.test");
        fillBirthDay(9);
        fillBirthMonth("February");
        fillBirthYear("1990");
        fillGroupField("test1");
        submitUserCreation();
    }

    public boolean isThereAUser() {
        return isElementPresent(By.name("selected[]"));
    }
}
