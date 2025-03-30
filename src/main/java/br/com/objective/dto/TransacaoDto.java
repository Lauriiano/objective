package br.com.objective.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacaoDto {

	@NotBlank(message = "Não pode ser vazio.")
	@Size(max = 1)
	private String forma_pagamento;
	
	@NotNull(message = "Não pode ser nulo")
	private Integer numero_conta;
	
	@NotNull(message = "Não pode ser nulo")
	private float valor;
	
}
