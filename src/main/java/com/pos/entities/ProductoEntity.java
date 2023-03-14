package com.pos.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data @Builder
@AllArgsConstructor @NoArgsConstructor 
public class ProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	private double precio;
	private float impuesto;
	
//	@ManyToOne(fetch = FetchType.LAZY) 	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "id_unidad_medida")
	private UnidadMedidasEntity unidadMedida;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categoria")
	private CategoriaEntity categoria;
	
}
