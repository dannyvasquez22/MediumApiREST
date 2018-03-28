package com.admin.model;

import org.springframework.hateoas.ResourceSupport;

import com.admin.entity.Nota;

public class MNota extends ResourceSupport {
	
	private long notaId;	
	private String nombre;	
	private String titulo;	
	private String contenido;
	
	public MNota() {

	}
	
	public MNota(Nota nota) {
		this.notaId = nota.getId();
		this.nombre = nota.getNombre();
		this.titulo = nota.getTitulo();
		this.contenido = nota.getContenido();
	}

	public MNota(long notaId, String nombre, String titulo, String contenido) {
		this.notaId = notaId;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
	}

	public long getNotaId() {
		return notaId;
	}

	public void setNotaId(long notaId) {
		this.notaId = notaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
}

