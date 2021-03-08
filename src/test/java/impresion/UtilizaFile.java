package impresion;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
public class UtilizaFile {
	
	
GeneraEvidencias imprEvi;

	public void pasoDelScrip(String descripcionPaso) throws InvalidFormatException, IOException, HeadlessException, AWTException {
		imprEvi.OpenFile(1,descripcionPaso);  //" 1. Abre Nabegador"
		imprEvi.screenshoot();
}
	
	public void inicializaFile() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		
		imprEvi.defineVariables();
}
	
	public void GeneraEvidencia(String NombreArchivo) throws IOException {
		
		imprEvi.CloseFile(NombreArchivo);
}


}
