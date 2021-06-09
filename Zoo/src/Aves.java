
public class Aves extends Animal {

	// Almacena el número de patas del ave
	private int numPatas;
	// Almacena el número de alas del ave
	private int numAlas;
	// Variable para determinar si el ave puede volar o no
	private boolean vuela;
	// Almacena un dato sobre el ave
	private String dato;

	// Constructor que inicializa las variables de la clase abstracta Animal
	// y las variables de la clase Aves
	public Aves(String nombre, int edad, String raza, int numPatas, int numAlas, boolean vuela) {
		// Se inicializan las variables de la superclase abstracta Animal
		super(nombre, edad, raza);

		this.numPatas = numPatas;
		this.numAlas = numAlas;
		this.vuela = vuela;
	}

	// Devuelve el número de patas del ave
	// @return numPatas
	public int getNumPatas() {
		return numPatas;
	}

	// Cambia el número de patas al introducido por parámetro
	// @param numPatas
	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}

	// Devuelve el número de alas del ave
	// @return numAlas
	public int getNumAlas() {
		return numAlas;
	}

	// Cambia el número de alas del ave al introducido por parámetro
	// @param numAlas
	public void setNumAlas(int numAlas) {
		this.numAlas = numAlas;
	}

	// Devuelve el valor del atributo vuela
	// @return vuela
	public boolean isVuela() {
		return vuela;
	}

	// Cambia el valor booleano vuela por el introducido por parámetro
	// @param vuela
	public void setVuela(boolean vuela) {
		this.vuela = vuela;
	}

	// Devuelve el dato del ave
	// @return ave
	public String getDato() {
		return dato;
	}

	// Cambia el dato del ave al introducido por parámetro
	// @param dato
	public void setDato(String dato) {
		this.dato = dato;
	}
}
