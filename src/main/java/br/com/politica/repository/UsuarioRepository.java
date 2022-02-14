package br.com.politica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.politica.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

}
