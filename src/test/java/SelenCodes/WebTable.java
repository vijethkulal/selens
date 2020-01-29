package SelenCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebTable {

    public static void main(String args[]) {

        // TODO Auto-generated method stub
                System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\drivers\\chromedriver.exe"));
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/vkulal/Desktop/webtable.html");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        int rowsize=driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
        int colsize=driver.findElements(By.xpath("html/body/table/tbody/tr/td")).size();

for(int i=1;i<=rowsize;i++)
{
    for(int j=1;i<=colsize;i++)
    {
        String text=driver.findElement(By.xpath("html/body/table/tbody/tr[i]/td[j]")).getText();
        System.out.println(text);
    }
}

    }
}
