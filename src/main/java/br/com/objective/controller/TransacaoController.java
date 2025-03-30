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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	@Autowired
	TransacaoService transacaoService;
	
	@ApiOperation(value = "Responsavel por realizar operações financeiras")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Transação realizada com sucesso"),
			@ApiResponse(code = 404, message = "Conta não encontrada"),
			@ApiResponse(code = 404, message = "Saldo Insuficiente")
	})
	@PostMapping
	public ResponseEntity<TransacaoResponseDto> transacao(@RequestBody @Valid TransacaoDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.transacao(dto));
	}
	
}
