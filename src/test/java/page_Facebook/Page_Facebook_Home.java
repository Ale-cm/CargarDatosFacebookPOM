		package page_Facebook;
		
		import java.awt.AWTException;
		import java.awt.HeadlessException;
		import java.awt.Robot;
		import java.awt.event.KeyEvent;
		import java.io.File;
		import java.io.IOException;
		
		import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.support.ui.Select;

		import impresion.UtilizaFile;
		
		public class Page_Facebook_Home {
	 UtilizaFile word=new UtilizaFile();
	protected		Robot robot;
	protected WebDriver driver;
	private String btn_crearCuenta="//div[@class='_6ltg']/following-sibling::div[3]/child::a[1]";//xpath axes 
	private String txt_nombre="//input[@name='firstname']";
	private String txt_apellido="lastname";
	private String txt_CelOMail="reg_email__";
	private String txt_CelOMail2="reg_email_confirmation__";
	private String txt_Clave="password_step_input";
	private String desple_dia="day";
	private String desple_mes="birthday_month";
	private String desple_anio="year";
	private String cbox_mujer ="//label[@class='_58mt'][contains(text(),'Mujer')]";
	private String cbox_hombre ="//label[@class='_58mt'][contains(text(),'Hombre')]";
	private String cbox_Personalizado ="//label[@class='_58mt'][contains(text(),'Personalizado')]"; 
	private String deple_Pronombre ="preferred_pronoun";
	private String txt_genero="custom_gender";
	private String btn_Registro="u_f_s_Io";
	
	public void iniciarDriver(WebDriver driver) throws HeadlessException, InvalidFormatException, IOException, AWTException {
		this.driver=driver;
		
	}	
	
	public void MaxPantalla(WebDriver driver) throws HeadlessException, IOException, AWTException, InvalidFormatException {
		driver.manage().window().maximize();
		word.inicializaFile();
	}
	
	public void clickCrearCuenta() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
	
		driver.findElement(By.xpath(btn_crearCuenta)).click();
			word.pasoDelScrip("1. maximiza la pantalla");
	}
	
	public void EscribeNombre(String nombre) throws IOException, HeadlessException, InvalidFormatException, AWTException  {
		
		driver.findElement(By.xpath(txt_nombre)).sendKeys(nombre);
		word.pasoDelScrip("2.  El usuario escribe su nombre");
	}

		public void EscribeApellido(String apellido) throws AWTException, IOException, HeadlessException, InvalidFormatException{
		
// usar para dar click
			
			driver.findElement(By.name(txt_apellido)).sendKeys(apellido);
			
			word.pasoDelScrip("2.  El usuario escribe su apellido");
	}

	public void EscribeEmail(String email)  {
		driver.findElement(By.name(txt_CelOMail)).sendKeys(email);
		
	}
	public void EscribeEmailConf(String email)  {
		driver.findElement(By.name(txt_CelOMail2)).sendKeys(email);
		
	}
	public void EscribeClave(String clave) {
		driver.findElement(By.id(txt_Clave)).sendKeys(clave);
		
	}

	
	public void EscribeDia(String dia) throws InterruptedException  {
	
		Select dias= new Select(driver.findElement(By.id(desple_dia)));
		
		dias.selectByValue(dia);

	}
	public void EscribeMes(String mes) throws InterruptedException  {
		
		Select fecha= new Select(driver.findElement(By.name(desple_mes)));
			

		fecha.selectByValue(mes);

	}
	public void EscribeAño(String anio) throws InterruptedException  {
		
		Select fecha= new Select(driver.findElement(By.id(desple_anio)));
		
	
		fecha.selectByValue(anio);

	}
	public void selecciona(String selecciona) throws AWTException {
		robot= new Robot();
		if(selecciona.equalsIgnoreCase("mujer")){
		driver.findElement(By.xpath(cbox_mujer)).click();
		}
		else if(selecciona.equalsIgnoreCase("hombre")) {
			driver.findElement(By.xpath(cbox_hombre)).click();
	
		}else
		{ //driver.findElement(By.xpath(cbox_Personalizado)).click();
			driver.findElement(By.xpath(cbox_hombre)).click();
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);

		}
	}

	public void SelecPronombre(String pronombre) throws InterruptedException  {
		String [][] pronombre1= {{"1","Femenino"},{"2","Masculino"},{"6","Neutro"}};
			Select prom= new Select(driver.findElement(By.name(deple_Pronombre)));
				for(int i=0;i<=1;i++) {
			if(pronombre.equals(pronombre1[i][1])){
				prom.selectByValue(pronombre1[i][0]);
			}
			
		}
		

		

	}
	public void Genero(String genero)  {
		
		driver.findElement(By.name(txt_genero)).sendKeys(genero);
		
	}
	public static void tomaScreenShoot(String nombrePaso, WebDriver driver) throws IOException, HeadlessException, AWTException, InterruptedException {

		File screenShot;
		screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("/TestPageObjectMode1/target"+nombrePaso+"333.png")); // apache commons io
	
	}
	
	public void FinalizarDriver(WebDriver driver) throws IOException {
	
		word.GeneraEvidencia("FacebookTest.docx");	
		 driver.close();	
		 
	}
}
	

