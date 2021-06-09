
public class Caninos extends Animal {

	// Almacena el número de patas el canino
	private int numPatas;
	// Almacena el color del pelaje del canino
	private String colorPelaje;
	// Almacena un dato del canino
	private String dato;

	// Constructor que inicializa las variables de la clase abstracta Animal
	// y las variables de la clase Caninos
	public Caninos(String nombre, int edad, String raza, int numPatas, String colorPelaje) {
		// Se inicializan las variables de la superclase abstracta Animal
		super(nombre, edad, raza);

		this.numPatas = numPatas;
		this.colorPelaje = colorPelaje;
	}

	// Devuelve el número de patas del canino
	// @return numPatas
	public int getNumPatas() {
		return numPatas;
	}

	// Cambia el número de patas del canino al introducido por parámetro
	// @param numPatas
	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}

	// Devuelve el color del pelaje del canino
	// @return colorPelaje
	public String getColorPelaje() {
		return colorPelaje;
	}

	// Cambia el color del pelaje del canino al introducido por parámetro
	// @param colorPelaje
	public void setColorPelaje(String colorPelaje) {
		this.colorPelaje = colorPelaje;
	}

	// Devuelve el dato del canino
	// @return dato
	public String getDato() {
		return dato;
	}

	// Cambia el dato del canino al introducido por parámetro
	// @param dato
	public void setDato(String dato) {
		this.dato = dato;
	}
}
