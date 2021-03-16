package scientia.periodic_table_editor;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private Button btn_updt_tbl;

    @FXML
    private ImageView img;

    @FXML
    private TextField txt_formula;

    @FXML
    private Button btn_crt_tbl;

    @FXML
    private ChoiceBox<String> cbox_fill_empty_cells;

    @FXML
    private TextField txt_xlsx_path;

    @FXML
    private Button btn_fill_empty_cells;

    @FXML
    private Button btn_img;

    @FXML
    private ChoiceBox<String> cbox_math_sys;

    @FXML
    private TextField txt_num;

    @FXML
    private ChoiceBox<String> cbox_crt_tbl;

    @FXML
    private Button btn_html_path;

    @FXML
    private ChoiceBox<String> cbox_crt_math_tbl;

    @FXML
    private TextField txt_html_path;

    @FXML
    private Button btn_xlsx_path;
    
    @FXML
    private TextField txt_hex;

    @FXML
    private Button btn_crt_math_tbl;
    
    @FXML
    private Pane pane_clr;
    
    @FXML
    void initialize () {
    	Text text=new ExcelText();
    	Paint htmlpaint= new HTMLPaint();
    	Path fpath=new FilePath();
    	Path dpath=new DirectoryPath();
    	Table exceltable=new ExcelTable();
    	Table htmltable=new HTMLTable();
    	Color color=new ImageColor();
    	cbox_crt_tbl.getItems().addAll("Excel", "HTML");
    	cbox_crt_tbl.getSelectionModel().selectFirst();
    	cbox_crt_math_tbl.getItems().addAll("Excel","HTML");
    	cbox_crt_math_tbl.getSelectionModel().selectFirst();
    	//Математические системы
    	cbox_math_sys.getItems().addAll("MathSystem1");
    	cbox_math_sys.getItems().addAll("MathSystemDuoDeci");
    	cbox_math_sys.getItems().addAll("MathSystemHex");
    	cbox_math_sys.getSelectionModel().selectFirst();
    	cbox_fill_empty_cells.getItems().addAll("MathSystem1");
    	cbox_fill_empty_cells.getItems().addAll("MathSystemDuoDeci");
    	cbox_fill_empty_cells.getItems().addAll("MathSystemHex");
    	cbox_fill_empty_cells.getSelectionModel().selectFirst();
       
       //Выбрать файл xlsx
       btn_xlsx_path.setOnAction(e -> {
        		txt_xlsx_path.setText(fpath.getPath("excel"));
        	});
       //Выбрать файл html
       btn_html_path.setOnAction(e -> {  	   
   				txt_html_path.setText(fpath.getPath("html"));
   			});
       //Создать таблицу excel/html
       btn_crt_tbl.setOnAction(e -> {
    	   String path;
       switch (cbox_crt_tbl.getValue()) {
       case "Excel": 
    	   path=dpath.getPath("excel");
    	   exceltable.Create("main", path); 
    	   txt_xlsx_path.setText(path);
    	   break;
       case "HTML": 
    	   path=dpath.getPath("html");
    	   htmltable.Create("html", path);  
    	   txt_html_path.setText(path);
    	   break;
       }
        });
       //Выбрать изображение
       btn_img.setOnAction(e -> {
    	   String imgPath=fpath.getPath("image");
    	   File file= new File(imgPath);
    	   Image image= new Image(file.toURI().toString());
    	   img.setImage(image);
    	   String hexCode=color.getColor(imgPath);
    	   txt_hex.setText(hexCode);
    	   pane_clr.setStyle("-fx-background-color: " + hexCode + ";");
       });
       //Обновить таблицы
       btn_updt_tbl.setOnAction(e -> {
    	  String hex=txt_hex.getText();
    	  int Z=Integer.parseInt(txt_num.getText());
    	  String htmlpath=txt_html_path.getText();
    	  String excelpath=txt_xlsx_path.getText();
    	  String formula=txt_formula.getText();
    	  htmlpaint.PaintTable(htmlpath,Z,hex);
    	  text.setText(excelpath, Z, 7, hex);
    	  text.setText(excelpath, Z, 8, formula);      
        });
       //Создать математическую таблицу xlsx/html
       btn_crt_math_tbl.setOnAction(e -> {
    	   String path;
    	   switch (cbox_crt_math_tbl.getValue()) {
           case "Excel": 
        	   path=dpath.getPath("excel");
        	   exceltable.Create("math", path); 
        	   switch (cbox_math_sys.getValue()) {
               case "MathSystem1": 
            	   Math sys1=new MathSystem1();
            	   for(int i=1;i<=118;i++) {
            	   text.setText(path, i, 7, sys1.getHex(i));}
               		break;
        	   
               case "MathSystemDuoDeci": 
            	   Math sysDuoDeci=new MathSystemDuoDeci();
            	   for(int i=1;i<=118;i++) {
            		   text.setText(path, i, 7, sysDuoDeci.getHex(i));}
           			break;
               case "MathSystemHex": 
            	   Math sysHex=new MathSystemHex();
            	   for(int i=1;i<=118;i++) {
            		   text.setText(path, i, 7, sysHex.getHex(i));}
           			break;
    	   }
    	   break;
           case "HTML": 
        	   path=dpath.getPath("html");
        	   htmltable.Create("html", path);  
        	   switch (cbox_math_sys.getValue()) {
               case "MathSystem1": 
            	   Math sys1=new MathSystem1();
            	   for(int i=1;i<=118;i++) {
            		   htmlpaint.PaintTable(path,i,sys1.getHex(i));}
               		break;
               case "MathSystemDuoDeci": 
            	   Math sysDuoDeci=new MathSystemDuoDeci();
            	   for(int i=1;i<=118;i++) {
            		   htmlpaint.PaintTable(path,i,sysDuoDeci.getHex(i));}
               		break;
               case "MathSystemHex": 
            	   Math sysHex=new MathSystemHex();
            	   for(int i=1;i<=118;i++) {
            		   htmlpaint.PaintTable(path,i,sysHex.getHex(i));}
               		break;
        	   }
        	   break;
        	   }       	   
       });
       //Заполнить пустые ячейки
       btn_fill_empty_cells.setOnAction(e -> {
    	   String htmlpath=txt_html_path.getText();
     	   String excelpath=txt_xlsx_path.getText();
    	   switch (cbox_math_sys.getValue()) {
           case "MathSystem1": 
        	   Math sys1=new MathSystem1();
        	   for(int i=1;i<=118;i++) {
        	   text.setText(excelpath, i, 7, sys1.getHex(i));
        	   htmlpaint.PaintTable(htmlpath,i,sys1.getHex(i));}
           		break;
           case "MathSystemDuoDeci": 
        	   Math sysDuoDeci=new MathSystemDuoDeci();
        	   for(int i=1;i<=118;i++) {
        	   text.setText(excelpath, i, 7, sysDuoDeci.getHex(i));
        	   htmlpaint.PaintTable(htmlpath,i,sysDuoDeci.getHex(i));}
           		break;
           case "MathSystemHex": 
        	   Math sysHex=new MathSystemHex();
        	   for(int i=1;i<=118;i++) {
        	   text.setText(excelpath, i, 7, sysHex.getHex(i));
        	   htmlpaint.PaintTable(htmlpath,i,sysHex.getHex(i));}
           		break;
    	   }
        	   
       });
    	
    }}


