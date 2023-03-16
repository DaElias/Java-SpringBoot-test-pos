package com.pos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pos.bl.UnidadMedidaBl;
import com.pos.dto.UnidadMedidaDto;

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
}
