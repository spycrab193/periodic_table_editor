package scientia.periodic_table_editor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelText implements Text{
	//Занесение текста в таблицу excel
	@Override
	public void setText(String path, int numRow, int numCell, String text) {
		try (InputStream inp = new FileInputStream(path)) {
		 XSSFWorkbook wb=new XSSFWorkbook(inp);
		    XSSFSheet sheet = wb.getSheetAt(0);
		    Row row = sheet.getRow(numRow);
		    
		    Cell cell = row.getCell(numCell);
		    if (cell == null) {
		    cell = row.createCell(numCell);
		    cell.setCellValue(text);}
		    try (OutputStream fileOut = new FileOutputStream(path)) {
		        wb.write(fileOut);
		        wb.close();
		    } } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	}
	

}
}
