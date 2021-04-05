package scientia.periodic_table_editor;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;   
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
/*			FileReader reader=new FileReader("src/main/resources/scientia/periodic_table_editor/table/html.txt");
			String html=reader.toString();*/
/*			  String html="<html> \n"
			  		+ " <head> \n"
			  		+ "  <meta charset=\"UTF-8\"> \n"
			  		+ "  <title>Periodic table</title> \n"
			  		+ " </head> \n"
			  		+ " <body> \n"
			  		+ "  <table width=\"100%\" hight=\"100%\"> \n"
			  		+ "  </table>\n"
			  		+ "  <table border=\"1\" width=\"100%\" hight=\"100%\"> \n"
			  		+ "   <tbody>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td>Group ⇒<br>Period ⇓</td>\n"
			  		+ "     <td>1<br>I A</td>\n"
			  		+ "     <td>2<br>II A</td>\n"
			  		+ "     <td>3<br>III B</td>\n"
			  		+ "     <td>4<br>IV B</td>\n"
			  		+ "     <td>5<br>V B</td>\n"
			  		+ "     <td>6<br>VI B</td>\n"
			  		+ "     <td>7<br>VII B</td>\n"
			  		+ "     <td>8<br>VIII B</td>\n"
			  		+ "     <td>9<br>VIII B</td>\n"
			  		+ "     <td>10<br>VIII B</td>\n"
			  		+ "     <td>11<br>I B</td>\n"
			  		+ "     <td>12<br>II B</td>\n"
			  		+ "     <td>13<br>III A</td>\n"
			  		+ "     <td>14<br>IV A</td>\n"
			  		+ "     <td>15<br>V A</td>\n"
			  		+ "     <td>16<br>VI A</td>\n"
			  		+ "     <td>17<br>VII A</td>\n"
			  		+ "     <td>18<br>VIII A </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td>1</td>\n"
			  		+ "     <td id=\"1\">1<br><b><font size=\"+1\">H</font></b><br>Hydrogenium<br>1,00783</td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td id=\"2\">2<br><b><font size=\"+1\">He</font></b><br>Helium<br>4,0026 </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td>2</td>\n"
			  		+ "     <td id=\"3\">3<br><b><font size=\"+1\">Li</font></b><br>Lithium<br>6,941</td>\n"
			  		+ "     <td id=\"4\">4<br><b><font size=\"+1\">Be</font></b><br>Beryllium<br>9,0122</td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td id=\"5\">5<br><b><font size=\"+1\">B</font></b><br>Borum<br>10,81</td>\n"
			  		+ "     <td id=\"6\">6<br><b><font size=\"+1\">C</font></b><br>Carboneum<br>12,011</td>\n"
			  		+ "     <td id=\"7\">7<br><b><font size=\"+1\">N</font></b><br>Nitrogenium<br>14,0067</td>\n"
			  		+ "     <td id=\"8\">8<br><b><font size=\"+1\">O</font></b><br>Oxygenium<br>15,9994</td>\n"
			  		+ "     <td id=\"9\">9<br><b><font size=\"+1\">F</font></b><br>Fluorum<br>18,998</td>\n"
			  		+ "     <td id=\"10\">10<br><b><font size=\"+1\">Ne</font></b><br>Neon<br>20,179 </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td>3</td>\n"
			  		+ "     <td id=\"11\">11<br><b><font size=\"+1\">Na</font></b><br>Natrium<br>22,9898</td>\n"
			  		+ "     <td id=\"12\">12<br><b><font size=\"+1\">Mg</font></b><br>Magnesium<br>24,305</td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td></td>\n"
			  		+ "     <td id=\"13\">13<br><b><font size=\"+1\">Al</font></b><br>Aluminium<br>26,9815</td>\n"
			  		+ "     <td id=\"14\">14<br><b><font size=\"+1\">Si</font></b><br>Silicium<br>28,086</td>\n"
			  		+ "     <td id=\"15\">15<br><b><font size=\"+1\">P</font></b><br>Phosphorus<br>30,9738</td>\n"
			  		+ "     <td id=\"16\">16<br><b><font size=\"+1\">S</font></b><br>Sulphur<br>32,06</td>\n"
			  		+ "     <td id=\"17\">17<br><b><font size=\"+1\">Cl</font></b><br>Chlorum<br>35,453</td>\n"
			  		+ "     <td id=\"18\">18<br><b><font size=\"+1\">Ar</font></b><br>Argon<br>39,948 </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td>4</td>\n"
			  		+ "     <td id=\"19\">19<br><b><font size=\"+1\"></font>K</b><br>Kalium<br>39,098</td>\n"
			  		+ "     <td id=\"20\">20<br><b><font size=\"+1\">Ca</font></b><br>Calcium<br>40,06</td>\n"
			  		+ "     <td id=\"21\">21<br><b><font size=\"+1\">Sc</font></b><br>Scandium<br>44,956</td>\n"
			  		+ "     <td id=\"22\">22<br><b><font size=\"+1\">Ti</font></b><br>Titanium<br>47,90</td>\n"
			  		+ "     <td id=\"23\">23<br><b><font size=\"+1\">V</font></b><br>Vanadium<br>50,941</td>\n"
			  		+ "     <td id=\"24\">24<br><b><font size=\"+1\">Cr</font></b><br>Chromium<br>51,996</td>\n"
			  		+ "     <td id=\"25\">25<br><b><font size=\"+1\">Mn</font></b><br>Manganum<br>54,9380</td>\n"
			  		+ "     <td id=\"26\">26<br><b><font size=\"+1\">Fe</font></b><br>Ferrum<br>55,847</td>\n"
			  		+ "     <td id=\"27\">27<br><b><font size=\"+1\">Co</font></b><br>Cobaltum<br>58,9332</td>\n"
			  		+ "     <td id=\"28\">28<br><b><font size=\"+1\">Ni</font></b><br>Niccolum<br>58,70</td>\n"
			  		+ "     <td id=\"29\">29<br><b><font size=\"+1\">Cu</font></b><br>Cuprum<br>63,546</td>\n"
			  		+ "     <td id=\"30\">30<br><b><font size=\"+1\">Zn</font></b><br>Zincum<br>65,38</td>\n"
			  		+ "     <td id=\"31\">31<br><b><font size=\"+1\">Ga</font></b><br>Gallium<br>69,72</td>\n"
			  		+ "     <td id=\"32\">32<br><b><font size=\"+1\">Ge</font></b><br>Germanium<br>72,59</td>\n"
			  		+ "     <td id=\"33\">33<br><b><font size=\"+1\">As</font></b><br>Arsenicum<br>74,9216</td>\n"
			  		+ "     <td id=\"34\">34<br><b><font size=\"+1\">Se</font></b><br>Selenium<br>78,96</td>\n"
			  		+ "     <td id=\"35\">35<br><b><font size=\"+1\">Br</font></b><br>Bromum<br>78,96</td>\n"
			  		+ "     <td id=\"36\">36<br><b><font size=\"+1\">Kr</font></b><br>Krypton<br>83,80 </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td>5</td>\n"
			  		+ "     <td id=\"37\">37<br><b><font size=\"+1\">Rb</font></b><br>Rubidium<br>85,4678</td>\n"
			  		+ "     <td id=\"38\">38<br><b><font size=\"+1\">Sr</font></b><br>Strontium<br>86,72</td>\n"
			  		+ "     <td id=\"39\">39<br><b><font size=\"+1\">Y</font></b><br>Yttrium<br>88,906</td>\n"
			  		+ "     <td id=\"40\">40<br><b><font size=\"+1\">Zr</font></b><br>Zirconium<br>91,22</td>\n"
			  		+ "     <td id=\"41\">41<br><b><font size=\"+1\">Nb</font></b><br>Niobium<br>92,906</td>\n"
			  		+ "     <td id=\"42\">42<br><b><font size=\"+1\">Mo</font></b><br>Molybdaenum<br>95,94</td>\n"
			  		+ "     <td id=\"43\">43<br><b><font size=\"+1\">Tc</font></b><br>Technetium<br>97,9072</td>\n"
			  		+ "     <td id=\"44\">44<br><b><font size=\"+1\">Ru</font></b><br>Ruthenium<br>101,07</td>\n"
			  		+ "     <td id=\"45\">45<br><b><font size=\"+1\">Rh</font></b><br>Rhodium<br>102,905</td>\n"
			  		+ "     <td id=\"46\">46<br><b><font size=\"+1\">Pd</font></b><br>Palladium<br>106,4</td>\n"
			  		+ "     <td id=\"47\">47<br><b><font size=\"+1\">Ag</font></b><br>Argentum<br>107,868</td>\n"
			  		+ "     <td id=\"48\">48<br><b><font size=\"+1\">Cd</font></b><br>Cadmium<br>112,40</td>\n"
			  		+ "     <td id=\"49\">49<br><b><font size=\"+1\">In</font></b><br>Indium<br>114,82</td>\n"
			  		+ "     <td id=\"50\">50<br><b><font size=\"+1\">Sn</font></b><br>Stannum<br>118,69</td>\n"
			  		+ "     <td id=\"51\">51<br><b><font size=\"+1\">Sb</font></b><br>Stibium<br>121,75</td>\n"
			  		+ "     <td id=\"52\">52<br><b><font size=\"+1\">Te</font></b><br>Tellurium<br>127,75</td>\n"
			  		+ "     <td id=\"53\">53<br><b><font size=\"+1\">I</font></b><br>Iodum<br>126,9045</td>\n"
			  		+ "     <td id=\"54\">54<br><b><font size=\"+1\">Xe</font></b><br>Xenon<br>131,30 </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td>6</td>\n"
			  		+ "     <td id=\"55\">55<br><b><font size=\"+1\">Cs</font></b><br>Caesium<br>132,905</td>\n"
			  		+ "     <td id=\"56\">56<br><b><font size=\"+1\">Ba</font></b><br>Barium<br>137,34</td>\n"
			  		+ "     <td id=\"57\">57<br><b><font size=\"+1\">La*</font></b><br>Lanthanum<br>138,9055</td>\n"
			  		+ "     <td id=\"72\">72<br><b><font size=\"+1\">Hf</font></b><br>Hafnium<br>178,49</td>\n"
			  		+ "     <td id=\"73\">73<br><b><font size=\"+1\">Ta</font></b><br>Tantalum<br>180,948</td>\n"
			  		+ "     <td id=\"74\">74<br><b><font size=\"+1\">W</font></b><br>Wolframium<br>183,85</td>\n"
			  		+ "     <td id=\"75\">75<br><b><font size=\"+1\">Re</font></b><br>Rhenium<br>186,207</td>\n"
			  		+ "     <td id=\"76\">76<br><b><font size=\"+1\">Os</font></b><br>Osmium<br>190,2</td>\n"
			  		+ "     <td id=\"77\">77<br><b><font size=\"+1\">Ir</font></b><br>Iridium<br>192,22</td>\n"
			  		+ "     <td id=\"78\">78<br><b><font size=\"+1\">Pt</font></b><br>Platinum<br>195,09</td>\n"
			  		+ "     <td id=\"79\">79<br><b><font size=\"+1\">Au</font></b><br>Aurum<br>196,9665</td>\n"
			  		+ "     <td id=\"80\">80<br><b><font size=\"+1\">Hg</font></b><br>Hydrargyrum<br>200,59</td>\n"
			  		+ "     <td id=\"81\">81<br><b><font size=\"+1\">Tl</font></b><br>Thallium<br>204,37</td>\n"
			  		+ "     <td id=\"82\">82<br><b><font size=\"+1\">Pb</font></b><br>Plumbum<br>207,2</td>\n"
			  		+ "     <td id=\"83\">83<br><b><font size=\"+1\">Bi</font></b><br>Bismuthum<br>208,98</td>\n"
			  		+ "     <td id=\"84\">84<br><b><font size=\"+1\">Po</font></b><br>Polonium<br>208,9824</td>\n"
			  		+ "     <td id=\"85\">85<br><b><font size=\"+1\">At</font></b><br>Astatum<br>209,9871</td>\n"
			  		+ "     <td id=\"86\">86<br><b><font size=\"+1\">Rn</font></b><br>Radon<br>222,0176 </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td>7</td>\n"
			  		+ "     <td id=\"87\">87<br><b><font size=\"+1\">Fr</font></b><br>Francium<br>223,0197</td>\n"
			  		+ "     <td id=\"88\">88<br><b><font size=\"+1\">Ra</font></b><br>Radium<br>226,0254</td>\n"
			  		+ "     <td id=\"89\">89<br><b><font size=\"+1\">Ac**</font></b><br>Actinium<br>227,0278</td>\n"
			  		+ "     <td id=\"104\">104<br><b><font size=\"+1\">Rf</font></b><br>Rutherfordium<br>[261]</td>\n"
			  		+ "     <td id=\"105\">105<br><b><font size=\"+1\">Db</font></b><br>Dubnium<br>[268]</td>\n"
			  		+ "     <td id=\"106\">106<br><b><font size=\"+1\">Sg</font></b><br>Seaborgium<br>[271]</td>\n"
			  		+ "     <td id=\"107\">107<br><b><font size=\"+1\">Bh</font></b><br>Bohrium<br>[272]</td>\n"
			  		+ "     <td id=\"108\">108<br><b><font size=\"+1\">Hs</font></b><br>Hassium<br>[275]</td>\n"
			  		+ "     <td id=\"109\">109<br><b><font size=\"+1\">Mt</font></b><br>Meitnerium<br>[278]</td>\n"
			  		+ "     <td id=\"110\">110<br><b><font size=\"+1\">Ds</font></b><br>Darmstadtium<br>[281]</td>\n"
			  		+ "     <td id=\"111\">111<br><b><font size=\"+1\">Rg</font></b><br>Roentgenium<br>[282]</td>\n"
			  		+ "     <td id=\"112\">112<br><b><font size=\"+1\">Cn</font></b><br>Copernicium<br>[285]</td>\n"
			  		+ "     <td id=\"113\">113<br><b><font size=\"+1\">Nh</font></b><br>Nihonium<br>[286]</td>\n"
			  		+ "     <td id=\"114\">114<br><b><font size=\"+1\">Fl</font></b><br>Flerovium<br>[289]</td>\n"
			  		+ "     <td id=\"115\">115<br><b><font size=\"+1\">Mc</font></b><br>Moscovium<br>[289]</td>\n"
			  		+ "     <td id=\"116\">116<br><b><font size=\"+1\">Lv</font></b><br>Livermorium<br>[293]</td>\n"
			  		+ "     <td id=\"117\">117<br><b><font size=\"+1\">Ts</font></b><br>Tennessine<br>[294]</td>\n"
			  		+ "     <td id=\"118\">118<br><b><font size=\"+1\">Og</font></b><br>Oganesson<br>[294] </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td></td>\n"
			  		+ "     <td>1</td>\n"
			  		+ "     <td>2</td>\n"
			  		+ "     <td>3</td>\n"
			  		+ "     <td>4</td>\n"
			  		+ "     <td>5</td>\n"
			  		+ "     <td>6</td>\n"
			  		+ "     <td>7</td>\n"
			  		+ "     <td>8</td>\n"
			  		+ "     <td>9</td>\n"
			  		+ "     <td>10</td>\n"
			  		+ "     <td>11</td>\n"
			  		+ "     <td>12</td>\n"
			  		+ "     <td>13</td>\n"
			  		+ "     <td>14</td>\n"
			  		+ "     <td>15</td>\n"
			  		+ "     <td>16</td>\n"
			  		+ "     <td>17</td>\n"
			  		+ "     <td>18 </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td colspan=\"4\">Lanthanides*</td>\n"
			  		+ "     <td id=\"58\">58<br><b><font size=\"+1\">Ce</font></b><br>Cerium<br>140,12</td>\n"
			  		+ "     <td id=\"59\">59<br><b><font size=\"+1\">Pr</font></b><br>Praseodymium<br>140,9077</td>\n"
			  		+ "     <td id=\"60\">60<br><b><font size=\"+1\">Nd</font></b><br>Neodymium<br>144,24</td>\n"
			  		+ "     <td id=\"61\">61<br><b><font size=\"+1\">Pm</font></b><br>Promethium<br>144,9127</td>\n"
			  		+ "     <td id=\"62\">62<br><b><font size=\"+1\">Sm</font></b><br>Samarium<br>150,36</td>\n"
			  		+ "     <td id=\"63\">63<br><b><font size=\"+1\">Eu</font></b><br>Europium<br>151,96</td>\n"
			  		+ "     <td id=\"64\">64<br><b><font size=\"+1\">Gd</font></b><br>Gadolinium<br>157,25</td>\n"
			  		+ "     <td id=\"65\">65<br><b><font size=\"+1\">Tb</font></b><br>Terbium<br>158,9254</td>\n"
			  		+ "     <td id=\"66\">66<br><b><font size=\"+1\">Dy</font></b><br>Dysprosium<br>162,50</td>\n"
			  		+ "     <td id=\"67\">67<br><b><font size=\"+1\">Ho</font></b><br>Holmium<br>164,9304</td>\n"
			  		+ "     <td id=\"68\">68<br><b><font size=\"+1\">Er</font></b><br>Erbium<br>167,27</td>\n"
			  		+ "     <td id=\"69\">69<br><b><font size=\"+1\">Tm</font></b><br>Thulium<br>168,9342</td>\n"
			  		+ "     <td id=\"70\">70<br><b><font size=\"+1\">Yb</font></b><br>Ytterbium<br>173,04</td>\n"
			  		+ "     <td id=\"71\">71<br><b><font size=\"+1\">Lu</font></b><br>Lutetium<br>174,97</td>\n"
			  		+ "     <td> </td>\n"
			  		+ "    </tr>\n"
			  		+ "    <tr align=\"center\">\n"
			  		+ "     <td colspan=\"4\">Actinides**</td>\n"
			  		+ "     <td id=\"90\">90<br><b><font size=\"+1\">Th</font></b><br>Thorium<br>232,0381</td>\n"
			  		+ "     <td id=\"91\">91<br><b><font size=\"+1\">Pa</font></b><br>Thorium<br>231,0359</td>\n"
			  		+ "     <td id=\"92\">92<br><b><font size=\"+1\">U</font></b><br>Uranium<br>238,029</td>\n"
			  		+ "     <td id=\"93\">93<br><b><font size=\"+1\">Np</font></b><br>Neptunium<br>237,0482</td>\n"
			  		+ "     <td id=\"94\">94<br><b><font size=\"+1\">Pu</font></b><br>Plutonium<br>244,0642</td>\n"
			  		+ "     <td id=\"95\">95<br><b><font size=\"+1\">Am</font></b><br>Americium<br>243,0614</td>\n"
			  		+ "     <td id=\"96\">96<br><b><font size=\"+1\">Cm</font></b><br>Curium<br>247,0703</td>\n"
			  		+ "     <td id=\"97\">97<br><b><font size=\"+1\">Bk</font></b><br>Berkelium<br>247,0703</td>\n"
			  		+ "     <td id=\"98\">98<br><b><font size=\"+1\">Cf</font></b><br>Californium<br>251,0796</td>\n"
			  		+ "     <td id=\"99\">99<br><b><font size=\"+1\">Es</font></b><br>Einsteinium<br>252,083</td>\n"
			  		+ "     <td id=\"100\">100<br><b><font size=\"+1\">Fm</font></b><br>Fermium<br>257,0951</td>\n"
			  		+ "     <td id=\"101\">101<br><b><font size=\"+1\">Md</font></b><br>Mendelevium<br>258,1</td>\n"
			  		+ "     <td id=\"102\">102<br><b><font size=\"+1\">No</font></b><br>Nobelium<br>259,1009</td>\n"
			  		+ "     <td id=\"103\">103<br><b><font size=\"+1\">Lr</font></b><br>Lawrencium<br>[266]</td>\n"
			  		+ "     <td> </td>\n"
			  		+ "    </tr>\n"
			  		+ "   </tbody>\n"
			  		+ "  </table>  \n"
			  		+ " </body>\n"
			  		+ "</html>";*/
/*			  FileWriter writer = new FileWriter(path);
		      writer.write(html);
		      writer.close();
		      reader.close();*/
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}

}
