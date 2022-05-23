package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;
    FirefoxDriver ffDriver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private UsersHelper usersHelper;
    private Browser browser;

    public ApplicationManager(Browser browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equals(Browser.CHROME)) {
            System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        usersHelper = new UsersHelper(driver);
        sessionHelper.login("admin","secret");    //логин и пароль для входа в систему
    }



    public void stop() {
        driver.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
    public UsersHelper getUsersHelper() { return usersHelper; }
}
