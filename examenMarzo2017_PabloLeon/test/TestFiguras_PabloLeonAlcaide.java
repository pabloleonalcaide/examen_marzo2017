package examenMarzo2017_PabloLeon.test;

import utiles.*;
import examenMarzo2017_PabloLeon.estructuras.Figuritas;
import examenMarzo2017_PabloLeon.excepciones.DimensionRidiculaException;
import examenMarzo2017_PabloLeon.excepciones.FiguraNoExisteException;
import examenMarzo2017_PabloLeon.excepciones.ListaVaciaException;

/**
 * 
 * @author Pablo Leon Alcaide
 *
 */
public class TestFiguras_PabloLeonAlcaide {

	static Figuritas figuritas = new Figuritas();
	static Menu menuPrincipal;
	static Menu menuAltas;
	static Menu altaConcreta;
	static Menu menuBajas;

	public static void main(String[] args) {
		menuPrincipal = new Menu("**General", new String[] { "Altas", "Bajas", "Listar" });
		do {
			switch (menuPrincipal.gestionar()) {
			case 1:
				alta();
				break;
			case 2:
				baja();
				break;
			case 3:
				try {
					listar();
				} catch (ListaVaciaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				return;
			}
		} while (true);

	}

	/**
	 * Menu que gestiona los tipos de listado: Total, Conteo de triangulos,
	 * Inverso
	 */
	private static void listar() throws ListaVaciaException {
		if (figuritas.isEmpty())
			throw new ListaVaciaException("La lista aun esta vacia");
		Menu menuListar = new Menu("**Listar", new String[] { "Todos", "Triangulos", "Del reves" });
		do {
			switch (menuListar.gestionar()) {
			case 1:
				System.out.println(figuritas.toString());
				break;
			case 2:
				System.out.println(figuritas.listaTriangulos());
				break;
			case 3:
				System.out.println(figuritas.listaInversa());
			case 4:
				return;
			}
		} while (true);
	}

	/**
	 * Menu que gestiona las bajas o eliminaciones de las figuras segun
	 * identificador o indice
	 */
	private static void baja() {
		menuBajas = new Menu("**BAJAS", new String[] { "Por identificador", "Por indice" });
		do {
			switch (menuBajas.gestionar()) {
			case 1:
				borrarPorIdentificador();
				break;
			case 2:
				borrarPorIndice();
				break;
			case 3:
				return;
			}
		} while (Teclado.leerSiNo("¿Desea eliminar otra figura? S/N"));
	}

	/**
	 * Elimina una figura en base a su indice dentro de la lista (va a variar al
	 * insertar/eliminar figuras)
	 */
	private static void borrarPorIndice() {
		for (int i = 0; i < figuritas.size(); i++) {
			System.out.println(i + ": " + figuritas.get(i));
		}
		int opcion = Teclado.leerEntero("elige figura a eliminar por indice:");
		System.out.println(figuritas.remove(opcion - 1));
	}

	/**
	 * Elimina una figura en base a un identificador propio de la figura, por lo
	 * que no varia
	 */
	private static void borrarPorIdentificador() {
		for (int i = 0; i < figuritas.size(); i++) {
			System.out.println(figuritas.get(i).getIdentificador() + ": " + figuritas.get(i));
		}
		try {
			System.out.println(
					figuritas.removeById(Teclado.leerEntero("elige la figura a eliminar por codigo identificador")));
		} catch (FiguraNoExisteException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Menu que gestiona la incorporacion de figuras a nuestra lista
	 */
	private static void alta() {
		menuAltas = new Menu("**ALTAS", new String[] { "masivas (dimensiones aleatorias, 3 de cada tipo)",
				"selectivas (dimensiones por teclado)" });
		do {
			try {
				switch (menuAltas.gestionar()) {
				case 1:
					System.out.println(figuritas.altaMasiva());
					break;
				case 2:
					altaConcreta();
					break;
				case 3:
					System.out.println("adios!");
					return;
				}
			} catch (DimensionRidiculaException e) {
				System.err.println(e.getMessage());
			}
		} while (true);

	}

	/**
	 * Menu que gestiona el tipo concreto de figura a eliminar
	 */
	private static void altaConcreta() throws DimensionRidiculaException {
		altaConcreta = new Menu("Selecciona figura a crear:",
				new String[] { "Rectangulo", "Cuadrado", "Triangulo", "Circunferencia" });
		do {
			switch (altaConcreta.gestionar()) {
			case 1:
				System.out.println(figuritas.addRectangulo(Teclado.leerDecimal("dame la base"),
						Teclado.leerDecimal("dame la altura")));
				break;
			case 2:
				System.out.println(figuritas.addCuadrado(Teclado.leerDecimal("dame el lado")));
				break;
			case 3:
				System.out.println(figuritas.addTriangulo(Teclado.leerDecimal("dame la base"),
						Teclado.leerDecimal("dame la altura")));
				break;
			case 4:
				System.out.println(figuritas.addCircunferencia(Teclado.leerDecimal("dame el radio")));
				break;
			case 5:
				return;
			}

		} while (true);
	}
}
