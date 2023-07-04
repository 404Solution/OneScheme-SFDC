package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencsv.CSVReader;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
 * 
 * @class StepLogin.
 * 
 * @sinceThe StepLogin class is responsible for validating the login with the
 *           shipping parameters
 * 
 * @author Tools Team - Jorge Guio
 * @version: 1.0
 * @Date: 17/02/2022
 * 
 **/

public class StepLogin {
	public static int i = 0;
	static final Logger logger = LogManager.getLogger(StepLogin.class);
	public static WebDriver driver;
	public static String valor;
	Calendar calendario = new GregorianCalendar();
	final static Properties p = new Properties();
	String CSV_PATH_LOGIN = "Data/Login.csv";

	public void Login(WebDriver driver) throws Exception {

		try {

			CSVReader reader = new CSVReader(new FileReader(CSV_PATH_LOGIN));
			String[] csvCell;
			while ((csvCell = reader.readNext()) != null) {
				String url = csvCell[0];
				String user = csvCell[1];
				String password = csvCell[2];
				p.load(new FileReader("config/config.properties"));
				long inicio1 = System.currentTimeMillis();
				logger.info("Estimate time = " + (System.currentTimeMillis() - inicio1 + " ms"));
				logger.info("Login in progress..");
				driver.get(url);
				
				WebElement User = driver.findElement(By.xpath("//*[@id=\"login-form-username\"]"));
				User.sendKeys(user);
				WebElement Password = driver.findElement(By.xpath("//*[@id=\"login-form-password\"]"));
				Password.sendKeys(password);
				Password.submit();
				
				logger.info("200 OK");
				//logger.info("Selecting issue :" + url);
			}
			/*
			 * ScrollDown
			 */

			
			// 
			/*
			WebDriverWait waitfields = new WebDriverWait(driver, 30);
			waitfields.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"descriptionmodule_heading\"]/h4")))
					.click();

			Thread.sleep(1000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		*/ 
			
			/*
			 * Validation SFDC contain ID
			 */

			/* 
			 * driver.switchTo().frame("sfjp-iframe");
			 

			waitfields.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[(text() = 'Auto-Pull')]"))).click();

			driver.switchTo().defaultContent();

			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			driver.switchTo().frame("sfjp-iframe");
			

			waitfields.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[(text() = 'Unlink')]"))).click();
			logger.info("SFDC ID OK");
			
			*/
			
		} catch (Exception e) {
			logger.error("Class ERROR: " + e.getMessage());
			driver.quit();
		}

	}
}
