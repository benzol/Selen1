import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


public class Lesson2 {

    private static WebDriver driver = null;

    @Test

    public void lesson2() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//********************LOGIN****************************
        driver.get("http://localhost/wordpress/wp-login.php");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("ololo");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("ololopass");
        driver.findElement(By.id("wp-submit")).click();

//*********************NEW POST*****************************
       Actions action = new Actions(driver);
        WebElement postMenu = driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]"));
       action.moveToElement(postMenu).build().perform();
        driver.findElement(By.xpath("//*[@href='post-new.php']")).click();

        driver.findElement(By.xpath(".//*[@id='title']")).sendKeys("Post created on " + " " + LocalDateTime.now());

        driver.switchTo().frame("content_ifr");
        WebElement body = driver.findElement(By.xpath("//body"));
        body.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].innerHTML = '" + "Post body. Imagine cute kittens." + "'", body);
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath(".//*[@id='publish']")).click();

//***************************CHECK IF EXISTS************************************

        driver.findElement(By.xpath(".//*[@id='message']/p/a")).click();
        driver.findElement(By.xpath("//article[contains(@id,'post')]"));
    }



}
