package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;

public class GroupCreationTest {
    ChromeDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("http://localhost/addressbook/");
        WebElement loginField = driver.findElement(By.name("user"));
        WebElement passField = driver.findElement(By.name("pass"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys("admin");
        passField.click();
        passField.clear();
        passField.sendKeys("secret");
        driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/input[3]")).click();
    }
    @Test
    public void testGroupCreation() {
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys("test1");
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys("test2");
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys("test3");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }
    @AfterMethod
    public void tearDown() {
        //driver.close();
        driver.quit();
    }

    public static boolean isAlertPresent(ChromeDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
