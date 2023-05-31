package tierraMediaTP;

import tierraMediaTP.ObjectsTierraMedia.Atraccion;
import tierraMediaTP.ObjectsTierraMedia.Oferta;
import tierraMediaTP.ObjectsTierraMedia.TipoAtraccion;
import tierraMediaTP.ObjectsTierraMedia.Usuario;

import java.util.*;

public class GeneradorSugerencias {

    private List<Oferta> ofertas;
    private Map<String, Atraccion> mapaLugarAtraccion;

    public GeneradorSugerencias(List<Oferta> ofertas, Map<String, Atraccion> mapaLugarAtraccion) {
        this.ofertas = ofertas;
        this.mapaLugarAtraccion = mapaLugarAtraccion;
    }

    public Oferta generarSugerencia(Usuario usuario, Scanner scanner) {
        Set<String> lugaresYaSugeridos = new HashSet<>();
        List<String> lugaresAceptados = new ArrayList<>();

        String nombreUsuario = usuario.getNombre();
        TipoAtraccion preferenciaUsuario = usuario.getPreferencia();
        int monedasUsuario = usuario.getMonedas();
        double tiempoDisponibleUsuario = usuario.getTiempo();
        boolean preferidas = true;
        int pasadas = 0;
        double tiempoDisponible;
        int costoAPagar;

        System.out.println("Bienvenido/a " + nombreUsuario + "!");
        boolean ban;
        do {
            ban = false;
            lugaresYaSugeridos.clear();
            pasadas = 0;
            preferidas = true;
            while (pasadas < 2) {

                for (Oferta oferta : ofertas) {
                    boolean yaSeOferto = false;
                    boolean cupoDisponible = true;

                    for (String lugar : oferta.getLugares()) {
                        if (lugaresYaSugeridos.contains(lugar)) yaSeOferto = true;
                        if (!mapaLugarAtraccion.get(lugar).tieneCuposDisponibles()) cupoDisponible = false;

                    }

                    costoAPagar = oferta.getCostoFinal();
                    tiempoDisponible = oferta.getDuracion();


                    if (monedasUsuario >= oferta.getCostoFinal() && tiempoDisponibleUsuario >= tiempoDisponible) {
                        ban = true;
                    }


                    if (oferta.esAdecuadaPara(preferenciaUsuario) == preferidas && !yaSeOferto && costoAPagar <= monedasUsuario && tiempoDisponible <= tiempoDisponibleUsuario && cupoDisponible) {
                        System.out.println(oferta);
                        System.out.println("Aceptar? s/n");
                        String input;
                        input = validarInput(scanner);
                        if (esAceptado(input)) {
                            System.out.println("Has aceptado!");
                            monedasUsuario -= costoAPagar;
                            tiempoDisponibleUsuario -= tiempoDisponible;
                            for (String lugar : oferta.getLugares()) {
                                lugaresYaSugeridos.add(lugar);
                                lugaresAceptados.add(lugar);
                                mapaLugarAtraccion.get(lugar).gastarCupo();
                            }
                        }

                    }

                }

                pasadas++;
                preferidas = false;
            }

        } while (ban);

        tiempoDisponible = (usuario.getTiempo() - tiempoDisponibleUsuario);
        costoAPagar = (usuario.getMonedas() - monedasUsuario);

//		System.out.println("RESUMEN ITINERARIO");
//		System.out.println("lugares a visitar= " + lugaresAceptados);
//		System.out.println("monedasAGastar= " + costoAPagar + ", duracionTravesia= " + (usuario.getTiempo() - tiempoDisponibleUsuario));
//		System.out.println();

        return new Oferta(lugaresAceptados, tiempoDisponible, costoAPagar, costoAPagar, null);

    }

    private String validarInput(Scanner scanner) {
        String input;
        do {
            input = scanner.next();
        } while (!input.equals("s") && !input.equals("n") && !input.equals("S") && !input.equals("N"));
        return input;
    }

    private boolean esAceptado(String input) {
        return input.equals("s") || input.equals("S");
    }

}
