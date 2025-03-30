package br.com.objective.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.objective.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
