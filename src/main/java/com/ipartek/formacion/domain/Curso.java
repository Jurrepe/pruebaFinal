package com.ipartek.formacion.domain;

public class Curso {
	long id;
	String nombre;
	String cod;
	public Curso() {
		super();
		this.id = -1;
		this.nombre = "";
		this.cod = "";
	}
	public Curso(long id, String nombre, String cod) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cod = cod;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", cod=" + cod + "]";
	}


	
}
