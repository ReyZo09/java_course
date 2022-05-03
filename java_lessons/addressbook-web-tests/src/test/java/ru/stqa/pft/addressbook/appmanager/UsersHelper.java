package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsersHelper extends HelperBase{
    public UsersHelper(ChromeDriver driver) {
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
        selectMenu(By.name("bday"), day + 1);
    }
    public void fillBirthMonth(String month) {
        int monthIndex = MonthIntoIndex(month);
        selectMenu(By.name("bmonth"), monthIndex);
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
}
