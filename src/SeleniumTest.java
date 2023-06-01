import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumTest2 {

    public static <FirefoxDriver> void main(String[] args){
        WebDriver driver=new ChromeDriver();

        //Verify user can login
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

        WebElement productFilter=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        productFilter.click();

        //Verify user can filter product from highest price to lowest price
        WebElement optionHighPriceToLowPrice=driver.findElement(By.xpath("//option[@value='hilo']"));
        optionHighPriceToLowPrice.click();

        String highestProduct=driver.findElement(By.xpath("//div[@class='inventory_item'][1]/div[2]/div[2]/div")).getText();

        Assert.isTrue(highestProduct.equals("$49.99"),"At the top of the product is not the highest price");

    }
}
