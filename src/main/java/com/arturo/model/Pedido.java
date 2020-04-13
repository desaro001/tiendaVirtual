package com.arturo.model;

import java.util.Date;
import java.util.List;

public class Pedido {	
	
	private int idPedido;
	private Date fechaPedido;
	private int numArticulos;
	private double importePedido;
	List<PedidoArticulo> pedidoArticulos;
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public int getNumArticulos() {
		return numArticulos;
	}
	public void setNumArticulos(int numArticulos) {
		this.numArticulos = numArticulos;
	}
	public double getImportePedido() {
		return importePedido;
	}
	public void setImportePedido(double importePedido) {
		this.importePedido = importePedido;
	}
	public List<PedidoArticulo> getPedidoArticulos() {
		return pedidoArticulos;
	}
	public void setPedidoArticulos(List<PedidoArticulo> pedidoArticulos) {
		this.pedidoArticulos = pedidoArticulos;
	}
	
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", numArticulos=" + numArticulos
				+ ", importePedido=" + importePedido + ", pedidoArticulos=" + pedidoArticulos + "]";
	}

}
