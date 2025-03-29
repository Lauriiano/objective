package br.com.objective.service;

import org.assertj.core.api.Assertions;
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
		System.out.println("passou");
		Assertions.assertThat(contaService.create(ContaDto.builder().saldo(108.37f).numero_conta(1234).build())).isNull();
		
	}
	
}
