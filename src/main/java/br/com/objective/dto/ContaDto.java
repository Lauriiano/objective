package br.com.objective.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContaDto {

	@NotNull(message = "É obrigatório")
	private Integer numero_conta;
	
	@NotNull(message = "Não pode ser nulo")
	@Min(value = 1)
	private float saldo;
	
}
