package scientia.periodic_table_editor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelTable implements Table{
	//Создание xlsx таблицы
	String path;
	@Override
	public void Create(String type, String path) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Elements");
        final Object[][] elements = {
                {"Z", "Symbol", "Latin", "English", "Estonian", "Russian", "Colour", "HEX", "Formula"},
                {1, "H", "Hydrogenium", "Hydrogen","Vesinik","Водород"},
                {2, "He", "Helium",	"Helium", "Heelium", "Гелий"},
                {3, "Li", "Lithium", "Lithium", "Liitium", "Литий"},
                {4, "Be", "Beryllium", "Beryllium",	"Berüllium", "Бериллий"},
                {5, "B", "Borum", "Boron", "Boor", "Бор"},
                {6, "C", "Carboneum", "Carbon", "Süsinik", "Углерод"},
                {7, "N", "Nitrogenium", "Nitrogen", "Lämmastik", "Азот"},
                {8, "O", "Oxygenium", "Oxygen", "Hapnik", "Кислород"},
                {9, "F", "Fluorum", "Fluorine", "Fluor", "Фтор"},
                {10, "Ne", "Neon", "Neon", "Neoon",	"Неон"},
                {11, "Na", "Natrium", "Sodium", "Naatrium", "Натрий"},
                {12, "Mg", "Magnesium", "Magnesium", "Magneesium", "Магний"},
                {13, "Al", "Aluminium", "Aluminium", "Alumiinium", "Алюминий"},
                {14, "Si", "Silicium", "Silicon", "Räni", "Кремний"},
                {15, "P", "Phosphorus", "Phosphorus", "Fosfor", "Фосфор"},
                {16, "S", "Sulphur", "Sulfur", "Väävel", "Сера"},
                {17, "Cl", "Chlorum", "Chlorine", "Kloor", "Хлор"},
                {18, "Ar", "Argon", "Argon", "Argoon", "Аргон"},
                {19, "K", "Kalium", "Potassium", "Kaalium",	"Калий"},
                {20, "Ca", "Calcium", "Calcium", "Kaltsium", "Кальций"},
                {21, "Sc", "Scandium", "Scandium", "Skandium", "Скандий"},
                {22, "Ti", "Titanium", "Titanium", "Titaan", "Титан"},
                {23, "V", "Vanadium", "Vanadium", "Vanaadium", "Ванадий"},
                {24, "Cr", "Chromium", "Chromium", "Kroom", "Хром"},
                {25, "Mn", "Manganum", "Manganese", "Mangaan", "Марганец"},
                {26, "Fe", "Ferrum", "Iron", "Raud", "Железо"},
                {27, "Co", "Cobaltum", "Cobalt", "Koobalt", "Кобальт"},
                {28, "Ni", "Niccolum", "Nickel", "Nikkel", "Никель"},
                {29, "Cu", "Cuprum", "Copper", "Vask", "Медь"},
                {30, "Zn", "Zincum", "Zinc", "Tsink", "Цинк"},
                {31, "Ga", "Gallium", "Gallium", "Gallium", "Галлий"},
                {32, "Ge", "Germanium", "Germanium", "Germaanium", "Германий"},
                {33, "As", "Arsenicum", "Arsenic", "Arseen", "Мышьяк"},
                {34, "Se", "Selenium", "Selenium", "Seleen", "Селен"},
                {35, "Br", "Bromum", "Bromine", "Broom", "Бром"},
                {36, "Kr", "Krypton, Crypton", "Krypton", "Krüptoon", "Криптон"},
                {37, "Rb", "Rubidium", "Rubidium", "Rubiidium", "Рубидий"},
                {38, "Sr", "Strontium", "Strontium", "Strontsium", "Стронций"},
                {39, "Y", "Yttrium", "Yttrium", "Ütrium", "Иттрий"},
                {40, "Zr", "Zirconium", "Zirconium", "Tsirkoonium", "Цирконий"},
                {41, "Nb", "Niobium", "Niobium", "Nioobium", "Ниобий"},
                {42, "Mo", "Molybdaenum", "Molybdenum", "Molübdeen", "Молибден"},
                {43, "Tc", "Technetium", "Technetium", "Tehneetsium", "Технеций"},
                {44, "Ru", "Ruthenium", "Ruthenium", "Ruteenium", "Рутений"},
                {45, "Rh", "Rhodium", "Rhodium", "Roodium",	"Родий"},
                {46, "Pd", "Palladium", "Palladium", "Pallaadium", "Палладий"},
                {47, "Ag", "Argentum", "Silver", "Hõbe", "Серебро"},
                {48, "Cd", "Cadmium", "Cadmium", "Kaadmium", "Кадмий"},
                {49, "In", "Indium", "Indium", "Indium", "Индий"},
                {50, "Sn", "Stannum", "Tin", "Tina", "Олово"},
                {51, "Sb", "Stibium", "Antimony", "Antimon", "Сурьма"},
                {52, "Te", "Tellurium", "Tellurium", "Telluur", "Теллур"},
                {53, "I", "Iodum", "Iodine", "Jood", "Йод"},
                {54, "Xe", "Xenon", "Xenon", "Ksenoon", "Ксенон"},
                {55, "Cs", "Caesium", "Caesium", "Tseesium", "Цезий"},
                {56, "Ba", "Barium", "Barium", "Baarium", "Барий"},
                {57, "La", "Lanthanum", "Lanthanum", "Lantaan", "Лантан"},
                {58, "Ce", "Cerium", "Cerium", "Tseerium", "Церий"},
                {59, "Pr", "Praseodymium", "Praseodymium", "Praseodüüm", "Празеодим"},
                {60, "Nd", "Neodymium", "Neodymium", "Neodüüm", "Неодим"},
                {61, "Pm", "Promethium", "Promethium", "Promeetium", "Прометий"},
                {62, "Sm", "Samarium", "Samarium", "Samaarium", "Самарий"},
                {63, "Eu", "Europium", "Europium", "Euroopium",	"Европий"},
                {64, "Gd", "Gadolinium", "Gadolinium", "Gadoliinium", "Гадолиний"},
                {65, "Tb", "Terbium", "Terbium", "Terbium", "Тербий"},
                {66, "Dy", "Dysprosium", "Dysprosium", "Düsproosium", "Диспрозий"},
                {67, "Ho", "Holmium", "Holmium", "Holmium", "Гольмий"},
                {68, "Er", "Erbium", "Erbium", "Erbium", "Эрбий"},
                {69, "Tm", "Thulium", "Thulium", "Tuulium", "Тулий"},
                {70, "Yb", "Ytterbium", "Ytterbium", "Üterbium", "Иттербий"},
                {71, "Lu", "Lutetium", "Lutetium", "Luteetsium", "Лютеций"},
                {72, "Hf", "Hafnium", "Hafnium", "Hafnium", "Гафний"},
                {73, "Ta", "Tantalum", "Tantalum", "Tantaal", "Тантал"},
                {74, "W", "Wolframium", "Tungsten", "Volfram", "Вольфрам"},
                {75, "Re", "Rhenium", "Rhenium", "Reenium", "Рений"},
                {76, "Os", "Osmium", "Osmium", "Osmium", "Осмий"},
                {77, "Ir", "Iridium", "Iridium", "Iriidium", "Иридий"},
                {78, "Pt", "Platinum", "Platinum", "Plaatina", "Платина"},
                {79, "Au", "Aurum", "Gold", "Kuld", "Золото"},
                {80, "Hg", "Hydrargyrum", "Mercury", "Elavhõbe", "Ртуть"},
                {81, "Tl", "Thallium", "Thallium", "Tallium", "Таллий"},
                {82, "Pb", "Plumbum", "Lead", "Plii", "Свинец"},
                {83, "Bi", "Bismuthum", "Bismuth", "Vismut", "Висмут"},
                {84, "Po", "Polonium", "Polonium", "Poloonium", "Полоний"},
                {85, "At", "Astatum", "Astatine", "Astaat",	"Астат"},
                {86, "Rn", "Radon", "Radon", "Radoon", "Радон",},
                {87, "Fr", "Francium", "Francium", "Frantsium", "Франций"},
                {88, "Ra", "Radium", "Radium", "Raadium", "Радий"},
                {89, "Ac", "Actinium", "Actinium", "Aktiinium", "Актиний"},
                {90, "Th", "Thorium", "Thorium", "Toorium", "Торий"},
                {91, "Pa", "Protactinium", "Protactinium", "Protaktiinium", "Протактиний"},
                {92, "U", "Uranium", "Uranium", "Uraan", "Уран"},
                {93, "Np", "Neptunium", "Neptunium", "Neptuunium", "Нептуний"},
                {94, "Pu", "Plutonium", "Plutonium", "Plutoonium", "Плутоний"},
                {95, "Am", "Americium", "Americium", "Ameriitsium", "Америций"},
                {96, "Cm", "Curium", "Curium", "Kuurium", "Кюрий"},
                {97, "Bk", "Berkelium", "Berkelium", "Berkeelium", "Берклий"},
                {98, "Cf", "Californium", "Californium", "Kalifornium", "Калифорний"},
                {99, "Es", "Einsteinium", "Einsteinium", "Einsteinium", "Эйнштейний"},
                {100, "Fm", "Fermium", "Fermium", "Fermium", "Фермий"},
                {101, "Md", "Mendelevium", "Mendelevium", "Mendeleevium", "Менделевий"},
                {102, "No", "Nobelium", "Nobelium", "Nobeelium", "Нобелий"},
                {103, "Lr", "Lawrencium", "Lawrencium", "Lavrentsium", "Лоуренсий"},
                {104, "Rf", "Rutherfordium", "Rutherfordium", "Rutherfordium", "Резерфордий"},
                {105, "Db", "Dubnium", "Dubnium", "Dubnium", "Дубний"},
                {106, "Sg", "Seaborgium", "Seaborgium", "Seaborgium", "Сиборгий"},
                {107, "Bh", "Bohrium", "Bohrium", "Bohrium", "Борий"},
                {108, "Hs", "Hassium", "Hassium", "Hassium", "Хассий"},
                {109, "Mt", "Meitnerium", "Meitnerium", "Meitneerium", "Мейтнерий"},
                {110, "Ds", "Darmstadtium", "Darmstadtium", "Darmstadtium", "Дармштадтий"},
                {111, "Rg", "Roentgenium", "Roentgenium", "Röntgeenium", "Рентгений"},
                {112, "Cn", "Copernicium", "Coperniciu", "Koperniikium", "Коперниций"},
                {113, "Nh", "Nihonium", "Nihonium", "Nihoonium", "Нихоний"},
                {114, "Fl", "Flerovium", "Flerovium", "Fleroovium", "Флеровий"},
                {115, "Mc", "Moscovium", "Moscovium", "Moskoovium", "Московий"},
                {116, "Lv", "Livermorium", "Livermorium", "Livermoorium", "Ливерморий"},
                {117, "Ts", "Tennessine", "Tennessine", "Tennessiin", "Теннессин"},
                {118, "Og", "Oganesson", "Oganesson", "Oganessoon", "Оганесон"}
        };
        //Если таблица математическая, то последний столбец(для формул) удаляется
        if (type.equals("math")){
        	elements[0][8]=null;
        }
        
        int rowNum = 0;
        
        //Преобразует объекты в ячейки таблицы
        for (Object[] element : elements) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : element) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}