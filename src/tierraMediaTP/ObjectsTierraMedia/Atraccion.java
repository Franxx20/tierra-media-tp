package tierraMediaTP.ObjectsTierraMedia;

import java.util.ArrayList;
import java.util.Arrays;

public class Atraccion extends Oferta{

	private int cupo;
	
	public Atraccion(String nombre, int costo, double tiempoRequerido, int cupo, TipoAtraccion tipo) {
		super(new ArrayList<String>(Arrays.asList(nombre)),tiempoRequerido,costo,costo,tipo);
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + this.lugares.get(0) + ", costo=" + this.precioOriginal + ", tiempoRequerido=" + this.duracion + ", cupo="
				+ cupo + ", tipo=" + this.tiposAtraccionIncluidos + "]";
	}

	public int getCostoFinal() {
		return this.precioOriginal;
	}

	public String getNombre() {
		return this.lugares.get(0);
	}

	public TipoAtraccion getTipo() {
		return this.tiposAtraccionIncluidos;
	}

	public Atraccion gastarCupo() {
		this.cupo--;
		return this;
	}
	
	public boolean tieneCuposDisponibles() {
		return this.cupo > 0; 
				
	}
	
}
