package TestPage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType.ForSeleniumServer;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import page_Facebook.AbsWebDriverListenerTest;
import page_Facebook.Page_Facebook_Home;

public class testPage_facebook   {

	public static void main(String[] args) throws HeadlessException, IOException, AWTException, InterruptedException, InvalidFormatException, ATUTestRecorderException {
		ATUTestRecorder grabaVideo= new ATUTestRecorder("C:\\Users\\Alejandro\\eclipse-workspace\\TestPageObjectMode1\\src\\videos\\","videonuevo",false);
			WebDriver driver;
			Page_Facebook_Home face=new Page_Facebook_Home ();
			System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			
			grabaVideo.start();
			EventFiringWebDriver EFWdriver= new EventFiringWebDriver(driver);
			AbsWebDriverListenerTest weblistener = new AbsWebDriverListenerTest();
			
			EFWdriver.register(weblistener);	
			EFWdriver.get("https://www.facebook.com/");
			
			face.iniciarDriver(EFWdriver);
			face.MaxPantalla(EFWdriver);
			face.clickCrearCuenta();
			face.EscribeNombre("juan");
			face.EscribeApellido("monso");
			face.EscribeEmail("armandoBarreda@gmail.com");
			face.EscribeClave("algaosdasas");
			face.EscribeEmailConf("armandoBarreda@gmail.com");
			face.EscribeDia("3");
			face.EscribeMes("5");
			face.EscribeA�o("1994");
			
			face.tomaScreenShoot("ScreenAFecha", driver);
			face.selecciona("Personalizado");
			face.SelecPronombre("Masculino");
			face.Genero("bin");
			
			
			
			
			
			grabaVideo.stop();
			Thread.sleep(4000);
			System.out.println("Aqu� termina");
			face.FinalizarDriver(driver);
			
	}

}
