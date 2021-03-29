package br.com.eduguimar.vaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduguimar.vaccine.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
