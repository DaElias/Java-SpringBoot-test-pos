package com.pos.bl;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dal.UnidadMedidaDal;
import com.pos.dto.UnidadMedidaDto;
import com.pos.entities.UnidadMedidasEntity;

@Service
public class UnidadMedidaBl {
	@Autowired
	private UnidadMedidaDal unidadMedidaDal;
	@Autowired
	private ModelMapper mapper;

	public List<UnidadMedidaDto> findAll() {
		var lista = this.unidadMedidaDal.findAll();
		return mapper.map(lista, new TypeToken<List<UnidadMedidasEntity>>() {
		}.getType());
	}

	public List<UnidadMedidaDto> findAllPages(int page, int size) {
		var lista = this.unidadMedidaDal.findAllPage(page, size);
		return mapper.map(lista, new TypeToken<List<UnidadMedidasEntity>>() {
		}.getType());
	}

	public UnidadMedidaDto save(UnidadMedidaDto element) {
		element.setId(0L);
		return mapper.map(this.unidadMedidaDal.save(mapper.map(element, UnidadMedidasEntity.class)),
				UnidadMedidaDto.class);
	}

	public UnidadMedidaDto update(UnidadMedidaDto element) throws Exception {
		return mapper.map(this.unidadMedidaDal.update(mapper.map(element, UnidadMedidasEntity.class)),
				UnidadMedidaDto.class);
	}

	public boolean delete(Long id) {
		try {
			this.unidadMedidaDal.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	public UnidadMedidaDto findById(Long id) throws ExecutionException {
		UnidadMedidasEntity element = this.unidadMedidaDal.findById(id);
		return mapper.map(element,UnidadMedidaDto.class);
	}

}
