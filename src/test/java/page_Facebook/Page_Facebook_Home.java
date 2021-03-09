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
	private By btn_crearCuenta=By.xpath("//div[@class='_6ltg']/following-sibling::div[3]/child::a[1]");//xpath axes 
	private By txt_nombre=By.xpath("//input[@name='firstname' or @placeholder='nombre']"); //xpath
	private By txt_apellido=By.name("lastname"); 
	private By txt_CelOMail=By.name("reg_email__");
	private By txt_CelOMail2=By.name("reg_email_confirmation__");
	private By txt_Clave=By.id("password_step_input");
	private By desple_dia=By.id("day");
	private By desple_mes=By.name("birthday_month");
	private By desple_anio=By.id("year");
	private By cbox_mujer =By.xpath("//label[@class='_58mt'][contains(text(),'Mujer')]");
	private By cbox_hombre =By.xpath("//label[@class='_58mt'][contains(text(),'Hombre')]");
//	private By cbox_Personalizado =By.xpath("//label[@class='_58mt'][contains(text(),'Personalizado')]"); 
	private By deple_Pronombre =By.name("preferred_pronoun");
	private By txt_genero=By.name("custom_gender");
	//private By btn_Registro=By.id("u_f_s_Io");
	
	public void iniciarDriver(WebDriver driver) throws HeadlessException, InvalidFormatException, IOException, AWTException {
		this.driver=driver;
		
	}	
	
	public void MaxPantalla(WebDriver driver) throws HeadlessException, IOException, AWTException, InvalidFormatException {
		driver.manage().window().maximize();
		word.inicializaFile();
	}
	
	public void clickCrearCuenta() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
	
		driver.findElement(btn_crearCuenta).click();
			word.pasoDelScrip("1. maximiza la pantalla ");
	}
	
	public void EscribeNombre(String nombre) throws IOException, HeadlessException, InvalidFormatException, AWTException  {
		
		driver.findElement(txt_nombre).sendKeys(nombre);
		word.pasoDelScrip("2.  El usuario escribe su nombre : "+nombre);
	}

		public void EscribeApellido(String apellido) throws AWTException, IOException, HeadlessException, InvalidFormatException{
		
// usar para dar click
			
			driver.findElement(txt_apellido).sendKeys(apellido);
			
			word.pasoDelScrip("3.  El usuario escribe su apellido : "+apellido);
	}

	public void EscribeEmail(String email) throws HeadlessException, InvalidFormatException, IOException, AWTException  {
		driver.findElement(txt_CelOMail).sendKeys(email);
		
		word.pasoDelScrip("4.  El usuario escribe su Email : "+email);
	}
	public void EscribeEmailConf(String email) throws HeadlessException, InvalidFormatException, IOException, AWTException  {
		driver.findElement(txt_CelOMail2).sendKeys(email);
		word.pasoDelScrip("5.  El usuario escribe su Email : " +email);
	}
	public void EscribeClave(String clave) throws HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(txt_Clave).sendKeys(clave);
		word.pasoDelScrip("6.  El usuario escribe su clave : " +clave);
	}

	
	public void EscribeDia(String dia) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException  {
	
		Select dias= new Select(driver.findElement(desple_dia));
		
		dias.selectByValue(dia);
		word.pasoDelScrip("7.  El usuario escribe su dia de nacimiendo : "+ dia);
	}
	public void EscribeMes(String mes) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException  {
		
		Select fecha= new Select(driver.findElement(desple_mes));
			

		fecha.selectByValue(mes);
		word.pasoDelScrip("8.  El usuario escribe el mes de nacimiento : "+ mes);
	}
	public void EscribeAño(String anio) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException  {
		
		Select fecha= new Select(driver.findElement(desple_anio));
		
	
		fecha.selectByValue(anio);
		word.pasoDelScrip("9.  El usuario escribe su año de nacimiendo");
	}
	public void selecciona(String selecciona) throws AWTException, HeadlessException, InvalidFormatException, IOException {
		robot= new Robot();
		if(selecciona.equalsIgnoreCase("mujer")){
		driver.findElement(cbox_mujer).click();
		}
		else if(selecciona.equalsIgnoreCase("hombre")) {
			driver.findElement(cbox_hombre).click();
	
		}else
		{ //driver.findElement(By.xpath(cbox_Personalizado)).click();
			driver.findElement(cbox_hombre).click();     //hago esto para utilizar Robot, si no la opcion de arriba es la correcta
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
			
		}
word.pasoDelScrip("10.  El usuario escribe Sexo : "+selecciona);	
}

	public void SelecPronombre(String pronombre) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException  {
		String [][] pronombre1= {{"1","Femenino"},{"2","Masculino"},{"6","Neutro"}}; //hay solucion sin matriz pero queria usarla  
			Select prom= new Select(driver.findElement(deple_Pronombre));
				for(int i=0;i<=1;i++) {
			if(pronombre.equals(pronombre1[i][1])){
				prom.selectByValue(pronombre1[i][0]);
			}
			
		}
		

		word.pasoDelScrip("11.  El usuario  elige pronombre : "+pronombre);

	}
	public void Genero(String genero) throws HeadlessException, InvalidFormatException, IOException, AWTException  {
		
		driver.findElement(txt_genero).sendKeys(genero);
		word.pasoDelScrip("12.  El usuario escribe su Genero"+genero);
	}
	public void tomaScreenShoot(String nombrePaso, WebDriver driver) throws IOException, HeadlessException, AWTException, InterruptedException, InvalidFormatException {
      
		File screenShot;
		screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("C:\\Users\\Alejandro\\eclipse-workspace\\TestPageObjectMode1\\target\\"+nombrePaso+"333.png")); // apache commons io
		word.pasoDelScrip("13. Screnshot de evidencia");
	}
	
	public void FinalizarDriver(WebDriver driver) throws IOException {
	
		word.GeneraEvidencia("FacebookTest.docx");	
		 driver.close();	
		 
	}
	
}
	

