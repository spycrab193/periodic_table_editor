package scientia.periodic_table_editor;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class HTMLTable implements Table{
	//Создание таблицы html
	@Override
	public void Create(String type, String path) {
		try (FileInputStream fin=new FileInputStream("src/main/resources/scientia/periodic_table_editor/table/html.txt");
                FileOutputStream fos=new FileOutputStream(path)){
			 byte[] buffer = new byte[fin.available()];
	            // считываем буфер
	            fin.read(buffer, 0, buffer.length);
	            // записываем из буфера в файл
	            fos.write(buffer, 0, buffer.length);
	            fin.close();
	            fos.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}

}
