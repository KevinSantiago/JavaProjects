/**
 * La clase calcula el promedio de una suma dividida entre la cantidad de
 * numeros que compuso esa suma.
 * 
 * @author Kevin
 *
 */
public class Promedio {
	private float suma;
	private float promedio;
	private int cantidadDeNumeros;

	/**
	 * Crea un Promedio con las especificaciones.
	 * 
	 * @param suma 
	 * @param cantidadDeNumeros
	 */
	public Promedio(float suma, int cantidadDeNumeros) {
		this.suma = suma;
		this.cantidadDeNumeros = cantidadDeNumeros;
	}

	/**
	 * El metodo realiza la division de la suma sobre la cantidad de numeros.
	 * 
	 * @return promedio 
	 */
	public float calcularPromedio() {
		promedio = suma / cantidadDeNumeros;
		return promedio;
	}
}
