package br.com.objective.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.objective.dto.ContaDto;
import br.com.objective.exception.BadRequestException;
import br.com.objective.model.Conta;
import br.com.objective.repository.ContaRepository;
import br.com.objective.service.impl.ContaServiceImpl;

@ExtendWith(MockitoExtension.class)
class ContaServiceTest {

	@Mock
	ContaRepository contaRepository;

	@InjectMocks
	ContaServiceImpl contaService;
	
	private static ContaDto dto;
	
	private static Conta conta;
	
	@BeforeAll
	public static void loadContaEcontaDto() {
		dto = ContaDto.builder().saldo(108.37f).numero_conta(1234).build();
		conta = Conta.builder().numero_conta(dto.getNumero_conta()).saldo(dto.getSaldo()).build();
	}

	@Test
	void deveSalvarEretornarContaCriada() {
		when(contaRepository.findById(dto.getNumero_conta())).thenReturn(Optional.empty());

		when(contaRepository.save(conta)).thenReturn(conta);

		assertEquals(contaService.create(dto), conta);
	}
	
	@Test
	void deveRetornarBadRequestException_ComStringContaJaExiste() {
		
		when(contaRepository.findById(dto.getNumero_conta())).thenReturn(Optional.of(conta));
		
		assertEquals("Conta ja existe.", assertThrows(BadRequestException.class, () -> 
					contaService.create(dto)).getLocalizedMessage()
				);

		verify(contaRepository, times(0)).save(Mockito.any());
	}

	@Test
	void deveRetornarListaDeContas() {
		Conta conta2 = Conta.builder().numero_conta(124).saldo(107.09f).build();

		List<Conta> listContas = new ArrayList<>();

		listContas.add(conta);
		listContas.add(conta2);

		when(contaRepository.findAll()).thenReturn(listContas);
		
		assertEquals(contaService.findAll(), listContas);
	}

	@Test
	void deveRetornarContaPorId() {
		when(contaRepository.findById(123)).thenReturn(Optional.of(conta));
		assertEquals(contaService.findById(123), conta);
	}
	
	@Test
	void deveRetornarBadRequestException_ComStringContaNaoEncontrada() {

		when(contaRepository.findById(123)).thenReturn(Optional.empty());
		
		assertEquals("Conta não encontrada.", assertThrows(BadRequestException.class, () -> 
					contaService.findById(123)).getLocalizedMessage()
				);
		
	}

}
