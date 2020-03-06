package SelenCodes;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class loginsample {
    //download chrome driver and give its path in set property
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        int h = 1;
        System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\Software\\driver\\chromedriver.exe"));

        // OPen browser and set default timeout values

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //UAT URL
        driver.get("http://101.99.81.153:8080/cms-web/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, 40);

        // Feed credentials and login

        driver.findElement(By.xpath("//input[@id='txtUserId']")).clear();

        WebElement login = driver.findElement(By.xpath("//input[@id='txtUserId']"));
        //Config file will be added later
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
//Search Active contracts
        sr.selectByVisibleText("Active");

        driver.findElement(By.id("csSrcBtn")).click();

        // Sleep for a while

        Thread.sleep(3000);

        // Double click on "End Date" table header
//  Sorting on latest
        Actions actions = new Actions(driver);

        WebElement locator = driver.findElement(By.xpath("//th[contains(text(),'End Date')]"));

        actions.doubleClick(locator).perform();

        actions.build();

        // Sleep for a while

        Thread.sleep(3000);

        // Click on Details link of the first record

//Click on active details in sequence
//Popup already amended need to be handled
//Click on all the details should be handled currently all details in a page has been automated
//File stream need to be introduced to feed the data into the file
//Design of Page Object model need be to introduced to overcome and handle staleelement and other exception


        List contractno = driver.findElements(By.xpath("//td[11]//a[1]"));

        System.out.println("Number of Contracts in a page" + contractno.size());
        while (h <= contractno.size()) {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[" + h + "]//td[11]//a[1]")));

            WebElement details = driver.findElement(By.xpath("//tr[" + h + "]//td[11]//a[1]"));
            Actions actions3 = new Actions(driver);


            actions3.doubleClick(details).perform();

            actions.build().perform();

            // Sleep for a while

            Thread.sleep(3000);

            String Parent = driver.getWindowHandle();
            Set<String> child = driver.getWindowHandles();
            Iterator it = child.iterator();
            while (it.hasNext()) {
                it.next();
            }

            Thread.sleep(3000);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            // Switch to Shift tab
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Shift')]")));
            driver.findElement(By.xpath("//a[contains(text(),'Shift')]")).click();
            // Click on Amendment button
            try {
                driver.findElement(By.id("btnAmend")).click();
            } catch (UnhandledAlertException e) {
                driver.switchTo().alert().dismiss();
                continue;
            }
            // Read the table header column count and print

            List<WebElement> col = driver.findElements(By.xpath("//table[@id='acsTableShift']//thead//tr//th"));

            System.out.println("Headers in table are below:");

            System.out.println("Total headers found: " + col.size());

            for (WebElement header : col) {

                System.out.println(header.getText());

            }

            List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='acsTableShift']//tbody//tr"));

            System.out.println("Row count: " + rowCount.size());
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
int attempts=0;
while(attempts < 2) {

    try {
        for (int i = 1; i < rowCount.size(); i++) {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='acsTableShift']//tbody//tr[" + i + "]//td")));
            List<WebElement> columnCount = driver.findElements(By.xpath("//table[@id='acsTableShift']//tbody//tr[" + i + "]//td"));

//       System.out.println("Column count: " + columnCount.size());

            for (int j = 1; j < columnCount.size(); j++) {

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='acsShiftJcSel-" + j + "']")));
                WebElement jobClassElement = driver.findElement(By.xpath("//select[@id='acsShiftJcSel-" + j + "']"));

                Select JobClass = new Select(jobClassElement);

                if (JobClass.getFirstSelectedOption().getText() == null) {
                    JobClass.selectByIndex(1);
                    break;
                }
                System.out.println("Job Classification: " + JobClass.getFirstSelectedOption().getText());

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='acsShiftSel-" + j + "']")));
                WebElement shiftElement = driver.findElement(By.xpath("//select[@id='acsShiftSel-" + j + "']"));

                Select shift = new Select(shiftElement);
                if (shift.getFirstSelectedOption().getText() == null) {
                    shift.selectByIndex(1);
                    break;
                }

                System.out.println("JobShift: " + shift.getFirstSelectedOption().getText());


                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='acsStartTime-" + j + "']")));
                WebElement startTimeElement = driver.findElement(By.xpath("//input[@id='acsStartTime-" + j + "']"));

                System.out.println("Start Time: " + startTimeElement.getAttribute("value"));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='acsEndTime-" + j + "']")));
                WebElement endTimeElement = driver.findElement(By.xpath("//input[@id='acsEndTime-" + j + "']"));

                System.out.println("End Time: " + endTimeElement.getAttribute("value"));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='acsTotWrkHrs-" + j + "']")));
                WebElement workHoursElement = driver.findElement(By.xpath("//input[@id='acsTotWrkHrs-" + j + "']"));

                System.out.println("Work Hours: " + workHoursElement.getAttribute("value"));

                WebElement ppElement = driver.findElement(By.xpath("//select[@id='acsShiftOpPerSel-" + j + "']"));

                Select pp = new Select(ppElement);

                System.out.println("Operational Period: " + pp.getFirstSelectedOption().getText());
            }
            Thread.sleep(3000);

        }

    } catch (StaleElementReferenceException ee) {
        attempts++;
    }
    catch (NoSuchElementException ss) {
        attempts++;
    }
}
            try {

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'×')]")));
                WebElement cancel = driver.findElement(By.xpath("//span[contains(text(),'×')]"));
                cancel.click();
            } catch (UnhandledAlertException e) {
                System.out.println("pakkad");
            }
            Thread.sleep(2000);

            System.out.println(driver.getCurrentUrl());
            driver.switchTo().window(Parent);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }
        driver.close();
        driver.quit();
        h++;
    }

}