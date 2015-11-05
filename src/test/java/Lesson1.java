import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class Lesson1 {

    private static WebDriver driver = null;

@Test

    public void lesson1() throws InterruptedException {



        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost/wordpress/wp-login.php");

     //   driver.navigate().to(ApplicationSettings.baseUrl);
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("ololo");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("ololopass");
        driver.findElement(By.id("wp-submit")).click();

        Thread.sleep(3000);

        driver.close();
        driver.quit();

    }
}
