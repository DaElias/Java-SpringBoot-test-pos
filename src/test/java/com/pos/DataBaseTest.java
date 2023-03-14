package com.pos;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pos.entities.CategoriaEntity;
import com.pos.entities.ProductoEntity;
import com.pos.entities.UnidadMedidasEntity;
import com.pos.repository.ICategoriaRepository;
import com.pos.repository.IProductoRepository;
import com.pos.repository.IUnidadMedidaRepository;

@DataJpaTest
class DataBaseTest {

	@Autowired
	private ICategoriaRepository categoriaRepo;

	@Autowired
	private IUnidadMedidaRepository unidadRepo;

	@Autowired
	private IProductoRepository productoRepo;

	@Test
	void whenFindCategoria_thenResultListCategoria() {
		categoriaRepo.save(CategoriaEntity.builder().descripcion("ARROZ").build());
		List<CategoriaEntity> consultaBase = categoriaRepo.findAll();
		print(consultaBase.toString());
	}

	@Test
	void whenFindUnidadMedida_thenResultListUNidadMedida() {
		unidadRepo.save(UnidadMedidasEntity.builder().descripcion("Litros").build());
		List<UnidadMedidasEntity> consultaBase = unidadRepo.findAll();
		print(consultaBase.toString());
//		Assertions.assertThat(consultaBase.size()).isEqualTo(1);
	}

	@Test
	void whenFindProducto_thenResultListProducto() {
		var unidad = UnidadMedidasEntity.builder().descripcion("Años Luz").build();
		var categoria = CategoriaEntity.builder().descripcion("Via Lactea").build();
		var producto = ProductoEntity.builder().nombre("Jupiter").categoria(categoria).unidadMedida(unidad)
				.descripcion("Luna de Jupiter").precio(1200).impuesto(19f).build();
		unidadRepo.save(unidad);
		categoriaRepo.save(categoria);
		productoRepo.save(producto);

		List<ProductoEntity> consultaBase = productoRepo.findAll();

		print("whenFindProducto_thenResultListProducto\n" + consultaBase.toString());
	}

	private void print(String texto) {
		System.out.println("\n" + texto + "\n");
	}

	@Test
	void deleteAllData() {
		productoRepo.delete(ProductoEntity.builder().id(1L).build());
		categoriaRepo.delete(CategoriaEntity.builder().id(1L).build());
		unidadRepo.delete(UnidadMedidasEntity.builder().id(1L).build());

		List<ProductoEntity> consultaBase = productoRepo.findAll();
		Assertions.assertThat(consultaBase.size()).isEqualTo(0);
		print("delete" + consultaBase.toString());
	}

}
