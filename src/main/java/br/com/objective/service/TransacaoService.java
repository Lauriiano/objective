package br.com.objective.service;

import br.com.objective.dto.TransacaoDto;
import br.com.objective.model.Transacao;

public interface TransacaoService {

	Transacao transacao(TransacaoDto dto);
	
}
