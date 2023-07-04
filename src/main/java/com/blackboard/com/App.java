package com.blackboard.com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import interaccion.Interaccion;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import StepTime.StepTime;
import steps.StepLogin;

/**
 * 
 * @class App
 * 
 * @since automation SFDC.
 *
 * 
 * @code The App class is responsible for instantiating all the methods of the
 *       others. later classes and valid execution
 * 
 *       @author Tools Team - Jorge Guio
 * @version: 1.0
 * @Date: 17/02/2022
 * 
 **/

public abstract class App implements StepTime {

	public static int i = 0;
	static final Logger logger = LogManager.getLogger(StepLogin.class);
	public static WebDriver driver;
	public static String valor;
	Calendar calendario = new GregorianCalendar();
	final static Properties p = new Properties();

	public static void main(String args[]) throws Exception {

		try {
			p.load(new FileReader("config/config.properties"));
			Interaccion.fecha_Ejec();
			logger.info("Starting nav... please wait.");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			@Start
			StepLogin login = new StepLogin();
			login.Login(driver);

		} catch (Exception e) {
			logger.info("Error main:" + e.getMessage());
		} finally {

		}

	}
}