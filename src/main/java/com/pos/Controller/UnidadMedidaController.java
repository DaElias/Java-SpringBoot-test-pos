package com.pos.Controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pos.bl.UnidadMedidaBl;
import com.pos.dto.UnidadMedidaDto;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/unidadmedida")
public class UnidadMedidaController {

	@Autowired
	private UnidadMedidaBl unidadMeididaBl;

	@GetMapping
	public ResponseEntity<List<UnidadMedidaDto>> findAll() {
//		return new ResponseEntity<List<UnidadMedidaDto>>(unidadMeididaBl.findAll(), HttpStatus.OK);
		return ResponseEntity.ok(unidadMeididaBl.findAll());
	}

	@GetMapping("/pages")
	public ResponseEntity<List<UnidadMedidaDto>> findAllPage(@RequestParam int page, @RequestParam int size) {
		return ResponseEntity.ok(unidadMeididaBl.findAllPages(page, size));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<UnidadMedidaDto> findAllPage(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(unidadMeididaBl.findById(id));
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@PostMapping
	public ResponseEntity<UnidadMedidaDto> save(@Valid @RequestBody UnidadMedidaDto element,BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST );
		}
		return ResponseEntity.ok(unidadMeididaBl.save(element));
	}
//	private String formatMessage() {
//		return null;
//	}
}
