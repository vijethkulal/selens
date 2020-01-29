package SelenCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

    public static void Clickon(WebDriver driver, WebElement locator, int timeout) {
        new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\chromedriver.exe"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        WebElement dynamicElement = (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
        dynamicElement.sendKeys("India");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);

        Clickon(driver, driver.findElement(By.xpath("//div[@class contains '%tf%']//input[@name='btnK']")), 20);


        driver.close();
        driver.quit();

    }

}
