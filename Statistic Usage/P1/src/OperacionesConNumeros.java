/**
 * La clase imprime y maneja todo el menu de la opcion Operations on Numbers asi
 * como los datos que las funciones del este menu utilizan.
 * 
 * @author Kevin
 *
 */
public class OperacionesConNumeros {
	private static OperacionesConNumeros instanciaUnica = null;

	private MenuCentral menu;
	private ManejoDeMenuNumeros manejoNumeros;

	private static int conteoCuadratica;
	private static int conteoPromedio;

	int verificacion1 = 0;
	int verificacion2 = 0;

	/**
	 * Crea un objeto OperacionesConNumeros vacio.
	 */
	private OperacionesConNumeros() {
	}

	/**
	 * @return constructor de OperacionesConNumeros
	 */
	public static OperacionesConNumeros mostrarMenuNumeros() {
		if (instanciaUnica == null) {
			instanciaUnica = new OperacionesConNumeros();
			String menuNumeros = "\nOperations on Numebers Menu: "
					+ "\n\t1> Process Quadratic Equation"
					+ "\n\t2> Compute Average of List of Numbers"
					+ "\n\t3> Exit Program\n";

			instanciaUnica.menu = new MenuCentral(menuNumeros, 3, 3);
		}
		return instanciaUnica;
	}

	/**
	 * 
	 * @return conteoCuadratica es la cantidad de veces que usuario ha utlizado
	 *         la opcion Process Quadratic Equation.
	 */
	public static int getConteoCuadratica() {
		return conteoCuadratica;
	}

	/**
	 * 
	 * @return conteoPromedio es la cantidad de veces que usuario ha utlizado la
	 *         opcion Compute Average of List of Numbers.
	 */
	public static int getConteoPromedio() {
		return conteoPromedio;
	}

	/**
	 * El metodo imprime y maneja los datos que se envian y se reciben de las
	 * distintas funciones que se realizan en la clase
	 * {@link ManejoDeMenuNumeros}.
	 */
	public void ejecutar() {
		boolean salir = false;
		do {
			menu.mostrar();
			int seleccion = menu.leerSeleccionDelUsuario();
			if (seleccion == 0) {
				salir = true;
			} else if (seleccion == 1) {
				if (verificacion1 != 1) {
					verificacion1 = 1;
					conteoCuadratica = 0;
				}
				conteoCuadratica++;

				manejoNumeros = new ManejoDeMenuNumeros();
				manejoNumeros.leerCoeficientes();

			} else if (seleccion == 2) {
				if (verificacion2 != 1) {
					verificacion2 = 1;
					conteoPromedio = 0;
				}
				conteoPromedio++;

				manejoNumeros = new ManejoDeMenuNumeros();
				manejoNumeros.leerListaDeNumeros();
				
			} else if (seleccion == 3) {
				salir = true;
			}
		} while (!salir);
	}
}
