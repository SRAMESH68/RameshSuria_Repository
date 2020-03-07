package SeleniumLearning;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/*
 * Author: Ramesh Suriaprakhash / Date: 07 Mar 2020
 * This code launches naukri.com
 * By default, it launches three other windows as well. First, it gets the title
 * of parent window naukri. Then it counts the number of windows available.
 * Then, using Iterator, it switches to each window based on ID generated using 
 * getWindowHandles and prints the title.
 *
 * Also, it switches to third window by index, prints the title,
 * and closes that window. Finally, it closes all the windows.
 * 
 */
public class Naukri_getWindowHandles {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", "E:\\Selenium Training\\software\\32 bit\\driver\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.get("www.naukri.com");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		Set<String> str=driver.getWindowHandles();
		System.out.println(str.size());
	/*	for(String str1 : str)
		{
			System.out.println(str1);
			
		} */
		Iterator itr=str.iterator();
		while (itr.hasNext())
			
		{
			//System.out.println(itr.next());
			
			System.out.println(driver.switchTo().window((String) itr.next()).getTitle());
			Thread.sleep(500);
			
			
		}
		
		driver.switchTo().window((String) str.toArray()[2]);
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
			
	}

}
