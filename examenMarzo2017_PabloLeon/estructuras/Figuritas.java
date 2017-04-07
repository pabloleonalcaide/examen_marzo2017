package examenMarzo2017_PabloLeon.estructuras;

import java.util.ArrayList;
import java.util.ListIterator;

import examenMarzo2017_PabloLeon.excepciones.DimensionRidiculaException;
import examenMarzo2017_PabloLeon.excepciones.FiguraNoExisteException;
import examenMarzo2017_PabloLeon.figuras.*;

/**
 * 
 * @author Pablo Leon Alcaide
 *
 */
public class Figuritas {
	ArrayList<FiguraCerrada> figuritas;

	public Figuritas() {
		figuritas = new ArrayList<FiguraCerrada>();
	}

	/**
	 * Realiza una inserción masiva de figuras (3 elementos de cada tipo de
	 * figura)
	 * 
	 * @throws DimensionRidiculaException
	 */
	public String altaMasiva() throws DimensionRidiculaException {
		int contador = 0;
		for (int i = 0; i < 3; i++) {
			try {
				add(new Triangulo(Math.random() * 10 * (0.6), Math.random() * 10 * (0.6)));
				contador++;
				add(new Cuadrado(Math.random() * 10 * (0.6)));
				contador++;
				add(new Rectangulo(Math.random() * 10 * (0.6), Math.random() * 10 * (0.6)));
				contador++;
				add(new Circunferencia(Math.random() * 10 * (0.6)));
				contador++;
			} catch (DimensionRidiculaException e) {
				e.getMessage();

			}

		}
		return contador + " figuras";

	}

	/**
	 * introduce una figura indicada por parametro a la lista
	 * 
	 * @param figura
	 */
	public String add(FiguraCerrada figura) {
		if (!figuritas.contains(figura)) {
			figuritas.add(figura);
			return "figura anniadida";
		}
		return "ya existe dicha figura";
	}

	/**
	 * hace un simple recuento de los triangulos presentes en la lista
	 * 
	 * @return
	 */
	public String listaTriangulos() {
		int cantidad = 0;
		for (FiguraCerrada figura : figuritas) {
			if (figura instanceof Triangulo) {
				cantidad++;
			}
		}
		return "total triangulos: " + cantidad;
	}

	/**
	 * recorre la lista a la inversa
	 */
	public String listaInversa() {
		StringBuilder inversa = new StringBuilder();
		ListIterator<FiguraCerrada> it = figuritas.listIterator(figuritas.size());
		while (it.hasPrevious())
			inversa.append("\n" + it.previous());
		return inversa.toString();
	}

	/**
	 * comprueba si el arrayList esta vacia
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return figuritas.isEmpty();
	}

	/**
	 * devuelve la figura situada en el indice indicado por parametro
	 * 
	 * @param index
	 * @return
	 */
	public FiguraCerrada get(int index) {
		return figuritas.get(index);
	}

	/**
	 * devuelve el tamaño del arrayList
	 * 
	 * @return
	 */
	public int size() {
		return figuritas.size();
	}

	/**
	 * Elimina una figura seleccionada en base al indice
	 * 
	 * @param opcion
	 * @return
	 */
	public String remove(int opcion) {
		try {
			figuritas.remove(opcion);
		} catch (IndexOutOfBoundsException e) {
			return "Indice no valido, figura no eliminada";
		}
		return "Eliminada la figura de la posicion " + opcion + 1;

	}

	/**
	 * Elimina una figura seleccionada en base a su identificador unico
	 * 
	 * @param opcion
	 * @return
	 * @throws FiguraNoExisteException
	 */
	public String removeById(int opcion) throws FiguraNoExisteException {
		if (!figuritas.remove(new Circunferencia(opcion))) {
			throw new FiguraNoExisteException("la figura no existe");
		}
		return "figura eliminada";
	}

	@Override
	public String toString() {
		return "Figuritas [figuritas=" + figuritas + "]";
	}

	public String addCircunferencia(double radio) throws DimensionRidiculaException {
		return add(new Circunferencia(radio));

	}

	public String addRectangulo(double base, double altura) throws DimensionRidiculaException {
		return add(new Rectangulo(base, altura));
	}

	public String addCuadrado(double lado) throws DimensionRidiculaException {
		return add(new Cuadrado(lado));
	}

	public String addTriangulo(double base, double altura) throws DimensionRidiculaException {
		return add(new Triangulo(base, altura));

	}

}
