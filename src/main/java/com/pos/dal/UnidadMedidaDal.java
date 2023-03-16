package com.pos.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pos.entities.UnidadMedidasEntity;
import com.pos.repository.IUnidadMedidaRepository;

@Service
public class UnidadMedidaDal {

	@Autowired
	private IUnidadMedidaRepository unidadMedidaRepository;

	public List<UnidadMedidasEntity> findAll() {
		return unidadMedidaRepository.findAll();
	}

	public UnidadMedidasEntity save(UnidadMedidasEntity elemnt) {
		return unidadMedidaRepository.save(elemnt);
	}

	public void delete(Long id) throws Exception {
		if (this.unidadMedidaRepository.existsById(id)) {
			throw new Exception("not found Unidad_Medida element");
		}
		this.unidadMedidaRepository.deleteById(id);
	}

	public UnidadMedidasEntity update(UnidadMedidasEntity element) throws Exception {
		/*
		 * Optional<UnidadMedidasEntity> existeElement =
		 * unidadMedidaRepository.findById(element.getId()); if
		 * (existeElement.isEmpty()) { throw new
		 * Error("not found Unidad_Medida element"); } return (UnidadMedidasEntity)
		 * existeElement.map(u -> { u.setDescripcion(element.getDescripcion()); return
		 * this.unidadMedidaRepository.save(u); }).get();
		 */
//		return this.unidadMedidaRepository.save(element); //Si existe lo creo, sino lo actualiza

		if (!unidadMedidaRepository.existsById(element.getId())) {
			throw new Error("not found Unidad_Medida element");
		}
		return this.unidadMedidaRepository.findById(element.getId()).map(u -> {
			u.setDescripcion(element.getDescripcion());
			return this.unidadMedidaRepository.save(u);
		}).get();

	}
	
	public List<UnidadMedidasEntity> findAllPage(int page, int size) {
		return unidadMedidaRepository.findAll(PageRequest.of(page, size)).getContent();
	}

}
