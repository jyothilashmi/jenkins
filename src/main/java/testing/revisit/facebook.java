package testing.revisit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(testing.revisit.ExtentTestNGITestListener.class)
public class facebook {
	
	@Test
	public void testtours()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.facebook.com/";
		String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = "";

        // launch chrome and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        //close chrome
        driver.close();
	}
	@Test
	public void tearDown()
	{
		System.out.println("closing....");
	}

}
