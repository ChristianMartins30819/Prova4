package br.com.politica.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.politica.modelo.Ideologia;
import br.com.politica.modelo.Partido;
import br.com.politica.repository.PartidoRepository;

public class PartidoForm {

	@NotNull
	@NotEmpty
	private String nomePartido;
	@NotNull
	@NotEmpty
	private String sigla;
	@NotNull
	private Ideologia ideologia;
	@NotNull
	private LocalDate dataFundacao;

	public String getNomePartido() {
		return nomePartido;
	}

	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Ideologia getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(Ideologia ideologia) {
		this.ideologia = ideologia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public Partido converter(PartidoRepository partidoRepository) {
		return new Partido(nomePartido, sigla, ideologia, dataFundacao);
	}

}
