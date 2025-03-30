package br.com.objective.service;

import java.util.List;

import br.com.objective.dto.ContaDto;
import br.com.objective.model.Conta;

public interface ContaService {
	
	Conta create(ContaDto dto);
	
	List<Conta> findAll();
	
	Conta findById(Integer id);
	
	Conta update(Conta conta);
	
}
