package tierraMediaTP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import tierraMediaTP.ObjectsTierraMedia.Atraccion;
import tierraMediaTP.ObjectsTierraMedia.Oferta;
import tierraMediaTP.ObjectsTierraMedia.PromocionCombo;
import tierraMediaTP.ObjectsTierraMedia.PromocionPlana;
import tierraMediaTP.ObjectsTierraMedia.PromocionPorcentual;
import tierraMediaTP.ObjectsTierraMedia.TipoAtraccion;
import tierraMediaTP.ObjectsTierraMedia.Usuario;

public class ArchivoEnum {

	public enum TipoArchivo {
		USUARIOS {
			@Override
			public void procedimientoLectura(ArrayList<ObjectTierraMedia> lista, Scanner scanner) {
				int cant = scanner.nextInt();
				for (int i = 0; i < cant; i++) {
					lista.add(new Usuario(scanner.next().replace('-', ' '), TipoAtraccion.valueOf(scanner.next()), scanner.nextInt(),
							scanner.nextDouble()));
				}
			}
		},
		ATRACCIONES {
			@Override
			public void procedimientoLectura(ArrayList<ObjectTierraMedia> lista, Scanner scanner) {
				int cant = scanner.nextInt();
				for (int i = 0; i < cant; i++) {
					lista.add(new Atraccion(scanner.next().replace('-', ' '), scanner.nextInt(),
							scanner.nextDouble(), scanner.nextInt(), TipoAtraccion.valueOf(scanner.next())));
				}
			}
		},
		PROMOCIONES {
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
		},
		SALIDA_FINAL{
			@Override
			public ArrayList<ObjectTierraMedia> procedimiento(List<ObjectTierraMedia> datosUsuarios,
					List<Oferta> datosTravesia) {

				File fileName = new File("archivos/out/" + this.name() + ".out");
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
				return null;

			}
		};

		public ArrayList<ObjectTierraMedia> procedimiento(List<ObjectTierraMedia> datosUsuarios,
				List<Oferta> datosTravesia){
			
			ArrayList<ObjectTierraMedia> lista = new ArrayList<>();
			File fileName = new File("archivos/in/" + this.name() + ".in");
			try (Scanner scanner = new Scanner(fileName);) {

				scanner.useLocale(Locale.ENGLISH);
				
				this.procedimientoLectura(lista, scanner);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			return lista;
			
		}
		
		public void procedimientoLectura(ArrayList<ObjectTierraMedia> lista, Scanner scanner) {
		}
		
	}

	private TipoArchivo tipoDeArchivo;

	public ArchivoEnum(TipoArchivo tipo) {
		this.tipoDeArchivo = tipo;
	}

	///proceso lectura
	public ArrayList<ObjectTierraMedia> procesar() {
		return this.tipoDeArchivo.procedimiento(null,null);
	}
	//proceso escritura
	public ArrayList<ObjectTierraMedia> procesar(List<ObjectTierraMedia> datosUsuarios,
			List<Oferta> datosTravesia) {
		return this.tipoDeArchivo.procedimiento(datosUsuarios,datosTravesia);
	}

}
