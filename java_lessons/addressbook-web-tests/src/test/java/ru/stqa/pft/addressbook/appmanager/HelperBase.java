package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        clickElement(locator);
        if (text != null) {
            element.clear();
            element.sendKeys(text);
        }
    }
    protected void selectMenu(By locator, int select) {
        Select selects = new Select(driver.findElement(locator));
        selects.selectByIndex(select);
    }
    protected int MonthIntoIndex (String month) {
        String [] months = {"-", "January" , "February" , "March" , "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December"};
        int i;
        for (i = 0; i <= months.length; i++) {
            if (months[i] == month) break;
        }
        return i;
    }
    public void alertAccept() {
        driver.switchTo().alert().accept();
    }
    public void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    public void alertCheck() {
        if (!isAlertPresent()) {
            System.out.println("Alert window not found");
        }
    }
}
