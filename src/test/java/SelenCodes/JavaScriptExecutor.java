package SelenCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\chromedriver.exe"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.zoho.com/in/crm/");

        driver.findElement(By.linkText("LOGIN")).click();
        driver.findElement(By.id("login_id")).sendKeys("vijethkulal@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys("Newdress@47");
        WebElement signin = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        flash(signin, driver);

        driver.close();
        driver.quit();

    }

    public static void flash(WebElement element, WebDriver driver) {
        // JavascriptExecutor js = ((JavascriptExecutor) driver);

        String bgcolor = element.getCssValue("background-color");

        for (int i = 0; i < 100; i++) {
            changeColor("rgb(0,200,0)", element, driver);
            changeColor(bgcolor, element, driver);
        }
    }

    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.background-color='" + color + "'", element);

    }

}
