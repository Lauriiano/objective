package br.com.objective.service;

import br.com.objective.dto.ContaDto;
import br.com.objective.model.Conta;

public interface ContaService {
	
	Conta create(ContaDto dto);

}
