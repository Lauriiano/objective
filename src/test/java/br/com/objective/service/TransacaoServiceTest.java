package br.com.objective.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.objective.dto.TransacaoDto;
import br.com.objective.service.impl.TransacaoServiceImpl;

@SpringBootTest
class TransacaoServiceTest {
	
	@Autowired
	TransacaoServiceImpl transacaoService;

	@Test
	void deveCriarTransacaoEretornarSaldoEnumeroDaConta() {
		assertThat(transacaoService.transacao(TransacaoDto.builder().numero_conta(123).valor(10f).forma_pagamento("D").build())).isNotNull();
	}
	
}
