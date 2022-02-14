package br.com.politica.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePartido;
	private String sigla;
	@Enumerated(EnumType.STRING)
	private Ideologia ideologia;
	private LocalDate dataFundacao;
	@OneToMany(mappedBy = "partido")
	private List<Associado> associado = new ArrayList<>();

	public Partido() {

	}

	public Partido(String nomePartido, String sigla, Ideologia ideologia, LocalDate dataFundacao) {
		this.nomePartido = nomePartido;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Associado> getAssociado() {
		return associado;
	}

	public void setAssociado(List<Associado> associado) {
		this.associado = associado;
	}

}
