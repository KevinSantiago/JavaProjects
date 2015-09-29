/**
 * La clase lee todos los datos que son cadena de caracteres y devolverlos
 * mediante un getter.
 * 
 * @author Kevin Santiago
 *
 */
public class ManejoMenuString {
	private String texto = null;
	private String patron = null;

	/**
	 * El metodo lee una cadena de caracteres.
	 */
	public void leerString() {
		Herramientas.println("Enter a string:");
		Herramientas.leerString();
		texto = Herramientas.leerString();
	}

	/**
	 * El metodo lee una cadena de caracteres x y -.
	 */
	public void leerPatron() {
		Herramientas.println("Enter a pattern of x and - only:");
		patron = Herramientas.leerString();
	}

	/**
	 * 
	 * @return texto es una cadena de caracteres 
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * 
	 * @return patron es una cadena de carracteres de x y -
	 */
	public String getPatron() {
		return patron;
	}
}
