package POJOS;

import java.util.List;

public class Peliculas {

	protected String titulo;
	protected String genero;
	protected int duracion;
	public List<Sesiones> sesiones;
	
	
	
	public Peliculas() {
		
	}
	
	public List<Sesiones> getSesion() {
		return sesiones;
	}

	public void setSesion(List<Sesiones> sesiones) {
		this.sesiones = sesiones;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
