package SelenCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackwardAndForwardSimulation {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\chromedriver.exe"));
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.navigate().to("http://www.yahoo.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();

    }

}
