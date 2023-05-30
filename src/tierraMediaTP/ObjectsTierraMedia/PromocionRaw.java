package tierraMediaTP.ObjectsTierraMedia;

import tierraMediaTP.ObjectTierraMedia;

import java.util.List;
import java.util.Map;

public abstract class PromocionRaw implements ObjectTierraMedia {

	protected int cantidad;
	protected List<String> lugares ;

	protected PromocionRaw(int cantidad, List<String> lugares) {
		this.cantidad = cantidad;
		this.lugares = lugares;
	}

	@Override
	public String toString() {
		return "Promocion [cantidad=" + cantidad + ", lugares=" + lugares + "]";
	}

	public List<String> getLugares() {
		return lugares;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	protected double calcularDuracion(Map<String,Atraccion> mapaLugarAtraccion) {
		double duracion = 0;

		for (String lugar : lugares) {
			Atraccion atraccion = mapaLugarAtraccion.get(lugar);
			duracion += atraccion.getDuracion();
		}

		return duracion;
	}
	
	protected int calcularPrecioOriginal(Map<String,Atraccion> mapaLugarAtraccion) {
		int precio = 0;

		for (String lugar : lugares) {
			Atraccion atraccion = mapaLugarAtraccion.get(lugar);
			precio += atraccion.getCostoFinal();
		}

		return precio;
	}
	
	protected abstract int calcularPrecioConDescuento(Map<String,Atraccion> mapaLugarAtraccion);
	
	protected TipoAtraccion calcularTiposAtraccionIncluidos(Map<String,Atraccion> mapaLugarAtraccion) {
		return mapaLugarAtraccion.get(lugares.get(0)).getTipo();
	}
	
	public Oferta toOferta(Map<String,Atraccion> mapaLugarAtraccion) {
		return new Oferta(lugares, calcularDuracion(mapaLugarAtraccion),
				calcularPrecioOriginal(mapaLugarAtraccion), calcularPrecioConDescuento(mapaLugarAtraccion),
				calcularTiposAtraccionIncluidos(mapaLugarAtraccion));
	}
	
}
