package br.com.objective.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "conta")
public class Conta {
	
	@Id
	private Integer numero_conta;
	
	private float saldo;

}
