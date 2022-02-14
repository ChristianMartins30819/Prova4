package br.com.politica.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.politica.modelo.Ideologia;
import br.com.politica.modelo.Partido;

public class PartidoDto {

	private Long id;
	private String nomePartido;
	private String sigla;
	private Ideologia ideologia;
	private LocalDate dataFundacao;

	public PartidoDto(Partido partido) {
		this.id = partido.getId();
		this.nomePartido = partido.getNomePartido();
		this.sigla = partido.getSigla();
		this.ideologia = partido.getIdeologia();
		this.dataFundacao = partido.getDataFundacao();
	}

	public Long getId() {
		return id;
	}

	public String getNomePartido() {
		return nomePartido;
	}

	public String getSigla() {
		return sigla;
	}

	public Ideologia getIdeologia() {
		return ideologia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public static List<PartidoDto> converter(List<Partido> partidos) {
		return partidos.stream().map(PartidoDto::new).collect(Collectors.toList());
	}

}
