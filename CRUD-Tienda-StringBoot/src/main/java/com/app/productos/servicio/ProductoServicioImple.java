package com.app.productos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.productos.entidad.Productos;
import com.app.productos.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImple implements  ProductosServicio{
	
	@Autowired
	private ProductoRepositorio repositorio;

	@Override
	public List<Productos> ListarTodosLosProductos() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Productos guardarProducto(Productos producto) {
		// TODO Auto-generated method stub
		return repositorio.save(producto);
	}

	@Override
	public Productos obtenerProductoPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Productos actualizarProducto(Productos producto) {
		// TODO Auto-generated method stub
		return repositorio.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);;
	}

}
