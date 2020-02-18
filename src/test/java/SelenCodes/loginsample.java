package SelenCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class loginsample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                ("C:\\Users\\vkulal\\Downloads\\Software\\chromedriver.exe"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://101.99.81.153:8080/cms-web/auth/login");

        driver.findElement(By.xpath("//input[@id='txtUserId']")).clear();
        WebElement login = driver.findElement(By.xpath("//input[@id='txtUserId']"));
        login.sendKeys("cwms_aa_020");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//span[contains(text(),'Contract Setup')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Contract Setup')]")).click();
        Select sr = new Select(driver.findElement(By.xpath("//select[@id='csSrcStatus']")));
        sr.selectByVisibleText("Active");
        driver.findElement(By.id("csSrcBtn")).click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        WebElement locator = driver.findElement(By.xpath("//th[contains(text(),'End Date')]"));

        //WebElement elementLocator = driver.findElement(By.id("ID"));
        actions.doubleClick(locator).perform();
        actions.build();

        Thread.sleep(3000);
        ////th[@class='sorting_desc']
        driver.findElement(By.xpath("//tr[1]//td[11]//a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Shift')]")).click();
        driver.findElement(By.id("btnAmend")).click();

        List<WebElement> col = driver.findElements(By.xpath("//table[@id='acsTableShift']//thead//tr//th"));
        System.out.println("Headers in table are below:");
        System.out.println("Total headers found: " + col.size());
        for (WebElement header : col) {
            System.out.println(header.getText());
        }

        WebElement mytable = driver.findElement(By.xpath("//table[@id='acsTableShift']//tbody"));

        List<WebElement> row = driver.findElements(By.xpath("//table[@id='acsTableShift']//tbody//tr"));
        System.out.println("rows in table are below:");
        System.out.println("Total rows found: " + row.size());
        List<WebElement> data = driver.findElements(By.xpath("//table[@id='acsTableShift']//tbody//tr//td"));

        for (int i = 1; i < row.size(); i++) {

            for (int j = 1; j < data.size(); j++) {
//                WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox' and @class='acsShiftCb'])[i]"));
//                boolean check = checkbox.isSelected();
//                System.out.println(check);

                Select JobClass = new Select(driver.findElement(By.xpath("//select[@id='acsShiftJcSel-"+ j +"']")));
                System.out.println("Job Classification" + JobClass.getFirstSelectedOption());

                Select shift = new Select(driver.findElement(By.xpath("//select[@id='acsShiftSel-[" + j + "]")));
                System.out.println("JobShift" + shift.getFirstSelectedOption());

                System.out.println("Start Time" + driver.findElement(By.xpath("//input[@id='acsStartTime-[\" + j + \"]")).getCssValue("value"));
                System.out.println("End Time" + driver.findElement(By.xpath("//input[@id='acsEndTime-[\" + j + \"]")).getAttribute("value"));
                System.out.println("Work Hours" + driver.findElement(By.xpath("//input[@id='acsTotWrkHrs-[\" + j + \"]")).getAttribute("value"));
                Select pp = new Select(driver.findElement(By.xpath("//select[@id='acsShiftOpPerSel-[\" + j + \"]")));
                System.out.println("Operational Period" + pp.getFirstSelectedOption());


            }


        }

//        for (WebElement rows : row) {
//            System.out.println(rows.getText());
//        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.close();
        driver.quit();
    }

}
