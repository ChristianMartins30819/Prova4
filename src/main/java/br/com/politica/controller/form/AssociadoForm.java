package br.com.politica.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.politica.modelo.Associado;
import br.com.politica.modelo.CargoPolitico;
import br.com.politica.modelo.Partido;
import br.com.politica.modelo.Sexo;
import br.com.politica.repository.AssociadoRepository;
import br.com.politica.repository.PartidoRepository;

public class AssociadoForm {

	@NotNull
	@NotEmpty
	private String nomeAssociado;
	@NotNull
	private CargoPolitico cargo;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Sexo sexo;

	private String nomePartido;

	public String getNomeAssociado() {
		return nomeAssociado;
	}

	public void setNomeAssociado(String nomeAssociado) {
		this.nomeAssociado = nomeAssociado;
	}

	public CargoPolitico getCargo() {
		return cargo;
	}

	public void setCargo(CargoPolitico cargo) {
		this.cargo = cargo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNomePartido() {
		return nomePartido;
	}

	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}
	
	public Associado cadastrar(AssociadoRepository associadoRepository) {
		return new Associado(nomeAssociado, cargo, dataNascimento, sexo);
	}

	public Associado converter(PartidoRepository partidoRepository) {
		Partido partido = partidoRepository.findByNomePartido(nomePartido);
		return new Associado(nomeAssociado, cargo, dataNascimento, sexo, partido);
	}

}
