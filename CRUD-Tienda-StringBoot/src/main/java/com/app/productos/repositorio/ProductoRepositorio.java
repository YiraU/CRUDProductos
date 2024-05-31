package com.app.productos.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.productos.entidad.Productos;

@Repository
public interface ProductoRepositorio extends JpaRepository<Productos, Long> {
	
	

}
