import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumTest2 {

    public static <FirefoxDriver> void main(String[] args){
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("standard_user");

        WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");

        WebElement login=driver.findElement(By.xpath("//input[@name='login-button']"));
        login.click();

        Assert.isTrue(driver
                    .findElement(By.xpath("//div[@class='app_logo']"))
                    .isDisplayed(),"app_logo not found");
    }
}
