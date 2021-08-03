package com.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.productos.dao.Producto;
/**
 * Interface repository donde hacemos usosde los metodos de JpaRepository para guardar la informacion en MySQL
 * @author abi_l
 *
 */
@Repository
@Transactional
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
