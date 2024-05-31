package com.app.productos.servicio;

import java.util.List;

import com.app.productos.entidad.Productos;

public interface ProductosServicio {

	public List<Productos> ListarTodosLosProductos();
	public Productos guardarProducto(Productos producto);
	public Productos obtenerProductoPorId(Long id);
	public Productos actualizarProducto(Productos producto);
	public void eliminarProducto(Long id);
} 
