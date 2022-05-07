package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
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
            String existingText = element.getAttribute("value");
            if (!text.equals(existingText)) {
                element.clear();
                element.sendKeys(text);
            }

        }
    }
    protected void selectMenuByIndex(By locator, int select) {
        Select selects = new Select(driver.findElement(locator));
        selects.selectByIndex(select);
    }
    protected void selectMenuByText(By locator, String text) {
        Select selects = new Select(driver.findElement(locator));
        selects.selectByVisibleText(text);
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
    private boolean isAlertPresent() {
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

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return  false;
        }
    }
}
