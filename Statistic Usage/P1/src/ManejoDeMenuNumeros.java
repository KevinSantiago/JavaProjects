/**
 * La clase interactua con el usuario con respecto a la entrada y salida de
 * datos para poder ejecutar las clases {@link EcuacionCuadratica} y
 * {@link Promedio}.
 * 
 * @author Kevin Santiago
 *
 */
public class ManejoDeMenuNumeros {
	private EcuacionCuadratica cuadratica;
	private Promedio promedio;

	private float a;
	private float b;
	private float c;

	private float suma;
	private int cantidadDeNumeros;

	/**
	 * Crea un nuevo objeto ManejoMenuString vacio.
	 */
	public ManejoDeMenuNumeros() {
	}

	/**
	 * 
	 * @return suma es la suma de todos los numeros leidos.
	 */
	public float getSuma() {
		return suma;
	}

	/**
	 * 
	 * @return cantidadDeNumeros es la cantidad de numeros que el usuario entro.
	 */
	public int getCantidadDeNumeros() {
		return cantidadDeNumeros;
	}

	/**
	 * El metodo lee datos del usuario e imprime datos de la clase
	 * {@link EcuacionCuadratica}
	 */
	public void leerCoeficientes() {
		String respuesta = "The quadratic equation has real solution at:\n";
		Herramientas.println("Process Quadratic Equation." + '\n');
		Herramientas
				.println("This option is able to solve a quadratic equation in the standard form:");
		System.out.printf("ax%c + bx + c = 0\n", 178); // The character 178 is
														// superscript 2, for
														// representation of two
														// square
		Herramientas.println("Enter the coeficient a:");
		this.a = Herramientas.leerFloat();

		Herramientas.println("Enter the coeficient b:");
		this.b = Herramientas.leerFloat();

		Herramientas.println("Enter the coeficient c:");
		this.c = Herramientas.leerFloat();

		cuadratica = new EcuacionCuadratica(a, b, c);
		cuadratica.determinante();
		cuadratica.calcularCuadratica();
		int soluciones = cuadratica.getSolucionesReales();
		if (soluciones == 0) {
			Herramientas.println(cuadratica.getSolucionesImaginarias());
		} else if (soluciones == 1) {
			Herramientas.println(respuesta + "x = "
					+ cuadratica.getPrimeraSolucion());
		} else {
			Herramientas.println(respuesta + "x = "
					+ cuadratica.getPrimeraSolucion());

			Herramientas.println(respuesta + "x = "
					+ cuadratica.getSegundaSolucion());
		}
	}

	/**
	 * El metodo lee datos del usuario e imprime datos de la clase
	 * {@link Promedio}
	 */
	public void leerListaDeNumeros() {
		int decision;
		float listaDeNumeros;

		Herramientas
				.println("Enter a list of number to calculate the average.");
		do {
			Herramientas
					.println("Enter a number equal or greater than zeror: ");
			listaDeNumeros = Herramientas.leerFloat();
			while (listaDeNumeros < 0) {
				Herramientas.println("Invalid number.");
				Herramientas
						.println("Please enter a number equal or greater than zero: ");
				listaDeNumeros = Herramientas.leerFloat();
			}
			suma += listaDeNumeros;
			cantidadDeNumeros++;

			Herramientas.println("Want to enter another number?");
			Herramientas.println("1. yes \n2. no");
			decision = Herramientas.leerEntero();

			while (decision < 1 || decision > 2) {
				System.out.println("Invalid option.");
				System.out.println("Want to enter another number?");
				System.out.printf("1. yes" + "\n" + "2. no");
				decision = Herramientas.leerEntero();
			}
		} while (decision == 1);

		promedio = new Promedio(suma, cantidadDeNumeros);
		Herramientas.println("The average is : " + promedio.calcularPromedio());

	}
}
