package br.com.politica.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.politica.modelo.Associado;
import br.com.politica.modelo.CargoPolitico;
import br.com.politica.modelo.Sexo;
import br.com.politica.repository.AssociadoRepository;

public class AtualizacaoAssociadosForm {

	@NotNull
	@NotEmpty
	private String nomeAssociado;
	@NotNull
	private CargoPolitico cargo;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Sexo sexo;

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

	public Associado atualizar(Long id, AssociadoRepository associadoRepository) {
		Associado associado = associadoRepository.getById(id);
		associado.setNomeAssociado(this.nomeAssociado);
		associado.setCargo(this.cargo);
		associado.setDataNascimento(this.dataNascimento);
		associado.setSexo(this.sexo);
		return associado;
	}

}
