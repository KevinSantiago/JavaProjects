import java.util.Scanner;

/**
 * La clase tiene las operaciones de leer e imprimir que el programa utiliza y
 * ejecuta los submenus del menu principal.
 *
 */
public class Herramientas {
	private final static Scanner scan = new Scanner(System.in);

	/**
	 * El metodo imprime una cadena de caracteres.
	 * 
	 * @param s
	 *            es una cadena de caracteres cualquiera
	 */
	public static void println(String s) {
		System.out.println(s);
	}

	/**
	 * 
	 * @return scan.NextInt() es el operador para leer un entero
	 */
	public static int leerEntero() {
		return scan.nextInt();
	}

	/**
	 * 
	 * @return scan.nextFloat() es el operador para leer una fraccion
	 */
	public static float leerFloat() {
		return scan.nextFloat();
	}

	/**
	 * 
	 * @return scan.nextLine() es el operador para leer una linea
	 */
	public static String leerString() {
		return scan.nextLine();
	}

	/**
	 * El metodo crea un objeto OperacionesConNumeros y lo ejecuta.
	 */
	public static void operacionConNumeros() {
		OperacionesConNumeros opcionesNumeros = OperacionesConNumeros
				.mostrarMenuNumeros();
		opcionesNumeros.ejecutar();
	}

	/**
	 * El metodo crea un objeto OperacionesConStrings y lo ejecuta.
	 */
	public static void operacionConStrings() {
		OperacionesConStrings opcionesNumeros = OperacionesConStrings
				.mostrarMenuStrings();
		opcionesNumeros.ejecutar();
	}

	/**
	 * El metodo crea un objeto EstadisticasDeUso y lo ejecuta.
	 */
	public static void estadisticasDeUso() {
		EstadisticasDeUso estadisticasDeUso = EstadisticasDeUso.estadistica();
		estadisticasDeUso.ejecutar();
	}
}
