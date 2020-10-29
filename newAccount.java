import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class newAccount {
    WebDriver driver;
    String email;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void createAcoount() throws InterruptedException {
        driver .navigate().to("http://automationpractice.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        driver.findElement(By.id("email_create")).sendKeys("e.wodniok@gmail.com");

        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        driver.findElement(By.id("id_gender2")).isSelected();
        driver.findElement(By.id("customer_firstname")).sendKeys("Ewelina");
        driver.findElement(By.id("customer_lastname")).sendKeys("W");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("passwd")).sendKeys("asdasd1");
        driver.findElement(By.id("days")).click();
        driver.findElement(By.xpath("//*[@id=\"days\"]/option[5]")).click();








    }
}
