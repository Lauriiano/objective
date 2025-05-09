package br.com.objective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.objective.dto.TransacaoDto;
import br.com.objective.dto.TransacaoResponseDto;
import br.com.objective.exception.BadRequestException;
import br.com.objective.mapper.TransacaoMapper;
import br.com.objective.model.Conta;
import br.com.objective.model.Transacao;
import br.com.objective.repository.TransacaoRepository;
import br.com.objective.service.ContaService;
import br.com.objective.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService {
	
	private final String DEBITO = "D";
	
	private final String CREDITO = "C";

	@Autowired
	TransacaoRepository transacaoRepository;
	
	@Autowired
	ContaService contaService;

	public TransacaoResponseDto transacao(TransacaoDto dto) {
		
		Conta conta = contaService.findById(dto.getNumero_conta()); // Lançará a exceção caso a conta não exista.
		
		validarTaxaTransacao(dto);
		
		if(conta.getSaldo() < dto.getValor()) {
			throw new BadRequestException("Saldo Insuficiente.");
		}

		conta.setSaldo(conta.getSaldo() - dto.getValor());
		
		contaService.update(conta);
		
		Transacao transacao = transacaoRepository.save(TransacaoMapper.fromDtoToEntity(dto));
		
		return TransacaoMapper.fromEntityToResponseDto(transacao, conta.getSaldo());
	}
	
	
	private void validarTaxaTransacao(TransacaoDto dto) {
		switch (dto.getForma_pagamento()) {
		case DEBITO:
			dto.setValor(dto.getValor() * 1.3f);
			break;
		case CREDITO:
			dto.setValor(dto.getValor() * 1.5f);
			break;
		}
	}

}
