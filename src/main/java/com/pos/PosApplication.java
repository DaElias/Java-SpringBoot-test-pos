package com.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pos.entities.CategoriaEntity;
import com.pos.entities.ProductoEntity;
import com.pos.entities.UnidadMedidasEntity;
import com.pos.repository.ICategoriaRepository;
import com.pos.repository.IProductoRepository;
import com.pos.repository.IUnidadMedidaRepository;

@SpringBootApplication
public class PosApplication implements CommandLineRunner {

	@Autowired
	private IProductoRepository productRepository;
	@Autowired
	private ICategoriaRepository categoriaRepository;
	@Autowired
	private IUnidadMedidaRepository unidadMedidaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//		initDb();
		System.out.println("FIN RUNNER");
	}

	private void initDb() { 
		var unidad = UnidadMedidasEntity.builder().id(1L).descripcion("Metro").build();
		var categoria = CategoriaEntity.builder().id(1L).descripcion("Categoria 1").build();
		var producto = ProductoEntity.builder().id(1L).nombre("ARROZ").categoria(categoria).unidadMedida(unidad)
				.descripcion("Arroz").precio(1200).impuesto(19f).build();
		
		
		this.categoriaRepository.save(categoria);
		this.unidadMedidaRepository.save(unidad);
		this.productRepository.save(producto);
	}
}
