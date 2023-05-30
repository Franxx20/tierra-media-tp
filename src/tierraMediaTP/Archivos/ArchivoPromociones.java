package tierraMediaTP.Archivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tierraMediaTP.ObjectTierraMedia;
import tierraMediaTP.ObjectsTierraMedia.PromocionCombo;
import tierraMediaTP.ObjectsTierraMedia.PromocionPlana;
import tierraMediaTP.ObjectsTierraMedia.PromocionPorcentual;

public class ArchivoPromociones extends ArchivoEntrada {

	public ArchivoPromociones() {
		super("PROMOCIONES");
	}
	
	@Override
	public void procedimientoLectura(ArrayList<ObjectTierraMedia> lista, Scanner scanner) {
		
		enum TipoPromocion{
			PER,ABS,AXB;
		}
		
		int cant = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < cant; i++) {
			String[] campos = scanner.nextLine().split(" ");
			int j = 0;
			TipoPromocion tipo = TipoPromocion.valueOf(campos[j++]);
			int cantidad = Integer.valueOf(campos[j++]);
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
