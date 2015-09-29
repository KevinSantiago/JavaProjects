/**
 * La clase recibe una cadena de caracteres cualquiera y una compuesta de un
 * patron de 'x' y '-' y coloca los elementos de la cadena de caracteres en las
 * 'x' del patron.
 * 
 * @author Kevin Santiago
 *
 */
public class FormatoDeString {
	private String patron;
	private String texto;

	/**
	 * Crea un objeto FormatoDeString con las especificaciones.
	 * 
	 * @param texto
	 *            es una cadena de caracteres cualquiera
	 * @param patron
	 *            es una cadena de caracteres compuesta de 'x' y '-'
	 */
	public FormatoDeString(String texto, String patron) {
		this.texto = texto;
		this.patron = patron;
	}

	/**
	 * El metodo coloca la cadena de caracteres cualquiera y la coloca en las
	 * 'x' del patron.
	 * 
	 * @return patron es la cadena de caracteres cualquiera pero colocada en el
	 *         patron
	 */
	public String formatear() {
		int conteo = 0;
		String patron1 = "";
		for (int i = 0; i < patron.length(); i++) {
			if (patron.charAt(i) == 'x' || patron.charAt(i) == '-') {
				if (patron.charAt(i) == 'x' && conteo < texto.length()) {
					patron1 += texto.charAt(conteo);
					conteo++;
				} else if (patron.charAt(i) == '-' && conteo < texto.length()) {
					patron1 += patron.charAt(i);
				} else {
					patron1 += " ";
				}
			} else {
				patron = "An error occurred with the pattern entered";
				return patron;
			}
		}
		patron = patron1;
		return patron;
	}
}
