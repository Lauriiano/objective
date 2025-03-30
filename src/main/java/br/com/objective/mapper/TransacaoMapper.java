package br.com.objective.mapper;

import br.com.objective.dto.TransacaoDto;
import br.com.objective.dto.TransacaoResponseDto;
import br.com.objective.model.Transacao;

public class TransacaoMapper {
	
	public static Transacao fromDtoToEntity(TransacaoDto dto) {
		return Transacao.builder()
				.forma_pagamento(dto.getForma_pagamento())
				.numero_conta(dto.getNumero_conta())
				.valor_movimentado(dto.getValor())
				.build();
	}
	
	public static TransacaoResponseDto fromEntityToResponseDto(Transacao transacao, float saldoAtualizado) {
		return TransacaoResponseDto.builder()
				.numero_conta(transacao.getNumero_conta())
				.saldo(saldoAtualizado)
				.build();
	}

}
