
public class Felinos extends Animal {

	// Almacena el número de patas del felino
	private int numPatas;
	// Almacena el color del pelaje del felino
	private String colorPelaje;
	// Almacena un dato sobre el felino
	private String dato;

	// Constructor que inicializa las variables de la clase abstracta Animal
	// y las variables de la clase Felinos
	public Felinos(String nombre, int edad, String raza, int numPatas, String colorPelaje) {
		// Se inicializan las variables de la superclase abstracta Animal
		super(nombre, edad, raza);

		this.numPatas = numPatas;
		this.colorPelaje = colorPelaje;
	}

	// Devuelve el número de patas del felino
	// @return numPatas
	public int getNumPatas() {
		return numPatas;
	}

	// Cambia el número de patas del felino al recibido por parámetro
	// @param numPatas
	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}

	// Devuelve el color del pelaje del animal
	// @return colorPelaje
	public String getColorPelaje() {
		return colorPelaje;
	}

	// Cambia el color del pelaje del animal al recibido por parámetro
	// @param colorPelaje
	public void setColorPelaje(String colorPelaje) {
		this.colorPelaje = colorPelaje;
	}

	// Devuelve el dato del animal
	// @return dato
	public String getDato() {
		return dato;
	}

	// Cambia el dato del animal al recibido por parámetro
	// @param dato
	public void setDato(String dato) {
		this.dato = dato;
	}

}
