package br.com.objective.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDto {

	private Integer numero_conta;
	private float saldo;
	
}
