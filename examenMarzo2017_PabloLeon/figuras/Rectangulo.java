package examenMarzo2017_PabloLeon.figuras;

import examenMarzo2017_PabloLeon.excepciones.DimensionRidiculaException;
/**
 * 
 * @author pablo leon alcaide
 *
 */
public class Rectangulo extends FiguraCerrada {
	private double base;
	private double altura;
	public Rectangulo(double base, double altura) throws DimensionRidiculaException{
		setBase(base);
		setAltura(altura);
	}
	
	@Override
	double perimetro() {
		return Math.rint((2*getBase()+2*getAltura())*100)/100;
	}
	double getAltura() {
		return Math.rint(altura*100)/100;
	}

	double getBase() {
		return Math.rint(base*100)/100;
	}

	void setBase(double base) throws DimensionRidiculaException {
		if (base < DIMENSION_MINIMA)
			throw new DimensionRidiculaException("figura no creada por tamanno insuficiente, no menos de 0.5");
		this.base = base;
	}
	void setAltura(double altura) throws DimensionRidiculaException {
		if (altura < DIMENSION_MINIMA)
			throw new DimensionRidiculaException("figura no creada por tamanno insuficiente, no menos de 0.5");
		this.altura = altura;
	}

	@Override
	double area() {
		return Math.rint((getBase()*getAltura())*100)/100;
	}
	@Override 
	public String toString(){
		return super.toString()+" base: "+getBase()+ " altura: "+getAltura();	
	}
}
