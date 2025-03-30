package br.com.objective.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacaoDto {

	private String forma_pagamento;
	
	private Integer numero_conta;
	
	private float valor;
	
}
