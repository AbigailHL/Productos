package com.productos.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.productos.dao.Producto;
import com.productos.service.ProductoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * Servicio REST
 * @author abi_l
 *
 */
@RestController
@RequestMapping("api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	
	
	/**
	 * Crea un nuevo producto
	 * @param product
	 * @return status
	 */
	@PostMapping	
	public ResponseEntity<?> create(@RequestBody Producto product){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(product));
	}
	
	
	/**
	 * Endpoint para leer un produto dado un id
	 * @param id
	 * @return Producto
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Producto> oProducto = productoService.findById(id);
		
		if(!oProducto.isPresent()) {
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok(oProducto);
		
	}
	
	
	
	/**
	 * Endpoint para actualiza un producto dado un id
	 * @param productDetails
	 * @param id
	 * @returnc status
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Producto productDetails, @PathVariable Long id){
		Optional<Producto> oProducto = productoService.findById(id);
				
		if(!oProducto.isPresent()) {
			return ResponseEntity.notFound().build();
			
		}
		
		oProducto.get().setDescripcion(productDetails.getDescripcion());
		oProducto.get().setModelo(productDetails.getModelo());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(oProducto.get()));
		
		
		
		
	}
	
	
	/**
	 * Endpoint para eliminar un producto tomando como criterio el id
	 * @param id 
	 * @return status
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		
		if(!productoService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		productoService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Endpoint para leer todos los productos
	 * @return una lista de Productos
	 */
	@GetMapping
	public List<Producto> readAll(){
		List<Producto> productos = StreamSupport
				.stream(productoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return productos;
	}

	
	
	
	
	
	

}
