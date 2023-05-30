package tierraMediaTP.Archivos;

import java.util.ArrayList;
import java.util.Scanner;

import tierraMediaTP.ObjectTierraMedia;
import tierraMediaTP.ObjectsTierraMedia.TipoAtraccion;
import tierraMediaTP.ObjectsTierraMedia.Usuario;

public class ArchivoUsuarios extends ArchivoEntrada {

	public ArchivoUsuarios() {
		super("USUARIOS");
	}
	
	@Override
	public void procedimientoLectura(ArrayList<ObjectTierraMedia> lista, Scanner scanner) {
		int cant = scanner.nextInt();
		for (int i = 0; i < cant; i++) {
			lista.add(new Usuario(scanner.next().replace('-', ' '), TipoAtraccion.valueOf(scanner.next()), scanner.nextInt(),
					scanner.nextDouble()));
		}
	}
	
}
