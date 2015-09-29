/**
 * La clase EstadisticasDeUso regresa la tabla de uso del programa hasta el
 * momento en que el usuar selecciona esta opcion.
 * 
 * @author Kevin Santiago
 *
 */
public class EstadisticasDeUso {
	private static EstadisticasDeUso instanciaUnica = null;
	private static int conteoEstadistica = 0;

	private MenuCentral menu;

	/**
	 * Crea un objeto EstadisticasDeUso vacia.
	 * 
	 */
	private EstadisticasDeUso() {
	}

	/**
	 * Este metodo recive el conteo de uso de las distintas opciones del
	 * programa y las coloca en la tabla de estadisticas de uso
	 * 
	 * @return el constructor EstadisticasDeUso
	 */
	public static EstadisticasDeUso estadistica() {
		instanciaUnica = new EstadisticasDeUso();
		int cuadratica = OperacionesConNumeros.getConteoCuadratica();
		int promedio = OperacionesConNumeros.getConteoPromedio();
		int alrevez = OperacionesConStrings.getConteoTextoAlrevez();
		int patron = OperacionesConStrings.getConteoPatron();

		conteoEstadistica++;
		String division = "==================================";
		String espacio = "                    ";

		String estadistica = "\nStatistics of Use at the Moment.\n\n"
				+ "   Operation in the Program             Number of Times Executed\n"
				+ division + " " + division
				+ "\n   Process a Quadratic Equation " + espacio + cuadratica
				+ "\n   Compute Average of Numbers   " + espacio + promedio
				+ "\n   Reverse a String             " + espacio + alrevez
				+ "\n   Format a String              " + espacio + patron
				+ "\n   Show Statistics              " + espacio
				+ conteoEstadistica + "\n\n";

		instanciaUnica.menu = new MenuCentral(estadistica);
		return instanciaUnica;
	}

	/**
	 * El metodo llama la clase {@link MenuCentral} para imprimir la tabla de
	 * estadistica
	 */
	public void ejecutar() {
		menu.mostrarEstadistica();
	}
}
