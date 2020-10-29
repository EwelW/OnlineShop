import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Registration {
    WebDriver driver;
            String email;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    @Test
    public void signButton() throws InterruptedException {
        driver.navigate().to("http://automationpractice.com");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
        driver.quit();
    }
    @Test
    public void noData() throws InterruptedException {
        driver .navigate().to("http://automationpractice.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText().equals("Invalid email address."));

    }
    @Test
    public void wrongData() throws InterruptedException {
        driver .navigate().to("http://automationpractice.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        driver.findElement(By.id("email_create")).sendKeys("e.wodniok.gmail.com");

        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText().equals("Invalid email address."));

    }
    @Test
     void registerUsedEmail () throws InterruptedException {

        driver .navigate().to("http://automationpractice.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        driver.findElement(By.id("email_create")).sendKeys("e.wodniok@gmail.com");

        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();

        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText().equals("An account using this email address has already been registered. Please enter a valid password or request a new one."));

        driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a/i")).click();

    }
    @AfterTest
    public void quit(){
        driver.quit();
    }
}

