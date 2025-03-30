package br.com.objective.service;

import br.com.objective.dto.TransacaoDto;
import br.com.objective.dto.TransacaoResponseDto;

public interface TransacaoService {

	TransacaoResponseDto transacao(TransacaoDto dto);
	
}
