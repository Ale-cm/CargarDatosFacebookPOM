package TestPage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page_Facebook.Page_Facebook_Home;

public class testPage_facebook {

	public static void main(String[] args) throws HeadlessException, IOException, AWTException, InterruptedException, InvalidFormatException {
		// TODO Auto-generated method stub
			WebDriver driver;
			Page_Facebook_Home face=new Page_Facebook_Home ();
			System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			
			
			face.iniciarDriver(driver);
			face.MaxPantalla(driver);
			face.clickCrearCuenta();
			face.EscribeNombre("juan");
			face.EscribeApellido("monso");
			face.EscribeEmail("armandoBarreda@gmail.com");
			face.EscribeClave("algaosdasas");
			face.EscribeEmailConf("armandoBarreda@gmail.com");
			face.EscribeDia("3");
			face.EscribeMes("5");
			face.EscribeAño("1994");
			face.tomaScreenShoot("ScreenAFecha", driver);
			face.selecciona("Personalizado");
			face.SelecPronombre("Masculino");
			face.Genero("bin");
			Thread.sleep(3333);
			System.out.println("Aquí termina");
			face.FinalizarDriver(driver);
			
	}

}
