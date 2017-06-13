package com.ipartek.formacion.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * POJO curso
 * @author Curso
 *
 */
public class Curso {
	
	private static final int MINIMO = 3;
	private static final int MAX_NOMBRE = 255;
	private static final int MAX_CODIGO = 50;
	
	private long id;
    @NotNull()
    @Size(message="Debe de tener entre {min} y {max} caracteres",min=MINIMO, max=MAX_NOMBRE)
	private String nombre;
    @NotNull()
    @Size(message="Debe de tener entre {min} y {max} caracteres",min=MINIMO, max=MAX_CODIGO)
	private String cod;
    
    /**
     * Constructos basico
     */
	public Curso() {
		super();
		this.id = -1;
		this.nombre = "";
		this.cod = "";
	}
	
	/**
	 * Constructor con atributos
	 * @param id curso
	 * @param nombre curso
	 * @param cod curso
	 */
	public Curso(long id, String nombre, String cod) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cod = cod;
	}
	/**
	 * Coges el ID
	 * @return id
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Seteas el id
	 * @param id curso
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Coges el nombre
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Seteas el nombre
	 * @param nombre curso
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Coges el codigo curso
	 * @return codigo
	 */
	public String getCod() {
		return this.cod;
	}
	
	/**
	 * Seteas el codigo curso
	 * @param cod curso
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	@Override()
	public String toString() {
		return "Curso [id=" + this.id + ", nombre=" + this.nombre + ", cod=" + this.cod + "]";
	}


	
}
