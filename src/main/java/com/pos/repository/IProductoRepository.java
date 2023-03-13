package com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.entities.ProductoEntity;
@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, Long>{
	
}
