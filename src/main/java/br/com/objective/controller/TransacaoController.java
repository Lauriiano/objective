package br.com.objective.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.objective.dto.TransacaoDto;
import br.com.objective.dto.TransacaoResponseDto;
import br.com.objective.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	@Autowired
	TransacaoService transacaoService;
	
	@PostMapping
	public ResponseEntity<TransacaoResponseDto> transacao(@RequestBody @Valid TransacaoDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.transacao(dto));
	}
	
}
