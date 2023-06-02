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

        //Verify user can select the first product

        WebElement firstProduct=driver.findElement(By.xpath("//div[@class='inventory_item'][1]/div[2]/div/a/div"));
        firstProduct.click();

        String firstProductName=driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        String firstProductPrice=driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();

        Assert.isTrue(firstProductName.equals("Sauce Labs Fleece Jacket"),"Sauce Labs Fleece Jacket is not displayed!");
        Assert.isTrue(firstProductPrice.equals("$49.99"),"$49.99 is not found!");

        //Verify user can buy the product
        WebElement addToCartButton=driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-fleece-jacket']"));
        addToCartButton.click();

        WebElement shoppingCart=driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        shoppingCart.click();

        WebElement checkoutButton=driver.findElement(By.xpath("//button[contains(@class,'checkout_button')]"));
        checkoutButton.click();

        WebElement firstNameInput=driver.findElement(By.xpath("//input[@id='first-name']"));
        firstNameInput.sendKeys("Gabriella");

        WebElement lastNameInput=driver.findElement(By.xpath("//input[@id='last-name']"));
        lastNameInput.sendKeys("Siska");

        WebElement postalCodeInput=driver.findElement(By.xpath("//input[@id='postal-code']"));
        postalCodeInput.sendKeys("11440");

        WebElement continueButton=driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();


    }
}
