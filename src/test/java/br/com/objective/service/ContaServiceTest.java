package br.com.objective.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.objective.dto.ContaDto;
import br.com.objective.service.impl.ContaServiceImpl;

@SpringBootTest
class ContaServiceTest {
	
	@Autowired
	ContaServiceImpl contaService;

	@Test
	void deveCriarContaEretornarContaCriada() {
		assertThat(contaService.create(ContaDto.builder().saldo(108.37f).numero_conta(1234).build())).isNotNull();
	}
	
	@Test
	void deveRetornarListaDeContas() {
		assertThat(contaService.findAll()).isNotEmpty();
	}
	
}
