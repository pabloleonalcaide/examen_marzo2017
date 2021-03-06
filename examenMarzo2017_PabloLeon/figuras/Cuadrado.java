package examenMarzo2017_PabloLeon.figuras;

import examenMarzo2017_PabloLeon.excepciones.DimensionRidiculaException;
/**
 * 
 * @author Pablo Leon Alcaide
 *
 */
public class Cuadrado extends Rectangulo {
	/*
	 * La clase cuadrado es un rectangulo cuyos lados son todos iguales
	 * (por lo que podr�a decirse que puede heredar de �sta)
	 */
	public Cuadrado(double lado) throws DimensionRidiculaException {
		super(lado, lado);
	}
@Override
public String toString(){
	return this.getClass().getSimpleName()+", codigo=" + getIdentificador() + ", perimetro: " + perimetro() + " area: " + area() + "]"+ " Lado: "+getBase();
}
}
