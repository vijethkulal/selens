package SelenCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropDown {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.get("http://www.half.ebay.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("register")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("firstname")).sendKeys("Kulal");
        driver.findElement(By.name("lastname")).sendKeys("vijeth");
        driver.findElement(By.name("email")).sendKeys("vijethkulal47@gmail.com");
        driver.findElement(By.name("PASSWORD")).sendKeys("Newdress47");
        driver.findElement(By.xpath("//*[@id='ppaFormSbtBtn']")).click();
        driver.findElement(By.className("btn btn--primary")).click();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//div[@class='geetest_radar_tip']")).click();
        driver.close();
        driver.quit();

    }

}
