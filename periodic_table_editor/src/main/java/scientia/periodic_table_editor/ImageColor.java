package scientia.periodic_table_editor;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.*;

public class ImageColor implements Color{
	//Получение среднего цвета изображения
	@Override
	public String getColor(String path) {
		

		  File file= new File(path);
		  //Списки значений красного, зелёного и синего
		  ArrayList<Integer> redList = new ArrayList<Integer>();
		  ArrayList<Integer> greenList = new ArrayList<Integer>();
		  ArrayList<Integer> blueList = new ArrayList<Integer>();
		  
		try {
			BufferedImage image = ImageIO.read(file);
		

		  // Getting pixel color by position x and y 
		  int xMax=image.getWidth();
		  int yMax=image.getHeight();
		 
		  for (int y=0; y < yMax;y++) {
			  for (int x=0; x < xMax;x++) {
				  int clr=  image.getRGB(x,y); 
				  int  red   = (clr & 0x00ff0000) >> 16;
				  int  green = (clr & 0x0000ff00) >> 8;
				  int  blue  =  clr & 0x000000ff;
			  	
			  	redList.add(red);
			  	greenList.add(green);
			  	blueList.add(blue);
		  }

		  } 
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  int sumRed=0; 
		  int avrgRed=0; 
		  int sumGreen=0; 
		  int avrgGreen=0; 
		  int sumBlue=0; 
		  int avrgBlue=0;
		  //Сумма всех значений цвета
		  for (int i=0;i<redList.size();i++) {
			sumRed=sumRed+redList.get(i); 
		  	}
		  for (int i=0;i<greenList.size();i++) {
				sumGreen=sumGreen+greenList.get(i); 
			  }
		  for (int i=0;i<blueList.size();i++) {
				sumBlue=sumBlue+blueList.get(i); 
			  }
		  //Среднее значение
		  avrgRed=sumRed/redList.size();
		  avrgGreen=sumGreen/greenList.size();
		  avrgBlue=sumBlue/blueList.size();
		  
		  
		  String hex;
			String red=Integer.toHexString(avrgRed);
			String green=Integer.toHexString(avrgGreen);
			String blue=Integer.toHexString(avrgBlue);
			if(avrgRed<=15) red="0"+red;
			if(avrgGreen<=15) green="0"+green;
			if(avrgBlue<=15) blue="0"+blue;
			hex="#"+ red +green + blue;
			return hex.toUpperCase();
		  }
		  
	
		

	}
	

