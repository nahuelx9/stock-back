package com.stock.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="articulo")
public class Articulo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	@Basic(optional = false)
	private Long id;
	
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Column(name = "precio")
	private float precio;
	
	@NotNull
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
	@Column(name = "categoria")
	private String categoria;
	
	@NotNull
	@Column(name = "fecha_carga")
	private LocalDate fechaCarga = LocalDate.now();
	
	@Column(name = "fecha_actualizacion")
	private LocalDate fechaActualizacion;
	
	
	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "vendido")
	private boolean vendido;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDate getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(LocalDate fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	

	public LocalDate getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDate fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", fechaCarga=" + fechaCarga + ", imagen=" + imagen + "]";
	}
	
	
	
	
	
	
}
