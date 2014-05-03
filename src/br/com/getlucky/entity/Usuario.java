package br.com.getlucky.entity;

import java.util.Date;

public class Usuario {
	
	private String nome;
	private Date dataDeNascimento;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}
