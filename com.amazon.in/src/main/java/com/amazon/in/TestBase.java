package com.amazon.in;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners(com.amazon.in_Utiles.Listener.class) 
public class TestBase {

		protected WebDriver driver;
		public static Logger log = LogManager.getLogger(TestBase.class);


		@Parameters({"browser"})
	    @BeforeMethod
	    public void setUp(@Optional("chrome") String browser) {
	        log.info("Browser selected: " + browser);

	        if (browser.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	            log.info("Chrome browser launched.");
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	            log.info("Firefox browser launched.");
	        } else {
	            throw new IllegalArgumentException("Unsupported browser: " + browser);
	        }

	        driver.get("https://www.amazon.in");
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        log.info("Browser setup completed.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            log.info("Closing the browser...");
	            driver.quit();
	        }
	    }
	}
	/*Base Class:Base class ka kaam driver initialization, teardown, aur common setup 
	tasks (jaise browser launch) ko handle karna hota hai. kyunki Base Class ka kaam aur
	 bhi  tasks manage karta hai*/
	


