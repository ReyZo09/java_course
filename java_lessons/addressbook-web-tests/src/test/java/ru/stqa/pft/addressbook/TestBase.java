package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    ChromeDriver driver;

    public static boolean isAlertPresent(ChromeDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("http://localhost/addressbook/");
        login("admin","secret");    //логин и пароль для входа в систему
    }

    private void login(String username, String password) {
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

    protected void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    protected void sumbitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
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

    protected void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    protected void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    protected void deleteSelectedGroup() {
        driver.findElement(By.name("delete")).click();
    }

    protected void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }
}
