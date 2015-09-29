/**
 * La clase mantiene corriendo el programa hasta que la opcion de salir sea
 * elegida.
 * 
 * @author Kevin Santiago
 *
 */
public class OpcionesDelMenuCentral {
	private static OpcionesDelMenuCentral instanciaUnica = null;
	private MenuCentral menu;

	/**
	 * Crea un objeto OpcionesDelMenuCentral vacio.
	 */
	private OpcionesDelMenuCentral() {
	}

	/**
	 * Envia las opciones del menu principal a la clase {@link MenuCentral}
	 * 
	 * @return constructor de OpcionesDelMenuCentral
	 */
	public static OpcionesDelMenuCentral mostrarMenuPrincipal() {
		if (instanciaUnica == null) {
			instanciaUnica = new OpcionesDelMenuCentral();
			String menuPrincipal = "\nMain Menu: "
					+ "\n\t1> Perform Operations on Numbers"
					+ "\n\t2> Perform Operations on String"
					+ "\n\t3> Show Use Statistics" + "\n\t4> Exit Program\n";

			instanciaUnica.menu = new MenuCentral(menuPrincipal, 4, 3);
		}
		return instanciaUnica;
	}

	/**
	 * El metodo ejecuta el programa mientras la opcion de salir sea elegida.
	 */
	public void ejecutar() {
		boolean salir = false;
		do {
			menu.mostrar();
			int seleccion = menu.leerSeleccionDelUsuario();
			if (seleccion == 0) {
				Herramientas
						.println("You exceeded the maximun number of attempts.");
				salir = true;
			} else if (seleccion == 1) {
				Herramientas.operacionConNumeros();
			} else if (seleccion == 2) {
				Herramientas.operacionConStrings();
			} else if (seleccion == 3) {
				Herramientas.estadisticasDeUso();
			} else if (seleccion == 4) {
				salir = true;
			}
		} while (!salir);
	}
}
