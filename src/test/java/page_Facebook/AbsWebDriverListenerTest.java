package page_Facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class AbsWebDriverListenerTest extends AbstractWebDriverEventListener{
	
	
	
	public void afterNavigateTo(String url, WebDriver driver) {
		
		System.out.println("fue a la pagina : "+url);
	
	}
	
	
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("dio click a ; "+element.getText());
	
	}
	
	
		}
