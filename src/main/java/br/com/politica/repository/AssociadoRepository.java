package br.com.politica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.politica.modelo.Associado;
import br.com.politica.modelo.CargoPolitico;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

	List<Associado> findByNomeAssociado(String nomeAssociado);

	@Query("SELECT a FROM Associado a ORDER BY a.cargo DESC")
	List<Associado> findByCargo(@Param("cargo") CargoPolitico cargo);
	
	List<Associado> findByPartidoNomePartido(String nomePartido);

}
