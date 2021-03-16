package scientia.periodic_table_editor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HTMLPaint implements Paint{
	//Закрашивание таблицы html
	@Override
	public void PaintTable(String path, int Z, String hex) {
		       File file = new File(path);
		       String id=Integer.toString(Z);
		       try {
				Document doc = Jsoup.parse(file, "UTF-8");
				
		       Element td=doc.getElementById(id);
		      if (td.attr("bgcolor")=="") 
		    	   td.attr("bgcolor",hex);
		       String html=doc.html();
		       FileWriter writer = new FileWriter(path);
			      writer.write(html);
			      writer.close();
		       } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		  
	}
	

}
