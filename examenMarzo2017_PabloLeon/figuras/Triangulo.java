package examenMarzo2017_PabloLeon.figuras;

import examenMarzo2017_PabloLeon.excepciones.DimensionRidiculaException;
/**
 * 
 * @author Pablo Leon Alcaide
 *
 */
public class Triangulo extends FiguraCerrada {
	private double base,altura;
	public Triangulo(double base, double altura) throws DimensionRidiculaException {
		this.base=base;
		this.altura=altura;
	}

	@Override
	double perimetro() {
		return Math.rint(getBase()+getAltura()+Math.sqrt((getBase()+getAltura()))*100)/100;
	}

	private double getAltura() {
		return Math.rint(altura*100)/100;
	}

	private double getBase() {
		return Math.rint(base*100)/100;

	}

	@Override
	double area() {
		return Math.rint(((getBase()*getAltura())/2)*100)/100;
	}
	public String toString(){
		return super.toString()+ " Base: "+getBase()+" Altura: "+getAltura();
	}
}
