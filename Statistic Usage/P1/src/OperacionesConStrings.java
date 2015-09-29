/**
 * La clase imprime y maneja todo el menu de la opcion Operations on Strings asi
 * como los datos que las funciones del este menu utilizan.
 * 
 * @author Kevin Santiago
 *
 */
public class OperacionesConStrings {
	private static OperacionesConStrings instanciaUnica = null;

	private ManejoMenuString manejoString;
	private StringAlrevez string;
	private FormatoDeString formato;
	private MenuCentral menu;

	private static int conteoTextoAlrevez;
	private static int conteoPatron;
	int verificacion1;
	int verificacion2;
 
	/**
	 * Crea un objeto OperacionesConStrings vacio. 
	 */
	private OperacionesConStrings() {
	}

	/**
	 * @return constructor de OperacionesConStrings.
	 */
	public static OperacionesConStrings mostrarMenuStrings() {
		if (instanciaUnica == null) {
			instanciaUnica = new OperacionesConStrings();
			String menuNumeros = "\nOperations on Strings Menu: "
					+ "\n\t1> Show Reverse of a Given String"
					+ "\n\t2> Format Strings" + "\n\t3> Exit Program\n";

			instanciaUnica.menu = new MenuCentral(menuNumeros, 3, 3);
		}
		return instanciaUnica;
	}

	/**
	 * 
	 * @return conteoTextoAlrevez es la cantidad de veces que usuario ha
	 *         utlizado la opcion Reverse a String.
	 */
	public static int getConteoTextoAlrevez() {
		return conteoTextoAlrevez;
	}

	/**
	 * 
	 * @return conteoPatrones la cantidad de veces que usuario ha utlizado la
	 *         opcion Format Strings.
	 */
	public static int getConteoPatron() {
		return conteoPatron;
	}

	/**
	 * El metodo imprime y maneja los datos que se envian y se reciben de las
	 * distintas funciones que se realizan en la clase {@link ManejoMenuString},
	 * {@link FormatoDeString} y {@link StringAlrevez}.
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
					conteoTextoAlrevez++;
				}
				conteoTextoAlrevez++;

				Herramientas.println("Reverse a string." + "\n");
				manejoString = new ManejoMenuString();
				manejoString.leerString();

				String texto = manejoString.getTexto();
				String textoAlrevez;

				string = new StringAlrevez(texto);
				textoAlrevez = string.ponerTextoAlrevez();

				Herramientas.println("\nThe string entered:\n" + texto);

				Herramientas
						.println("\nThe string reversed: \n" + textoAlrevez);

			} else if (seleccion == 2) {
				if (verificacion2 != 1) {
					verificacion2 = 1;
					conteoPatron++;
				}
				conteoPatron++;

				int opcion;
				manejoString = new ManejoMenuString();
				manejoString.leerString();
				manejoString.leerPatron();

				String texto = manejoString.getTexto();
				String patron = manejoString.getPatron();
				formato = new FormatoDeString(texto, patron);

				patron = formato.formatear();
				Herramientas.println("\nThe string entered:\n" + texto);
				Herramientas.println("\nThe string inside the pattern:\n"
						+ patron);

				do {
					Herramientas.println("\nWant to enter another pattern?");
					Herramientas.println("1.Yes\n2.No");
					opcion = Herramientas.leerEntero();
					while (opcion != 1 && opcion != 2) {
						Herramientas.println("\nInvalid option.");
						Herramientas.println("Want to enter another number?");
						Herramientas.println("1. yes" + "\n" + "2. no");
						opcion = Herramientas.leerEntero();
					}
					if (opcion == 1) {
						Herramientas.leerString();
						manejoString.leerPatron();
						patron = manejoString.getPatron();

						formato = new FormatoDeString(texto, patron);
						patron = formato.formatear();

						Herramientas.println("\nThe string entered:\n"
								+ manejoString.getTexto());

						Herramientas
								.println("\nThe string inside the pattern:\n"
										+ patron);
					}
				} while (opcion != 2);
			} else if (seleccion == 3) {
				salir = true;
			}
		} while (!salir);
	}
}
