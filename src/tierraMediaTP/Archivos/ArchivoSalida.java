package tierraMediaTP.Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import tierraMediaTP.ObjectTierraMedia;
import tierraMediaTP.ObjectsTierraMedia.Oferta;

public class ArchivoSalida{

	private String nombre;
	
	public ArchivoSalida() {
		this.nombre = "SALIDA_FINAL";
	}
	
	public void guardar(List<ObjectTierraMedia> datosUsuarios,
			List<Oferta> datosTravesia) {

		File fileName = new File("archivos/out/" + this.nombre + ".out");
		try (PrintWriter printer = new PrintWriter(fileName);) {

			for (int i = 0; i < datosUsuarios.size(); i++) {
				printer.println(datosUsuarios.get(i));
				printer.println("lugares a visitar= " + datosTravesia.get(i).getLugares());
				printer.println("monedasAGastar= " + datosTravesia.get(i).getCostoFinal()
						+ ", duracionTravesia= " + datosTravesia.get(i).getDuracion());
				printer.println();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
}
