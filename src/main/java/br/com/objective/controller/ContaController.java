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

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService contaService;
	
	@PostMapping
	public ResponseEntity<Conta> create(@RequestBody @Valid ContaDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaService.create(dto));
	}
	
	@GetMapping("{numero_conta}")
	public ResponseEntity<Conta> findByInd(@PathVariable("numero_conta") Integer numero_conta) {
		return ResponseEntity.status(HttpStatus.OK).body(contaService.findById(numero_conta));
	}
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(contaService.findAll());
	}
	
}
