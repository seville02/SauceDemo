package Introduction;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Scanner;

public class BasicTest {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				driver.get("https://www.saucedemo.com/");
				driver.findElement(By.cssSelector(".input_error ")).sendKeys("standard_user");
				driver.findElement(By.xpath("//div/input[@placeholder='Password']")).sendKeys("secret_sauce");
				driver.findElement(By.className("submit-button")).click();
				
				driver.findElement(By.cssSelector("[class='header_secondary_container'] span:nth-child(1).select_container")).click();
				driver.findElement(By.xpath("//option[@value='hilo']")).click();
				System.out.println(driver.findElements(By.className("inventory_list")).size());
				
				//driver.findElement(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item'][1]"));
				//driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
				
				List<WebElement> buttons = driver.findElements(By.className("btn"));
				String text = driver.findElement(By.cssSelector("div[class='inventory_list'] div:nth-child(1) div:nth-child(2) div:nth-child(2) div:nth-child(1)")).getText();
				System.out.println(text);
				/* To select all buttons
				List<WebElement> buttons = driver.findElements(By.className("btn"));
				for (WebElement button : buttons) {
				    button.click();
				}
				*/
				
				// To select first 3 buttons.
				int counter = 1;
				for (WebElement button : buttons) {
				    if (counter > 4) {
				        break;
				    }
				    button.click(); // Click on the button
				    counter++;
				}
				
				driver.findElement(By.className("shopping_cart_link")).click();
				String first_item = driver.findElement(By.cssSelector("div[class='cart_list'] div:nth-child(3) div:nth-child(2) div:nth-child(1)")).getText();
				System.out.println(first_item);
				Assert.assertEquals(first_item,"Sauce Labs Fleece Jacket");
				
				driver.findElement(By.className("checkout_button")).click();
				setNames(driver);
				driver.findElement(By.id("continue")).click();
				
				String payment = driver.findElement(By.className("summary_info_label")).getText();
				String paymentdet= driver.findElement(By.xpath("//div[@class='summary_info_label'][1]/following-sibling::div[1]")).getText();
				
				String shipping = driver.findElement(By.className("summary_value_label")).getText();
					
				System.out.println("******* Your " +payment+ " is " +paymentdet+ " from " +shipping+ " *******.");	
				String FinalPrice = driver.findElement(By.className("summary_total_label")).getText();
				String[] total = FinalPrice.split("Total:");
				String finaltotal = total[1].trim();
				System.out.println("Your Final Price will be "+finaltotal);
				
				/* Scanner myObj = new Scanner(System.in);
				System.out.println("Press Y to confirm");  
				String userinput = myObj.nextLine(); 
				System.out.println(userinput);
				 if (userinput.equals("Y")) {   
			            System.out.println("next");
			        } else {
			            System.out.println("fail");
			            
			        }
			        */
				driver.findElement(By.xpath("//*[contains(text(),'Finish')]")).click();
				String success= driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
				System.out.println(success);
				driver.findElement(By.id("back-to-products")).click();
				Thread.sleep(2000);
				driver.close();
	}
	
	
	public static WebDriver setNames(WebDriver driver) {
	    WebElement firstNameElement = driver.findElement(By.xpath("//div/input[@placeholder='First Name']"));
	    firstNameElement.sendKeys("Seville");
	    
	    WebElement lastNameElement = driver.findElement(By.xpath("//div/input[@placeholder='Last Name']"));
	    lastNameElement.sendKeys("Diniz");
	    
	    WebElement zipcode = driver.findElement(By.xpath("//div/input[@placeholder='Zip/Postal Code']"));
	    zipcode.sendKeys("K32N097");
	    
	    return driver;
		
		
	}	
}
		

