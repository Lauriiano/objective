package br.com.objective.mapper;

import br.com.objective.dto.TransacaoDto;
import br.com.objective.model.Transacao;

public class TransacaoMapper {
	
	public static Transacao fromDtoToEntity(TransacaoDto dto) {
		return Transacao.builder()
				.forma_pagamento(dto.getForma_pagamento())
				.numero_conta(dto.getNumero_conta())
				.valor_movimentado(dto.getValor())
				.build();
	}

}
