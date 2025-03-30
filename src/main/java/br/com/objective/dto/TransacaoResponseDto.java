package br.com.objective.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacaoResponseDto {

	private Integer numero_conta;
	
	private float saldo;
	
}
