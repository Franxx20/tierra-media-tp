package tierraMediaTP.ObjectsTierraMedia;

import java.util.ArrayList;
import java.util.Arrays;

public class Atraccion extends Oferta{

	private int cupo;
	
	public Atraccion(String nombre, int costo, double tiempoRequerido, int cupo, TipoAtraccion tipo) {
		super(new ArrayList<>(Arrays.asList(nombre)),tiempoRequerido,costo,costo,tipo);
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + this.lugares.get(0) + ", costo=" + this.precioOriginal + ", tiempoRequerido=" + this.duracion + ", cupo="
				+ cupo + ", tipo=" + this.tiposAtraccionIncluidos + "]";
	}

	@Override
	public int getCostoFinal() {
		return this.precioOriginal;
	}

	public String getNombre() {
		return this.lugares.get(0);
	}

	public TipoAtraccion getTipo() {
		return this.tiposAtraccionIncluidos;
	}

	public void gastarCupo() {
		this.cupo--;
	}
	
	public boolean tieneCuposDisponibles() {
		return this.cupo > 0; 
				
	}
	
}
