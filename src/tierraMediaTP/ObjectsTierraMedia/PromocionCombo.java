package tierraMediaTP.ObjectsTierraMedia;

import java.util.List;
import java.util.Map;

public class PromocionCombo extends PromocionRaw{

	public PromocionCombo(int cantidad, List<String> lugares) {
		super(cantidad, lugares);
	}

	protected int calcularPrecioConDescuento(Map<String,Atraccion> mapaLugarAtraccion) {
		int precio = calcularPrecioOriginal(mapaLugarAtraccion);
		String lugarGratis = this.lugares.get(this.lugares.size() - 1);
		precio -= mapaLugarAtraccion.get(lugarGratis).getCostoFinal();
		
		return precio;
	}
	
}
