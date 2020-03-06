package SelenCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CMS_StaffProfile {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
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
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("src/test/java/Folder/Config");
        prop.load(ip);

        driver.get(prop.getProperty("GETURLFORSTAFF"));


        WebDriverWait wait = new WebDriverWait(driver, 30);

        // Feed credentials and login

        driver.findElement(By.xpath("//input[@id='txtUserId']")).clear();

        WebElement login = driver.findElement(By.xpath("//input[@id='txtUserId']"));
        //Config file will be added later
        login.sendKeys(prop.getProperty("CAUSER"));


        driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();

        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(prop.getProperty("PWD"));

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Print the current page title

        System.out.println(driver.getTitle());

//span[@class='nav-label'][contains(text(),'Registration')]
        driver.findElement(By.xpath("//span[@class='nav-label'][contains(text(),'Registration')]")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Staff Profile')]")).click();
        driver.findElement(By.xpath("//img[@id='exportXLS']")).click();

        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
