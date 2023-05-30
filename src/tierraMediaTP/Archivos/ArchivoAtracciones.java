package tierraMediaTP.Archivos;

import tierraMediaTP.ObjectTierraMedia;
import tierraMediaTP.ObjectsTierraMedia.Atraccion;
import tierraMediaTP.ObjectsTierraMedia.TipoAtraccion;

import java.util.List;
import java.util.Scanner;

public class ArchivoAtracciones extends ArchivoEntrada {

    public ArchivoAtracciones() {
        super("ATRACCIONES");
    }

    @Override
    public void procedimientoLectura(List<ObjectTierraMedia> lista, Scanner scanner) {
        while (scanner.hasNext()) {
            lista.add(new Atraccion(scanner.next().replace('-', ' '), scanner.nextInt(),
                    scanner.nextDouble(), scanner.nextInt(), TipoAtraccion.valueOf(scanner.next())));
        }
    }


}
