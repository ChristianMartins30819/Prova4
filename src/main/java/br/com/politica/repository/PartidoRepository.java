package br.com.politica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.politica.modelo.Ideologia;
import br.com.politica.modelo.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

	Partido findByNomePartido(String nomePartido);
	
	@Query("SELECT p FROM Partido p ORDER BY p.nomePartido")
	List<Partido> acharPorNomeDoPartido(@Param("nomePartido") String nomePartido);
	
	@Query("SELECT p FROM Partido p ORDER BY p.ideologia")
	List<Partido> acharPorIdeologiaDoPartido(@Param("ideologia") Ideologia ideologia);

}
