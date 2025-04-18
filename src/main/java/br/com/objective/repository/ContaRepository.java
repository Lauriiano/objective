package br.com.objective.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.objective.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
