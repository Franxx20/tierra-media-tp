package tierraMediaTP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import tierraMediaTP.ArchivoEnum.TipoArchivo;
import tierraMediaTP.Archivos.ArchivoEntrada;
import tierraMediaTP.Archivos.ArchivoSalida;
import tierraMediaTP.Archivos.ArchivoAtracciones;
import tierraMediaTP.Archivos.ArchivoPromociones;
import tierraMediaTP.Archivos.ArchivoUsuarios;
import tierraMediaTP.Comparators.AtraccionComparator;
import tierraMediaTP.Comparators.OfertaComparator;
import tierraMediaTP.ObjectsTierraMedia.Atraccion;
import tierraMediaTP.ObjectsTierraMedia.Oferta;
import tierraMediaTP.ObjectsTierraMedia.PromocionRaw;
import tierraMediaTP.ObjectsTierraMedia.Usuario;

public class Resolucion {

	public static void main(String[] args) {
		
		List<ObjectTierraMedia> datosUsuarios,datosAtracciones,datosPromociones;
		
//		ArchivoEnum archivo;
//		archivo = new ArchivoEnum(TipoArchivo.USUARIOS);
//		datosUsuarios = archivo.procesar();
//		
//		archivo = new ArchivoEnum(TipoArchivo.ATRACCIONES);
//		datosAtracciones = archivo.procesar();
//		
//		archivo = new ArchivoEnum(TipoArchivo.PROMOCIONES);
//		datosPromociones = archivo.procesar();
		
		ArchivoEntrada archivo;
		archivo = new ArchivoUsuarios();
		datosUsuarios = archivo.leer();
		
		archivo = new ArchivoAtracciones();
		datosAtracciones = archivo.leer();
		
		archivo = new ArchivoPromociones();
		datosPromociones = archivo.leer();
		
		Map<String,Atraccion> mapaLugarAtraccion = generarMapaLugarAtraccion(datosAtracciones);
		
		List<Oferta> listaOfertas = listaPromocionesToListaOfertas(datosPromociones, mapaLugarAtraccion);
		agregarAtraccionesAListaOfertasYOrdenar(listaOfertas, mapaLugarAtraccion);
		
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(listaOfertas, mapaLugarAtraccion);
		ArchivoSalida archivoSalida = new ArchivoSalida();
		archivoSalida.guardar(datosUsuarios,ejecutarSugerencias(datosUsuarios, generadorSugerencias));
//		archivo = new ArchivoEnum(TipoArchivo.SALIDA_FINAL);
//		archivo.procesar(datosUsuarios,ejecutarSugerencias(datosUsuarios, generadorSugerencias));
		System.out.println("Programa terminado");
		
		
	}

	private static Map<String, Atraccion> generarMapaLugarAtraccion(List<ObjectTierraMedia> datosAtracciones) {
		
		Map<String,Atraccion> mapaLugarAtraccion = new HashMap<>();
		
		for (ObjectTierraMedia datoAtraccion : datosAtracciones) {
			Atraccion atraccion = (Atraccion) datoAtraccion;
			mapaLugarAtraccion.put(atraccion.getNombre(), atraccion);
		}
		
		return mapaLugarAtraccion;
	}

	private static List<Oferta> listaPromocionesToListaOfertas(List<ObjectTierraMedia> datosPromociones,
			Map<String, Atraccion> mapaLugarAtraccion) {
		
		List<Oferta> listaOfertas = new ArrayList<>();
		
		for(ObjectTierraMedia datoPromocion : datosPromociones) {
			PromocionRaw promocion = (PromocionRaw) datoPromocion;
			listaOfertas.add(promocion.toOferta(mapaLugarAtraccion));
		}
		
		return listaOfertas;
	}
	
	public static void agregarAtraccionesAListaOfertasYOrdenar(List<Oferta> ofertas,
			Map<String, Atraccion> mapaLugarAtraccion) {
		
		ArrayList<Atraccion> atracciones = new ArrayList<>(mapaLugarAtraccion.values());
		ofertas.addAll(atracciones);
		ofertas.sort(new OfertaComparator());
	}
	
	private static List<Oferta> ejecutarSugerencias(List<ObjectTierraMedia> datosUsuarios, GeneradorSugerencias gen) {
		ArrayList<Oferta> listaElecciones = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		for (ObjectTierraMedia datoUsuario : datosUsuarios) {
			listaElecciones.add(gen.generarSugerencia((Usuario)datoUsuario, scanner));
		}
		scanner.close();
		return listaElecciones;
	}
	
}
