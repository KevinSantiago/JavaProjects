/**
 * La clase recibe una cadena de caracteres y reescribe la cadena de caracteres
 * pero alrevez.
 * 
 * @author Kevin Santiago
 *
 */
public class StringAlrevez {
	private String texto;
	private String textoAlrevez = "";

	/**
	 * Crea un objeto StringAlrevez con una especificacion.
	 * @param texto es una cadena de caracteres
	 */
	public StringAlrevez(String texto) {
		this.texto = texto;
	}

	/*
	 * El metodo coloca una cadena de caracteres alrevez.
	 */
	public String ponerTextoAlrevez() {
		for (int i = texto.length() - 1; i >= 0; i--) {
			textoAlrevez += texto.charAt(i);
		}
		return textoAlrevez;
	}
}
