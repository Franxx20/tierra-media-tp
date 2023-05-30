package tierraMediaTP.Archivos;

import tierraMediaTP.ObjectTierraMedia;
import tierraMediaTP.ObjectsTierraMedia.TipoAtraccion;
import tierraMediaTP.ObjectsTierraMedia.Usuario;

import java.util.List;
import java.util.Scanner;

public class ArchivoUsuarios extends ArchivoEntrada {

    public ArchivoUsuarios() {
        super("USUARIOS");
    }

    @Override
    public void procedimientoLectura(List<ObjectTierraMedia> lista, Scanner scanner) {
        while (scanner.hasNext()) {
            lista.add(new Usuario(scanner.next().replace('-', ' '), TipoAtraccion.valueOf(scanner.next()), scanner.nextInt(),
                    scanner.nextDouble()));
        }
    }

}
