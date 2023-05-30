package tierraMediaTP.ObjectsTierraMedia;

import tierraMediaTP.ObjectTierraMedia;

public class Usuario implements ObjectTierraMedia {

	private String nombre;
	private TipoAtraccion preferencia;
	private int monedas;
	private double tiempoDisponible;
	
	public Usuario(String nombre, TipoAtraccion preferencia, int monedas, double tiempoDisponible) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.monedas = monedas;
		this.tiempoDisponible = tiempoDisponible;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", preferencia=" + preferencia + ", monedas=" + monedas
				+ ", tiempoDisponible=" + tiempoDisponible + "]";
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoAtraccion getPreferencia() {
		return this.preferencia;
	}

	public int getMonedas() {
		return this.monedas;
	}

	public double getTiempo() {
		return this.tiempoDisponible;
	}
	
}
