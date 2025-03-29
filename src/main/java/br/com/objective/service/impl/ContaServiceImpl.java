package br.com.objective.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.objective.dto.ContaDto;
import br.com.objective.mapper.ContaMapper;
import br.com.objective.model.Conta;
import br.com.objective.repository.ContaRepository;
import br.com.objective.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService {
	
	@Autowired
	ContaRepository contaRepository;

	public Conta create(ContaDto dto) {
		return contaRepository.save(ContaMapper.fromDtoToEntity(dto));
	}

	public List<Conta> findAll() {
		return contaRepository.findAll();
	}

}
