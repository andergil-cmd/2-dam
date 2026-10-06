package POJOS;

import java.util.List;

public class Cine {

	protected String nombre;
	protected String ciudad;
	protected String direccion;
	public List<Peliculas> peliculas;
	
	
	public Cine() {
		
	}

	public List<Peliculas> getPeli() {
		return peliculas;
	}

	public void setPeli(List<Peliculas> peli) {
		this.peliculas = peli;
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
