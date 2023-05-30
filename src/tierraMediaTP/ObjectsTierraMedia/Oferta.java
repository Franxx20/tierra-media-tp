package tierraMediaTP.ObjectsTierraMedia;

import java.util.List;

import tierraMediaTP.ObjectTierraMedia;

public class Oferta extends ObjectTierraMedia implements Comparable<Oferta>{

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

	@Override
	public String toString() {
		return "Oferta [lugares=" + lugares + ", duracion=" + duracion + ", precioOriginal="
				+ precioOriginal + ", precioConDescuento=" + precioConDescuento + ", tiposAtraccion=" + tiposAtraccionIncluidos +"]";
	}

	@Override
	public int compareTo(Oferta o) {
		
		double cmp = lugares.size() - o.lugares.size();
		if(cmp == 0 || (lugares.size()>1 && o.lugares.size()>1)) {
			cmp = this.precioConDescuento - o.precioConDescuento;
			if(cmp == 0) {
				cmp = this.duracion - o.duracion;
				if(cmp == 0) return 0;
			}
		}
		
		return (cmp < 0)? -1 : 1;
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
