package gopal;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Panchami S Kamath\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();          //hit url on browser
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
		 //1
	     driver.findElement(By.linkText("Hovers")).click();
	     WebElement ele = driver.findElement(By.className("figure"));
	     Actions a = new Actions(driver);
	     a.moveToElement(ele).build().perform();
	     String text1 = driver.findElement(By.className("figcaption")).getText();
	     System.out.println(text1);
	     Thread.sleep(2000);
	     driver.get("http://the-internet.herokuapp.com/");
	     Thread.sleep(2000);
	     
	     //2
	     driver.findElement(By.linkText("Checkboxes")).click();
	     driver.findElements(By.cssSelector("input")).get(1).click();
	     Thread.sleep(4000);
	     driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	     Thread.sleep(1000);
	     int size1 = driver.findElements(By.cssSelector("input")).size();
	     for(int i=0;i<size1;i++)
	     {
	    	 driver.findElements(By.cssSelector("input")).get(i).click();
	     }
	     Thread.sleep(4000);
	     driver.get("http://the-internet.herokuapp.com/");
	     Thread.sleep(4000);
	     
	     
	     //3
	     driver.findElement(By.linkText("Inputs")).click();
	     driver.findElement(By.cssSelector("input")).sendKeys("1234");
	     Thread.sleep(4000);
	     driver.get("http://the-internet.herokuapp.com/");
	     Thread.sleep(4000);
		
		 //4
		driver.findElement(By.linkText("Dropdown")).click();
		driver.findElement(By.id("dropdown")).click();
		driver.findElement(By.id("dropdown")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("dropdown")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("dropdown")).click();
		Thread.sleep(4000);
	     driver.get("http://the-internet.herokuapp.com/");
	     Thread.sleep(4000);
		
		//5
		driver.findElement(By.linkText("File Upload")).click();
		Thread.sleep(4000);
		WebElement file = driver.findElement(By.id("file-upload"));
		file.sendKeys("C:\\Users\\Panchami S Kamath\\new.txt");
		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(1000);
		boolean msg = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).isDisplayed();
		if(msg)
		{
			System.out.println("Hurray!Msg is Displayed");
		}
		Thread.sleep(4000);
	    driver.get("http://the-internet.herokuapp.com/");
	    Thread.sleep(4000);
	    
	    //6
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		//int size6 =driver.findElement(By.id("table1")).findElements(By.cssSelector("tr")).size();
		int size6  = driver.findElements(By.xpath("//table[@id=\"table1\"]  //tr[4] //td")).size();
		for(int i=0;i<size6;i++)
		{
			String text6 =driver.findElements(By.xpath("//table[@id=\"table1\"]  //tr[4] //td")).get(i).getText();
			if(text6.equalsIgnoreCase("Tim"))
			{
				 for(int k=i+1;k<=i+3;k=k+2)
				 {
					 String ema =driver.findElements(By.xpath("//table[@id=\"table1\"]  //tr[4] //td")).get(k).getText();
					 System.out.println(ema);
					 
				 }
				 break;
			}
		}
		Thread.sleep(4000);
	    driver.get("http://the-internet.herokuapp.com/");
	    Thread.sleep(4000);
		
		//7
	    driver.findElement(By.linkText("Key Presses")).click();
		driver.findElement(By.id("target")).sendKeys(Keys.ALT);
		String text =driver.findElement(By.id("result")).getText();
		System.out.println(text);
		Thread.sleep(4000);
	    driver.get("http://the-internet.herokuapp.com/");
	    Thread.sleep(4000);
		
		//8
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		String title = driver.getTitle();
		System.out.println(title);
		driver.switchTo().window(parent);
		Thread.sleep(4000);
	    driver.get("http://the-internet.herokuapp.com/");
	    Thread.sleep(4000);
		
		
		//9
		driver.findElement(By.linkText("Context Menu")).click();
		WebElement square =driver.findElement(By.id("hot-spot"));
		Actions act = new Actions(driver);
		act.moveToElement(square).contextClick().build().perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(4000);
	    driver.get("http://the-internet.herokuapp.com/");
	    Thread.sleep(4000);
	    
	     
	     /*Set<String> tabs = driver.getWindowHandles();
		 Iterator<String> it = tabs.iterator();
		 String parent = it.next();
		 driver.switchTo().window(parent);*/
	     

	}

}
