package SelenCodes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropFile {

    static WebDriver driver;

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();

        FileInputStream ip = new FileInputStream(
                "C:\\Users\\vkulal\\eclipse-workspace\\SeleniumCode\\config.properties");

        prop.load(ip);

        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));

        String url = prop.getProperty("URL");
        System.out.println(url);

        String browser = prop.getProperty("browser");
        System.out.println(browser);

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();

        }
        driver.get(url);

    }

}
