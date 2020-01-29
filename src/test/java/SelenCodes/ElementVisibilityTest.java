package SelenCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\chromedriver_win32\\chromedriver.exe"));
        WebDriver driver = new ChromeDriver();
        driver.get("https://register.freecrm.com/register/");
        System.out.println("Title of the website page is:" + driver.getTitle());

        // 1.isDisplayed
        boolean a = driver.findElement(By.xpath("//button[@name='action']")).isDisplayed(); // for signup button
        System.out.println(a);// true

        // 2.isEnabled
        boolean b = driver.findElement(By.xpath("//button[@name='action']")).isEnabled();
        System.out.println(b);// true

        // select checkbox


        // 3. is Selected
        boolean c = driver.findElement(By.xpath("//input[@name='terms']")).isSelected();
        System.out.println(c);// false

        driver.findElement(By.xpath("//input[@name='terms']")).click();

        boolean c1 = driver.findElement(By.xpath("//input[@name='terms']")).isSelected();
        System.out.println(c1);// true


        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("vijethkulal47@gmail.com");
        WebElement country = driver.findElement(By.xpath("//input[@class='search']"));

        driver.close();
        driver.quit();

    }

}
