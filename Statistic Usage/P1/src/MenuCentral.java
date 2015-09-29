/**
 * La clase imprime los menus en pantalla, lee la seleccion del usuario y se
 * asegura de que la seleccion sea correcta.
 * 
 * @author Kevin Santiago
 *
 */
public class MenuCentral {
	private int intentosMaximos;
	private int numeroDeOpciones;
	private String menu = null;
	private String estadistica = null;

	/**
	 * Crea un objeto MenuCentral con un menu y sus las especificaciones.
	 * 
	 * @param menu
	 *            son las opciones que el programa ofrece.
	 * @param opcionesMaximas
	 *            es la cantidad de opciones que tiene el menu
	 * @param intentosMaximos
	 *            es la cantidad de intentos que tiene el usuario para elegir
	 *            correctamente una opcion
	 */
	public MenuCentral(String menu, int opcionesMaximas, int intentosMaximos) {
		this.menu = menu;
		this.numeroDeOpciones = opcionesMaximas;
		this.intentosMaximos = intentosMaximos;
	}

	/**
	 * Crea un objeto MenuCentral con una estadistica.
	 * 
	 * @param estadistica
	 *            es la tabla de estadistica de uso del programa
	 */
	public MenuCentral(String estadistica) {
		this.estadistica = estadistica;
	}

	/**
	 * El metodo imprime la estadistica de uso del programa.
	 */
	public void mostrarEstadistica() {
		Herramientas.println(estadistica);
	}

	/**
	 * El metodo imprime el menu de opciones en pantalla.
	 */
	public void mostrar() {
		Herramientas.println(menu);
	}

	/**
	 * El metodo lee el numero de la opcion que el usuario desea accesar.
	 * 
	 * @return seleccion es el numero de la opcion
	 */
	public int leerSeleccionDelUsuario() {
		int seleccion;
		boolean valido = false;
		int intentos = intentosMaximos;
		int intentos1 = 0;
		System.out.println("Enter you selection:");
		seleccion = Herramientas.leerEntero();
		if (seleccion >= 1 && seleccion <= numeroDeOpciones)
			valido = true;
		intentos--;
		intentos1++;

		while (!valido && intentos1 < intentosMaximos) {
			Herramientas.println(intentos + " more tries");
			Herramientas.println("\nEnter a valid selection for this menu:");
			seleccion = Herramientas.leerEntero();
			if (seleccion >= 1 && seleccion <= numeroDeOpciones)
				valido = true;
			intentos--;
			intentos1++;
		}
		if (!valido)
			return 0;
		else
			return seleccion;
	}
}