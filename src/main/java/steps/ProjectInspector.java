package steps;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ProjectInspector {

	public static int i = 0;
	static final Logger logger = LogManager.getLogger(StepLogin.class);
	public static WebDriver driver;
	public static String valor;
	Calendar calendario = new GregorianCalendar();
	final static Properties p = new Properties();
	String CSV_PATH_INSPECTOR = "Data/project.csv";
}
