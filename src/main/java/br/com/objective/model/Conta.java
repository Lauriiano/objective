package br.com.objective.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "conta")
@Builder
public class Conta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer numero_conta;
	
	private float saldo;

}
