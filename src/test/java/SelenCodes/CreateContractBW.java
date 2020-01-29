package SelenCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContractBW {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\chromedriver.exe"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://10.231.178.183:8282/PASS_Web_WAS7/dashboard/");
        driver.findElement(By.name("j_username")).sendKeys("inpabwadm1");
        driver.findElement(By.xpath("//button[@id='btnLogin']")).click();


        driver.close();
        driver.quit();

    }

}
