package scientia.periodic_table_editor;

import java.io.File;
import javafx.stage.FileChooser;

public class DirectoryPath implements Path{
	//Выбор папки для создания нового файла
	@Override
	public String getPath(String type) {
		FileChooser fileChooser = new FileChooser();
		switch(type) {
		case "excel":
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Excel","*.xlsx"));
			fileChooser.setInitialFileName("table.xlsx");
			break;
		case "html":
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("HTML", "*.html"));
			fileChooser.setInitialFileName("table.html");
			break;
		}
		File file = fileChooser.showSaveDialog(null);
		return file.getAbsolutePath();
}
}	

