package tierraMediaTP.ObjectsTierraMedia;

import java.util.List;
import java.util.Map;

public class PromocionPlana extends PromocionRaw{

	public PromocionPlana(int cantidad, List<String> lugares) {
		super(cantidad, lugares);
	}

	protected int calcularPrecioConDescuento(Map<String,Atraccion> mapaLugarAtraccion) {
		return this.cantidad;
	}
	
}
