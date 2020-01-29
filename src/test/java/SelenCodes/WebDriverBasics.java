package SelenCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.gmail.com");
        String a = driver.getTitle();
        System.out.println("Title of the page is :" + a);

        if (a.equalsIgnoreCase("Gmail")) {
            System.out.println("Correct:Title Match");

        } else {
            System.out.println("Worng:Title Do not match");
        }

        WebElement ang = driver.findElement(By.id("identifierId"));
        ang.sendKeys("vijethkulal@gmail.com");
        WebElement pwd = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
        pwd.click();
        WebElement pwds = driver.findElement(By.name("password"));
        pwds.sendKeys("Newdress@47");

        WebElement pwdss = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
        pwdss.click();
        System.out.println(driver.getTitle());

        driver.close();
        driver.quit();

    }
}