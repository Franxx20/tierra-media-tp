package tierraMediaTP.Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import tierraMediaTP.ObjectTierraMedia;

public abstract class ArchivoEntrada {

	protected String nombre;
	
	public ArchivoEntrada(String nombre) {
		this.nombre = nombre;
	}
	
	public List<ObjectTierraMedia> leer(){
		ArrayList<ObjectTierraMedia> lista = new ArrayList<>();

		File fileName = new File("archivos/in/" + this.nombre + ".in");
		try (Scanner scanner = new Scanner(fileName);) {

			scanner.useLocale(Locale.ENGLISH);
			
			this.procedimientoLectura(lista, scanner);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public abstract void procedimientoLectura(ArrayList<ObjectTierraMedia> lista, Scanner scanner);
	
}
