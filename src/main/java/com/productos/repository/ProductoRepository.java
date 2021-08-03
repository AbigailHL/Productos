package com.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.productos.dao.Producto;

@Repository
@Transactional
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
