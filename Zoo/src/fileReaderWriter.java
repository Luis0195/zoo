import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fileReaderWriter {

	//Creación de atributo de la clase FileWriter
	private FileWriter fw;
	//Creación de atributo de la clase FileReader
	private FileReader fr;
	//Creación de atributo de la clase File
	private File file;
	SimpleDateFormat date;
	SimpleDateFormat lineDate;

	//Se inicializan los atributos date y lineDate para obtener la fecha y hora actual.
	//Se invocan los métodos de la misma clase, createFileWriter y createFileReader-
	public fileReaderWriter() {
		date = new SimpleDateFormat("ddMMyy-hhmmss");
		lineDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		createFileWriter();
		createFileReader();
	}

	//Método que crea un archivo en el que apareza la hora y el día actual
	//e inicializa el atributo de la clase FileWriter en el archivo recién creado al inicializar file.
	//En caso de que file no se encuentre, lanzará un error diciendo eso mismo
	public void createFileWriter() {
		try {
			file = new File("logs\\" + date.format(new Date()) + "-log.txt");
			file.getParentFile().mkdirs();
			fw = new FileWriter(file);
		} catch (IOException ex) {
			System.out.println(ex + "Directorio no encontrado");
		}
	}

	//Método que inicializa el atributo de la clase FileReader y lee el archivo creado anteriormente.
	//Si no lo encuentra salta un error.
	public void createFileReader() {
		try {
			fr = new FileReader(file);
		} catch (IOException ex) {
			System.out.println(ex + "Archivo no encontrado");
		}
	}

	//Método que escribe línea a línea en el archivo de texto y lo guarda.
	public void writeFile(String line) {
		try {
			fw.write(lineDate.format(new Date()) + " " + line + "\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Lee el fichero.
	public String readFile() {
		String texto = "";
		try {
			int valor = fr.read();
			while (valor != -1) {
				texto = texto +((char) valor);
				valor = fr.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return texto;
	}

	//Cierra el fichero de escritura
	public void closeWirter() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Cierra el fichero de lectura
	public void closeReader() {
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
