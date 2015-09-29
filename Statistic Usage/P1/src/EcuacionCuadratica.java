/**
 * La clase encuentra las soluciones reales de la ecuacion cuadratica 
 * ax^2 + bx + c, si tiene alguna.
 * 
 * @author Kevin Santiago
 *
 */
public class EcuacionCuadratica {
	private float a;// Coeficiente de la variable elevada a la 2
	private float b;// Coeficiente de la variable elevada a la 1
	private float c;// Termino constante de la ecuacion cuadratica

	private String solucionesImaginarias;
	private float primeraSolucion;
	private float segundaSolucion;
	private int solucionesReales;

	/**
	 * Crea un objeto EcuacionCuadratica vacia.
	 */
	public EcuacionCuadratica() {
	}

	/**
	 * Crea una ecuacion cuadratica con los coeficientes especifcados.
	 * 
	 * @param a
	 *            coeficiente de la variable elevada a la 2
	 * @param b
	 *            coeficiente de la variable elevada a la 1
	 * @param c
	 *            termino constante
	 */
	public EcuacionCuadratica(float a, float b, float c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Calcula la cuadratica y añade la cantidad de soluciones reales que tiene
	 * la ecuacion cuadratica.
	 */
	public void determinante() {
		float determinante = b * b - 4 * a * c;

		if (determinante < 0)
			solucionesReales = 0;
		else if (determinante == 0)
			solucionesReales = 1;
		else
			solucionesReales = 2;
	}

	/**
	 * Calcula las soluciones reales, si tiene alguna.
	 */
	public void calcularCuadratica() {

		if (solucionesReales != 0) {
			primeraSolucion = (float) (-b + Math.sqrt((b * b) - (4 * a * c)))
					/ (2 * a);
			segundaSolucion = (float) (-b - Math.sqrt((b * b) - (4 * a * c)))
					/ (2 * a);
		} else
			solucionesImaginarias = "The quadratic equation "
					+ "does not has real solution.";

	}

	/**
	 * 
	 * @return primeraSolucion es una posible solucion de la ecuacion cuadratica
	 */
	public float getPrimeraSolucion() {
		return primeraSolucion;
	}

	/**
	 * 
	 * @return segundaaSolucion es una posible solucion de la ecuacion
	 *         cuadratica
	 */
	public float getSegundaSolucion() {
		return segundaSolucion;
	}

	/**
	 * 
	 * @return solucionesReales es la cantidad de soluciones reales que tiene la
	 *         ecuacion cuadratica
	 */
	public int getSolucionesReales() {
		return solucionesReales;
	}

	/**
	 * 
	 * @return solucionesImaginarias es el aviso que la ecuacion cuadratica no tiene soluciones reales
	 */
	public String getSolucionesImaginarias() {
		return solucionesImaginarias;
	}
}
