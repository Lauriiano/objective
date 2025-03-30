package br.com.objective.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.objective.dto.ContaDto;
import br.com.objective.model.Conta;
import br.com.objective.service.ContaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService contaService;
	
	@ApiOperation(value = "Responsável por cria a conta")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Conta criada com sucesso"),
			@ApiResponse(code = 404, message = "Conta já existe")
	})
	@PostMapping
	public ResponseEntity<Conta> create(@RequestBody @Valid ContaDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaService.create(dto));
	}
	
	@ApiOperation(value = "Responsável por recupera uma conta por id")
	@GetMapping("{numero_conta}")
	public ResponseEntity<Conta> findByInd(@PathVariable("numero_conta") Integer numero_conta) {
		return ResponseEntity.status(HttpStatus.OK).body(contaService.findById(numero_conta));
	}
	
	@ApiOperation(value = "Responsável por recupera todas as contas")
	@GetMapping
	public ResponseEntity<List<Conta>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(contaService.findAll());
	}
	
}
