package tierraMediaTP.Archivos;

import java.util.ArrayList;
import java.util.Scanner;

import tierraMediaTP.ObjectTierraMedia;
import tierraMediaTP.ObjectsTierraMedia.Atraccion;
import tierraMediaTP.ObjectsTierraMedia.TipoAtraccion;

public class ArchivoAtracciones extends ArchivoEntrada {

	public ArchivoAtracciones() {
		super("ATRACCIONES");
	}
	
	@Override
	public void procedimientoLectura(ArrayList<ObjectTierraMedia> lista, Scanner scanner) {
		int cant = scanner.nextInt();
		for (int i = 0; i < cant; i++) {
			lista.add(new Atraccion(scanner.next().replace('-', ' '), scanner.nextInt(),
					scanner.nextDouble(), scanner.nextInt(), TipoAtraccion.valueOf(scanner.next())));
		}
	}
	
}
