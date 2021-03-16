package scientia.periodic_table_editor;
import java.io.File;
import javafx.stage.FileChooser;

public class FilePath implements Path {
	//Поиск файла
	@Override
	public String getPath(String type) {
		FileChooser fileChooser = new FileChooser();
		switch(type) {
		case "excel":
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Excel","*.xls"));
			break;
		case "html":
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("HTML", "*.html"));
			break;
		case "image":
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Image", "*.raw","*.png","*.jpg"));
			break;
		}
		
		File file = fileChooser.showOpenDialog(null);
		return file.getAbsolutePath();
}
}	
