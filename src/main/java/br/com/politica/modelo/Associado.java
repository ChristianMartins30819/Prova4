package br.com.politica.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeAssociado;
	@Enumerated(EnumType.STRING)
	private CargoPolitico cargo;
	private LocalDate dataNascimento;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@ManyToOne
	private Partido partido;

	public Associado() {

	}

	public Associado(String nome, CargoPolitico cargo, LocalDate dataNascimento, Sexo sexo) {
		this.nomeAssociado = nome;
		this.cargo = cargo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	public Associado(String nome, CargoPolitico cargo, LocalDate dataNascimento, Sexo sexo, Partido partido) {
		this.nomeAssociado = nome;
		this.cargo = cargo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.partido = partido;
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
		Associado other = (Associado) obj;
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

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

}
