package br.com.objective.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.objective.dto.ContaDto;
import br.com.objective.exception.BadRequestException;
import br.com.objective.mapper.ContaMapper;
import br.com.objective.model.Conta;
import br.com.objective.repository.ContaRepository;
import br.com.objective.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService {
	
	@Autowired
	ContaRepository contaRepository;

	public Conta create(ContaDto dto) {
		Optional<Conta> conta = buscarContaPorId(dto.getNumero_conta());
		
		if(conta.isPresent()) {
			throw new BadRequestException("Conta ja existe.");
		}
		
		return contaRepository.save(ContaMapper.fromDtoToEntity(dto));
	}

	public List<Conta> findAll() {
		return contaRepository.findAll();
	}

	public Conta findById(Integer id) {
		
		Optional<Conta> conta =  buscarContaPorId(id);
		
		if(!conta.isPresent()) {
			throw new BadRequestException("Conta não encontrada.");
		}
		
		return conta.get();
	}
	
	public Conta update(Conta conta) {
		findById(conta.getNumero_conta());
		return contaRepository.save(conta);
	}

	private Optional<Conta> buscarContaPorId(Integer id) {
		return contaRepository.findById(id);
	}

}
