package SelenCodes;

import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotConcept {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\drivers\\chromedriver.exe"));
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        File fil = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(fil, new File("C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\google.png"));

    }

}
 