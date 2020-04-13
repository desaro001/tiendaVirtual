package com.arturo.model;

public class PedidoArticulo {
	
	private int idPedido;
	private int idArticulo;
	private String imagen;
	private int cantidad;
	private String descripcion;
	private double precio;
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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
	@Override
	public String toString() {
		return "PedidoArticulo [idPedido=" + idPedido + ", idArticulo=" + idArticulo + ", imagen=" + imagen
				+ ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
}
