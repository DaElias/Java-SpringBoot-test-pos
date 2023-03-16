package com.pos.dto;

import org.springframework.lang.NonNull;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class UnidadMedidaDto {
	private Long id;
	@NonNull
	@Email
	private String descripcion;
}
