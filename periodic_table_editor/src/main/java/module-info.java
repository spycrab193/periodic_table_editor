module scientia.periodic_table_editor {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires poi;
	requires poi.ooxml;
	requires org.jsoup;
	requires java.desktop;
	requires javafx.graphics;

    opens scientia.periodic_table_editor to javafx.fxml;
    exports scientia.periodic_table_editor;
}