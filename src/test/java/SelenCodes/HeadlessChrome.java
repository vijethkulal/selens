package SelenCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HeadlessChrome {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Automation starts
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("headless");
        WebDriver drive = new ChromeDriver(options);
        drive.get("http://www.freecrm.com");
//		 drive.manage().deleteAllCookies();
//		 drive.manage().window().maximize();
        drive.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        drive.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String title = drive.getTitle();
        System.out.println("Title of the page is " + title);

        drive.findElement(By.name("username")).sendKeys("naveenk");
        drive.findElement(By.name("password")).sendKeys("test@123");
        drive.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();

        //Automation ends
        System.out.println("title of homepage is :" + drive.getTitle());
        //Validation points
        String expectedtitle = "CRMPRO";


        if (!expectedtitle.equalsIgnoreCase(title)) {
            System.out.println("Title do not match");
        } else {
            System.out.println("Title Match " + " " + title);
        }

        System.out.println(drive.getCurrentUrl());
        // System.out.println(drive.getPageSource());

        drive.close();
        drive.quit();
    }

}
//Whole script is called automation testing
