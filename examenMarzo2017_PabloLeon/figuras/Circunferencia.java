package examenMarzo2017_PabloLeon.figuras;

import examenMarzo2017_PabloLeon.excepciones.DimensionRidiculaException;
/**
 * 
 * @author Pablo Leon Alcaide
 *
 */
public class Circunferencia extends FiguraCerrada {
	private double radio;
	public Circunferencia(double radio) throws DimensionRidiculaException {
		this.radio=radio;
	}
	public Circunferencia(int id){
		super(id);
	}
	@Override
	double perimetro() {
		return Math.rint((2*Math.PI*getRadio())*100)/100;
	}

	private double getRadio() {
		return Math.rint(radio*100)/100;

	}

	@Override
	double area() {
		return Math.rint(Math.PI*Math.pow(getRadio(), 2)*100)/100;
	}
	@Override
	public String toString(){
		return super.toString()+ "Radio: "+getRadio();
	}
}
