package br.com.objective.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.objective.dto.TransacaoDto;
import br.com.objective.dto.TransacaoResponseDto;
import br.com.objective.exception.BadRequestException;
import br.com.objective.mapper.ContaMapper;
import br.com.objective.mapper.TransacaoMapper;
import br.com.objective.model.Conta;
import br.com.objective.model.Transacao;
import br.com.objective.repository.TransacaoRepository;
import br.com.objective.service.impl.TransacaoServiceImpl;

@ExtendWith(MockitoExtension.class)
class TransacaoServiceTest {
	
	@Mock
	ContaService contaService;
	
	@Mock
	TransacaoRepository transacaoRepository;
	
	@InjectMocks
	TransacaoServiceImpl transacaoService;
	
	private Conta conta;
	
	private TransacaoDto dto;
	
	private Transacao transacao;
	
	private TransacaoResponseDto responseDto;
	
	private static final Integer NUMERO_CONTA = 123;
	
	private static final float VALOR_MOVIMENTADO = 10.0f;
	
	private static final String DEBITO = "D";
	
	private static final String CREDITO = "C";

	private static final String PIX = "P";
	
	@BeforeEach
	public void loads() {
		conta = Conta.builder().numero_conta(NUMERO_CONTA).saldo(108.37f).build();
		dto = TransacaoDto.builder().forma_pagamento(DEBITO).numero_conta(NUMERO_CONTA).valor(VALOR_MOVIMENTADO).build();
		transacao = Transacao.builder().id_transacao(1l).forma_pagamento(DEBITO).numero_conta(NUMERO_CONTA).valor_movimentado(VALOR_MOVIMENTADO).build();
		responseDto = TransacaoResponseDto.builder().build();
	}

	@Test
	void deveCriarTransacaoDebito_retornarSaldoEnumeroDaConta() {
		
		when(contaService.findById(NUMERO_CONTA)).thenReturn(conta);
		
		float valorPorcentagem = dto.getValor() * 1.3f;
		
		Conta contaAtualizada = Conta.builder().numero_conta(NUMERO_CONTA).saldo(conta.getSaldo() - valorPorcentagem).build(); 
		TransacaoDto dtoAtualizado = TransacaoDto.builder().forma_pagamento(DEBITO).numero_conta(NUMERO_CONTA).valor(valorPorcentagem).build();
		responseDto = TransacaoResponseDto.builder().numero_conta(NUMERO_CONTA).saldo(contaAtualizada.getSaldo()).build();
		
		when(contaService.create(ContaMapper.fromEntityToDto(contaAtualizada))).thenReturn(contaAtualizada);
		
		when(transacaoRepository.save(TransacaoMapper.fromDtoToEntity(dtoAtualizado))).thenReturn(transacao);
		
		assertEquals(transacaoService.transacao(dto), responseDto);
		
	}
	
	@Test
	void deveCriarTransacaoCredito_retornarSaldoEnumeroDaConta() {
		
		dto.setForma_pagamento(CREDITO);
		
		when(contaService.findById(NUMERO_CONTA)).thenReturn(conta);
		
		float valorPorcentagem = dto.getValor() * 1.5f;
		
		Conta contaAtualizada = Conta.builder().numero_conta(NUMERO_CONTA).saldo(conta.getSaldo() - valorPorcentagem).build(); 
		TransacaoDto dtoAtualizado = TransacaoDto.builder().forma_pagamento(CREDITO).numero_conta(NUMERO_CONTA).valor(valorPorcentagem).build();
		responseDto = TransacaoResponseDto.builder().numero_conta(NUMERO_CONTA).saldo(contaAtualizada.getSaldo()).build();
		
		when(contaService.create(ContaMapper.fromEntityToDto(contaAtualizada))).thenReturn(contaAtualizada);
		
		when(transacaoRepository.save(TransacaoMapper.fromDtoToEntity(dtoAtualizado))).thenReturn(transacao);
		
		assertEquals(transacaoService.transacao(dto), responseDto);
		
	}
	
	@Test
	void deveCriarTransacaoPix_retornarSaldoEnumeroDaConta() {
		
		when(contaService.findById(NUMERO_CONTA)).thenReturn(conta);
		
		dto.setForma_pagamento(PIX);
		
		Conta contaAtualizada = Conta.builder().numero_conta(NUMERO_CONTA).saldo(conta.getSaldo() - dto.getValor()).build(); 
		responseDto = TransacaoResponseDto.builder().numero_conta(NUMERO_CONTA).saldo(contaAtualizada.getSaldo()).build();
		
		when(contaService.create(ContaMapper.fromEntityToDto(contaAtualizada))).thenReturn(contaAtualizada);
		
		when(transacaoRepository.save(TransacaoMapper.fromDtoToEntity(dto))).thenReturn(transacao);
		
		assertEquals(transacaoService.transacao(dto), responseDto);
		
	}
	
	@Test
	void deveRetornarBadRequest_ComStringSaldoInsuficiente() {
		
		conta.setSaldo(10.0f);
		when(contaService.findById(NUMERO_CONTA)).thenReturn(conta);
		
		assertEquals("Saldo Insuficiente.", assertThrows(BadRequestException.class, () 
					-> transacaoService.transacao(dto)).getLocalizedMessage()
				);
		
	}
	
}
