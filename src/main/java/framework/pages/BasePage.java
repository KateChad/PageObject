package framework.pages;

import framework.managers.DriverManager;
import framework.managers.PageManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),10,1000);
    protected PageManager pageManager = PageManager.getInstance();
    public BasePage(){
        PageFactory.initElements(driverManager.getDriver(),this);
    }

    protected WebElement waitUntilElementToBeClicable(WebElement element){
      return wait.until(ExpectedConditions.elementToBeClickable(element));
   }

   protected WebElement waitUntilElementToBeVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
   }
}
