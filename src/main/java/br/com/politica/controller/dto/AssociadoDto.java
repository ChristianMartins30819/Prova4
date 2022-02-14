package br.com.politica.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.politica.modelo.Associado;
import br.com.politica.modelo.CargoPolitico;
import br.com.politica.modelo.Sexo;

public class AssociadoDto {

	private Long id;
	private String nomeAssociado;
	private CargoPolitico cargo;
	private LocalDate dataNascimento;
	private Sexo sexo;
	private String nomePartido;

	public AssociadoDto(Associado associado) {
		this.id = associado.getId();
		this.nomeAssociado = associado.getNomeAssociado();
		this.cargo = associado.getCargo();
		this.dataNascimento = associado.getDataNascimento();
		this.sexo = associado.getSexo();
		this.nomePartido = associado.getPartido().getNomePartido();
		
	}
	
	public Long getId() {
		return id;
	}

	public String getNomeAssociado() {
		return nomeAssociado;
	}

	public CargoPolitico getCargo() {
		return cargo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public String getNomePartido() {
		return nomePartido;
	}

	public static List<AssociadoDto> converter(List<Associado> associados) {
		return associados.stream().map(AssociadoDto::new).collect(Collectors.toList());
	}

}
