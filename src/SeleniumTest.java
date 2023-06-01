import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumTest2 {

    public static <FirefoxDriver> void main(String[] args){
        WebDriver driver=new ChromeDriver();

        driver.get("https://demo.guru99.com/");
        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");

        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();
        try {
            Assert.isTrue(driver
                    .findElement(By.xpath("//h2[@style='color:#800080;font-size:28px;font-weight:700;']"))
                    .isDisplayed(), "Element //h2[@style='color:#800080;font-size:28px;font-weight:700; not found");
        }catch(Exception e){
            System.out.println("Assert Error");
        }
    }
}
