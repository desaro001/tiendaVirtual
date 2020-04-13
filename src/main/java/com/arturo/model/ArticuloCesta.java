package com.arturo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ArticulosCesta")
public class ArticuloCesta {	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer idCesta;	
	private Integer idArticulo;
	private int cantidad;
	private Double importe;	
	private String tipo;	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
		
	public Integer getIdCesta() {
		return idCesta;
	}
	public void setIdCesta(Integer idCesta) {
		this.idCesta = idCesta;
	}
	public Integer getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		return "ArticuloCesta [idCesta=" + idCesta + ", idArticulo=" + idArticulo + ", cantidad=" + cantidad
				+ ", importe=" + importe + "]";
	}
	
	
}
