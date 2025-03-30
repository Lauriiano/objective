package br.com.objective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.objective.dto.TransacaoDto;
import br.com.objective.mapper.TransacaoMapper;
import br.com.objective.model.Transacao;
import br.com.objective.repository.ContaRepository;
import br.com.objective.repository.TransacaoRepository;
import br.com.objective.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService {

	@Autowired
	TransacaoRepository transacaoRepository;
	
	@Autowired
	ContaRepository contaRepository;

	public Transacao transacao(TransacaoDto dto) {
		return transacaoRepository.save(TransacaoMapper.fromDtoToEntity(dto));
	}

}
