package SelenCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginSample1 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\Software\\chromedriver.exe"));

        // OPen browser and set default timeout values

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://101.99.81.153:8080/cms-web/auth/login");

        WebDriverWait wait = new WebDriverWait(driver,30);

        // Feed credentials and login

        driver.findElement(By.xpath("//input[@id='txtUserId']")).clear();

        WebElement login = driver.findElement(By.xpath("//input[@id='txtUserId']"));

        login.sendKeys("cwms_aa_020");

        driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();

        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("password");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Print the current page title

        System.out.println(driver.getTitle());

        // Navigate to Contractor setup and search for records with Active status

        driver.findElement(By.xpath("//span[contains(text(),'Contract Setup')]")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Contract Setup')]")).click();

        Select sr = new Select(driver.findElement(By.xpath("//select[@id='csSrcStatus']")));

        sr.selectByVisibleText("Active");

        driver.findElement(By.id("csSrcBtn")).click();

        // Sleep for a while

        Thread.sleep(3000);

        // Double click on "End Date" table header

        Actions actions = new Actions(driver);

        WebElement locator = driver.findElement(By.xpath("//th[contains(text(),'End Date')]"));

        actions.doubleClick(locator).perform();

        actions.build();

        // Sleep for a while

        Thread.sleep(3000);

        // Click on Details link of the first record

        driver.findElement(By.xpath("//tr[1]//td[11]//a[1]")).click();

        // Sleep for a while

        Thread.sleep(3000);

        // Switch to Shift tab

        driver.findElement(By.xpath("//a[contains(text(),'Shift')]")).click();

        // Click on Amendment button

        driver.findElement(By.id("btnAmend")).click();

        // Read the table header column count and print

        List<WebElement> col = driver.findElements(By.xpath("//table[@id='acsTableShift']//thead//tr//th"));

        System.out.println("Headers in table are below:");

        System.out.println("Total headers found: " + col.size());

        for (WebElement header : col) {

            System.out.println(header.getText());

        }

        List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='acsTableShift']//tbody//tr"));

        System.out.println("Row count: " + rowCount.size());

        for (int i = 1; i < rowCount.size(); i++) {

            List<WebElement> columnCount = driver.findElements(By.xpath("//table[@id='acsTableShift']//tbody//tr["+i+"]//td"));

//			System.out.println("Column count: " + columnCount.size());

            for (int j = 1; j < columnCount.size(); j++) {

                WebElement jobClassElement = driver.findElement(By.xpath("//select[@id='acsShiftJcSel-"+j+"']"));

                Select JobClass = new Select(jobClassElement);

                System.out.println("Job Classification: " + JobClass.getFirstSelectedOption().getText());

                WebElement shiftElement = driver.findElement(By.xpath("//select[@id='acsShiftSel-"+j+"']"));

                Select shift = new Select(shiftElement);

                System.out.println("JobShift: " + shift.getFirstSelectedOption().getText());

                WebElement startTimeElement = driver.findElement(By.xpath("//input[@id='acsStartTime-"+j+"']"));

                System.out.println("Start Time: " +startTimeElement.getAttribute("value"));

                WebElement endTimeElement = driver.findElement(By.xpath("//input[@id='acsEndTime-"+j+"']"));

                System.out.println("End Time: " +endTimeElement.getAttribute("value"));

                WebElement workHoursElement =  driver.findElement(By.xpath("//input[@id='acsTotWrkHrs-"+j+"']"));

                System.out.println("Work Hours: " +workHoursElement.getAttribute("value"));

                WebElement ppElement = driver.findElement(By.xpath("//select[@id='acsShiftOpPerSel-"+j+"']"));

                Select pp = new Select(ppElement);

                System.out.println("Operational Period: " + pp.getFirstSelectedOption().getText());
            }
            Thread.sleep(3000);
        }

        driver.quit();
    }

}