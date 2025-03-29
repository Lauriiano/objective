package br.com.objective.mapper;

import br.com.objective.dto.ContaDto;
import br.com.objective.model.Conta;

public class ContaMapper {
	
	public static Conta fromDtoToEntity(ContaDto dto) {
		return Conta.builder()
				.numero_conta(dto.getNumero_conta())
				.saldo(dto.getSaldo())
				.build();
	}

}
