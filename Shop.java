import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Shop {
    WebDriver driver;
    String email;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    //przesuwanie kursora rozwijanie buttona
    @Test
    public void manualExpand()
    {

        driver.navigate().to("http://automationpractice.com");
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"))).build().perform();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a")).click();
        Assert.assertEquals(driver.getTitle(), "Casual Dresses - My Store");
    }
    @Test
    public void order(){
        driver.navigate().to("http://automationpractice.com");
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
        driver.findElement(By.id("layered_category_8")).isSelected();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")).click();

        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
        for (int i =1; i<3; i++)
        {
            driver.findElement(By.id("cart_quantity_up_1_1_0_0")).click();
        }

        System.out.println(driver.findElement(By.xpath("//*[@id=\"product_1_1_0_0\"]/td[2]/small[2]/a")).getText());
        System.out.println(driver.findElement(By.id("total_price")).getText());
    }
}
