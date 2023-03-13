package com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.entities.CategoriaEntity;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
	
}
