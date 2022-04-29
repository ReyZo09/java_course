package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.time.Duration;

public class ApplicationManager {
    ChromeDriver driver;

    public static boolean isAlertPresent(ChromeDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("http://localhost/addressbook/");
        login("admin","secret");    //логин и пароль для входа в систему
    }

    public void login(String username, String password) {
        WebElement loginField = driver.findElement(By.name("user"));
        WebElement passField = driver.findElement(By.name("pass"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(username);
        passField.click();
        passField.clear();
        passField.sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/input[3]")).click();
    }

    public void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void sumbitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        WebElement groupName = driver.findElement(By.name("group_name"));
        WebElement groupHeader = driver.findElement(By.name("group_header"));
        WebElement groupFooter = driver.findElement(By.name("group_footer"));
        groupName.click();
        groupName.clear();
        groupName.sendKeys(groupData.name());
        groupHeader.click();
        groupHeader.clear();
        groupHeader.sendKeys(groupData.header());
        groupFooter.click();
        groupFooter.clear();
        groupFooter.sendKeys(groupData.footer());
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        driver.quit();
    }

    public void deleteSelectedGroup() {
        driver.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }
}
