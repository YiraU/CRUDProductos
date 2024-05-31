package com.app.productos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.app.productos.entidad.Productos;
import com.app.productos.servicio.ProductosServicio;



@Controller
public class ProductoControlador {

	@Autowired
	private ProductosServicio servicio;
	
	@GetMapping({"/productos","/"})
	public String listarProductos(Model modelo) {
		modelo.addAttribute("productos",servicio.ListarTodosLosProductos());
		return "productos";
	}
	
	@GetMapping({"/productos/nuevo"})
	public String mostrarFormularioIngresarProducto(Model modelo) {
		Productos producto = new Productos();
		modelo.addAttribute("productos",producto);
		return "ingresar_producto";	
   }
	
	@PostMapping("/productos")
	public String guardarProducto(@ModelAttribute("producto") Productos producto) {
		servicio.guardarProducto(producto);
		//TODO: process POST request
		return "redirect:/productos";
	}
	
	@GetMapping({"/productos/editar/{id}"})
	public String mostrarFormularioIngresarProducto(@PathVariable Long id, Model modelo) {
		
		modelo.addAttribute("productos",servicio.obtenerProductoPorId(id));
		return "editar_producto";		
	
}
	
	@PostMapping("/productos/{id}")
	public String actualizarProducto(@PathVariable Long id, Model modelo, @ModelAttribute("producto") Productos producto) {
		
		Productos productoExistente = servicio.obtenerProductoPorId(id);
		productoExistente.setId(id);
		productoExistente.setNombre(producto.getNombre());
		productoExistente.setPrecio(producto.getPrecio());
		productoExistente.setDescripcion(producto.getDescripcion());
		productoExistente.setCategoria(producto.getCategoria());
		
		servicio.actualizarProducto(productoExistente);
		
		//TODO: process POST request
		return "redirect:/productos";
	}

	@GetMapping({"/productos/{id}"})
	public String eliminarProducto(@PathVariable Long id) {
		servicio.eliminarProducto(id);
		return "redirect:/productos";		
	
}
}
