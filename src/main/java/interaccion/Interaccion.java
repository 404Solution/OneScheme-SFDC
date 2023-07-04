package interaccion;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Interaccion {

	final static Logger logger = LogManager.getLogger(Interaccion.class);
	private static File carpetaFallo;
	private static File carpetaEvidencia;
	private static File carpetaHora;

	public static File getCarpetaHora() {
		return carpetaHora;
	}

	public static void setCarpetaHora(File carpetaHora) {
		Interaccion.carpetaHora = carpetaHora;
	}

	static long Tim1 = System.currentTimeMillis();

	/**
	 * static dates
	 * 
	 * @param driver
	 */

	public static void folderEjecucion(WebDriver driver) {
		try {
			Calendar calendario = new GregorianCalendar();
			Date ahora = new Date();
			SimpleDateFormat formateador = new SimpleDateFormat("MMMM");

			File carpetaMes = new File("logs\\" + calendario.get(Calendar.DATE) + "-" + formateador.format(ahora) + "-"
					+ calendario.get(Calendar.YEAR));
			carpetaMes.mkdir();

			carpetaHora = new File(
					carpetaMes + "\\" + calendario.get(Calendar.HOUR) + "." + calendario.get(Calendar.MINUTE));
			carpetaHora.mkdir();

			carpetaEvidencia = new File(carpetaHora + "\\photoEvidencia");
			carpetaEvidencia.mkdir();

			carpetaFallo = new File(carpetaHora + "\\photoFallo");
			carpetaFallo.mkdir();

		} catch (Exception e) {
			logger.error("Error generating execution folders");
		}
	}

	public static String fecha_Ejec_Steps() {
		Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("MMMM");

		Calendar calendario = new GregorianCalendar();
		String Hora = "" + calendario.get(Calendar.HOUR) + "." + calendario.get(Calendar.MINUTE);

		String InicioEjecucion = (calendario.get(Calendar.DATE) + "/" + formateador.format(ahora) + "/"
				+ calendario.get(Calendar.YEAR) + "/" + Hora);

		return InicioEjecucion;

	}

	public static void fecha_Ejec() {
		Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("MMMM");

		Calendar calendario = new GregorianCalendar();
		String inicio_Eje = "" + calendario.get(Calendar.HOUR) + ":" + calendario.get(Calendar.MINUTE) + ":"
				+ calendario.get(Calendar.SECOND);

		logger.info(" STARTING.. Google Chrome " + calendario.get(Calendar.DATE) + " de " + formateador.format(ahora)
				+ " del " + calendario.get(Calendar.YEAR) + " a las " + inicio_Eje);

	}
}
