package SelenCodes;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
public class Download_Roster_ByMonthly {
    static WebDriver driver;
    WebDriverWait wait;



    public static void main(String[] args) throws InterruptedException, IOException {


        boolean allClear=true;


        if (allClear == true) {
            System.setProperty("webdriver.chrome.driver",
                    ("C:\\Users\\vkulal\\Downloads\\Software\\driver\\chromedriver.exe"));

            String downloadFilePath = "C:\\Users\\vkulal\\Downloads\\CMS\\";

            HashMap<String, Object> chromePref = new HashMap<String, Object>();

            chromePref.put("profile.default_content_settings.popups", 0);

            chromePref.put("download.default_directory", downloadFilePath);

            ChromeOptions options = new ChromeOptions();

            options.setExperimentalOption("prefs", chromePref);

            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            WebDriver driver = new ChromeDriver(cap);


            // driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().deleteAllCookies();



            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


            Properties prop = new Properties();
            FileInputStream ip = new FileInputStream("src/test/java/Folder/Config");
            prop.load(ip);

            driver.get(prop.getProperty("GETURL"));


            WebDriverWait wait = new WebDriverWait(driver, 30);

            // Feed credentials and login

            driver.findElement(By.xpath("//input[@id='txtUserId']")).clear();

            WebElement login = driver.findElement(By.xpath("//input[@id='txtUserId']"));
            //Config file will be added later
            login.sendKeys(prop.getProperty("CAUSER"));


            driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();

           // driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getProperty("PWD"));

           // int token = JOptionPane.showConfirmDialog(null, "", "Login", JOptionPane.OK_OPTION);            //System.out.println(token);
            driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getProperty("PWD"));

            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // Print the current page title

            System.out.println(driver.getTitle());
//1.Click on Duty Roster

            driver.findElement(By.xpath("//span[contains(text(),'Duty Roster')]")).click();
            driver.findElement(By.xpath("//a[contains(text(),'Upload/Download Duty Roster')]")).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement ele = driver.findElement(By.xpath("//select[@id='selectYear']"));
            js.executeScript("arguments[0].scrollIntoView();", ele);
            //  driver.findElement(By.xpath("//select[@id='selectYear']")).click();
            Select selyear = new Select(driver.findElement(By.xpath("//select[@id='selectYear']")));

            Select selmonth = new Select(driver.findElement(By.xpath("//select[@id='selectMonth']")));
            selyear.selectByValue(prop.getProperty("Year"));
            selmonth.selectByVisibleText(prop.getProperty("Month"));

            driver.findElement(By.xpath("//button[@id='downloadMonthlyButton']")).click();
            Thread.sleep(8000);
            System.out.println(driver.getCurrentUrl());
            driver.close();
            driver.quit();
        }
    }
}