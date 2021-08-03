package com.productos.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID=7358501289393760600L;
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id; 
	
	@Column(length=20, nullable=false,unique = true)
	private String nombre;
	
	@Column(length=200)
	private String descripcion;
	
	@Column(name="precio", nullable=false, precision=12, scale=2, unique = true)
	private double precio;
	
	@Column(length=10)
	private String modelo;
	
	

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
