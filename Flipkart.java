package Demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class flipcart {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe" );
		WebDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://www.flipkart.com/");
		WebElement searchbox=Driver.findElement(By.name("q"));
		searchbox.sendKeys("Samsung Tab S9");
		searchbox.submit();
		Driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)")).click();
	String mainpage=Driver.getWindowHandle();
		System.out.println("Main page"+mainpage);
		Set<String> allpages=Driver.getWindowHandles();
		for(String Page:allpages) {
			if(!Page.equals(mainpage)) {
				Driver.switchTo().window(Page);
				break;
			}
		}
		System.out.println(Driver.getCurrentUrl());
		List<WebElement>products= Driver.findElements(By.className("_6NESgJ"));
		System.out.println(products.size());
		for(WebElement Product:products) {
			System.out.println(Product.getText());
		}
	} 	
}
