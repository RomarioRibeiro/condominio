package com.romrio.domain;

import java.util.Date;

public class Morador {

	
	private Integer id;
	private String nome;
	private String cpf;
	private Date dataNasc;
	private Apartamento apatamento;
	
	public Morador() {
		super();
	}

	public Morador(Integer id, String nome, String cpf, Date dataNasc, Apartamento apatamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.apatamento = apatamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Apartamento getApatamento() {
		return apatamento;
	}

	public void setApatamento(Apartamento apatamento) {
		this.apatamento = apatamento;
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
		Morador other = (Morador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Morador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", apatamento=" + apatamento + "]";
	}
	
	
	
}