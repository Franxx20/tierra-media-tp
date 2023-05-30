package tierraMediaTP.ObjectsTierraMedia;

import java.util.List;
import java.util.Map;

public class PromocionPorcentual extends PromocionRaw{

	public PromocionPorcentual(int cantidad, List<String> lugares) {
		super(cantidad, lugares);
	}

	protected int calcularPrecioConDescuento(Map<String,Atraccion> mapaLugarAtraccion) {
		int x = calcularPrecioOriginal(mapaLugarAtraccion);
		return x - x*this.cantidad / 100;
	}
	
}
