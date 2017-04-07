package examenMarzo2017_PabloLeon.figuras;

import examenMarzo2017_PabloLeon.excepciones.DimensionRidiculaException;

/**
 * 
 * @author Pablo Leon Alcaide
 *
 */
public abstract class FiguraCerrada {
	static final double DIMENSION_MINIMA = 0.5;
	private static int codigo = 1;
	private int identificador;

	/**
	 * @return perimetro de la figura (implementado en cada figura concreta)
	 */
	abstract double perimetro();

	/**
	 * @return area de la figura (implementado en cada figura concreta)
	 */
	abstract double area();

	// Constructor
	protected FiguraCerrada() throws DimensionRidiculaException {
		setIdentificador();
	}

	protected FiguraCerrada(int id) {
		this.identificador = id;
	}

	/**
	 * Asigna un identificador unico a cada figura que se crea en base a nuestra
	 * clave estatica.
	 */
	void setIdentificador() {
		this.identificador = codigo++;
	}

	public int getIdentificador() {
		return identificador;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ", codigo=" + identificador + ", perimetro: " + perimetro() + " area: "
				+ area() + "]";
	}
}
