package com.example.entities;

public class Vendedores {
	
	private String nome;
	private int qtdItens;
	private Double totalVendido;
	private Double salario;
	
	public Vendedores() {
		
	}

	public Vendedores(String nome, int qtdItens, Double totalVendido, Double salario) {
		super();
		this.nome = nome;
		this.qtdItens = qtdItens;
		this.totalVendido = totalVendido;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}

	public Double getTotalVendido() {
		return totalVendido;
	}

	public void setTotalVendido(Double totalVendido) {
		this.totalVendido = totalVendido;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	
	
}
