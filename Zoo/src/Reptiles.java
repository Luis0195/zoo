
public class Reptiles extends Animal {

	// Almacena el número de patas del reptil
	private int numPatas;
	// Variable que determina si el reptil es diurno o no (nocturno)
	private boolean diurno;
	// Almacena un dato sobre el reptil
	private String dato;

	// Constructor que inicializa las variables de la clase abstracta Animal
	// y las variables de la clase Reptiles
	public Reptiles(String nombre, int edad, String raza, int numPatas, boolean diurno) {
		// Se inicializan las variables de la superclase abstracta Animal
		super(nombre, edad, raza);

		this.numPatas = numPatas;
		this.diurno = diurno;
	}

	// Devuelve el número de patas del reptil
	// @return numPatas
	public int getNumPatas() {
		return numPatas;
	}

	// Cambia el número de patas al introducido por parámetro
	// @param numPatas
	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}

	// Devuelve el valor booleano del atributo diurno
	// @return diurno
	public boolean isDiurno() {
		return diurno;
	}

	// Cambia el valor booleano del atributo diurno al introducido por parámetro
	// @param diurno
	public void setDiurno(boolean diurno) {
		this.diurno = diurno;
	}

	// Devuelve el dato del reptil
	// @return dato
	public String getDato() {
		return dato;
	}

	// Cambia el dato del reptil al introducido por parámetro
	// @param dato
	public void setDato(String dato) {
		this.dato = dato;
	}

}
