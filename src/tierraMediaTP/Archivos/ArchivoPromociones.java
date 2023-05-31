package tierraMediaTP.Archivos;

import tierraMediaTP.ObjectTierraMedia;
import tierraMediaTP.ObjectsTierraMedia.PromocionCombo;
import tierraMediaTP.ObjectsTierraMedia.PromocionPlana;
import tierraMediaTP.ObjectsTierraMedia.PromocionPorcentual;
import tierraMediaTP.ObjectsTierraMedia.Atraccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArchivoPromociones extends ArchivoEntrada {

	private Map<String,Atraccion> mapaAtracciones;
	public ArchivoPromociones(Map<String, Atraccion> mapaLugarAtraccion) {
		super("PROMOCIONES");
	}
	
	@Override
	public void procedimientoLectura(List<ObjectTierraMedia> lista, Scanner scanner) {
		
		enum TipoPromocion{
			PER,ABS,AXB;
		}
		
		while(scanner.hasNext()) {
			String[] campos = scanner.nextLine().split(" ");
			int j = 0;
			TipoPromocion tipo = TipoPromocion.valueOf(campos[j++]);
			int cantidad = Integer.parseInt(campos[j++]);
			List<String> lugares = new ArrayList<>();
			while (j < campos.length) {
				lugares.add(campos[j++].replace('-', ' '));
			}
			if (tipo == TipoPromocion.PER)
				lista.add(new PromocionPorcentual(cantidad, lugares));
			else if (tipo == TipoPromocion.ABS)
				lista.add(new PromocionPlana(cantidad, lugares));
			else
				lista.add(new PromocionCombo(cantidad, lugares));
		}
	}
	
}
