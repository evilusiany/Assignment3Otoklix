package Assignment3.otoklix;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;


public class AppTest {
    @Test
    public void assignmentTigaTest() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");
    
    String username = "standard_user";
    String password = "secret_sauce";
    String firstName = "Evi";
    String lastName = "Lusiany";
    String kodePos = "11460";
    
    try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    //Login
    driver.findElement(By.id("user-name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("login-button")).click();
    
    //add-to-cart a item from product list
    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    
    //Go to cart and check out the item
    driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
    driver.findElement(By.name("checkout")).click();
    
    //Fill check-out information
    driver.findElement(By.id("first-name")).sendKeys(firstName);
    driver.findElement(By.id("last-name")).sendKeys(lastName);
    driver.findElement(By.id("postal-code")).sendKeys(kodePos);
    driver.findElement(By.name("continue")).click();
    
    //Overview and finish the order
    boolean productName = driver.findElement(By.cssSelector("div.inventory_item_name"))
    	      .isDisplayed();
    System.out.println("The product in overview page is: " + productName);
    driver.findElement(By.name("finish")).click();
    
    //See Thank you page order
    boolean thankYouPage = driver.findElement(By.id("checkout_complete_container"))
  	      .isDisplayed();
    System.out.println("The thank you page is appear: " + thankYouPage);
    
    try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    driver.quit();
}

}
