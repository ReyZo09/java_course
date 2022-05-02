package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(ChromeDriver driver) {

        super(driver);
    }
    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        clickElement(By.xpath("//*[@id=\"LoginForm\"]/input[3]"));
    }
}
