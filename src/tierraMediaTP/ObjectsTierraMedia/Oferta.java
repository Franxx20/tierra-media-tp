package tierraMediaTP.ObjectsTierraMedia;

import tierraMediaTP.ObjectTierraMedia;

import java.util.List;

public class Oferta implements Comparable<Oferta>, ObjectTierraMedia {

	protected List<String> lugares;
	protected double duracion;
	protected int precioOriginal;
	private int precioConDescuento;
	protected TipoAtraccion tiposAtraccionIncluidos;
	
	public Oferta(List<String> list, double duracion, int precioOriginal, int precioConDescuento, TipoAtraccion tiposAtraccionIncluidos) {
		super();
		this.lugares = list;
		this.duracion = duracion;
		this.precioOriginal = precioOriginal;
		this.precioConDescuento = precioConDescuento;
		this.tiposAtraccionIncluidos = tiposAtraccionIncluidos;
	}

	public Oferta() {

	}

	@Override
	public String toString() {
		return "Oferta [lugares=" + lugares + ", duracion=" + duracion + ", precioOriginal="
				+ precioOriginal + ", precioConDescuento=" + precioConDescuento + ", tiposAtraccion=" + tiposAtraccionIncluidos +"]";
	}

	@Override
	public int compareTo(Oferta o) {

		double resultado = (double)lugares.size() - o.lugares.size();
		if(resultado == 0 || (lugares.size()>1 && o.lugares.size()>1)) {
			resultado = (double)this.precioConDescuento - o.precioConDescuento;
			if(resultado == 0) {
				resultado = this.duracion - o.duracion;
				if(resultado == 0) return 0;
			}
		}
		
		return (resultado < 0)? -1 : 1;
	}

	public boolean esAdecuadaPara(TipoAtraccion preferenciaUsuario) {
		return tiposAtraccionIncluidos == preferenciaUsuario;
	}

	public List<String> getLugares() {
		return lugares;                                                                             
	}

	public int getCostoFinal() {
		return precioConDescuento;
	}

	public double getDuracion() {
		return duracion;
	}

}
