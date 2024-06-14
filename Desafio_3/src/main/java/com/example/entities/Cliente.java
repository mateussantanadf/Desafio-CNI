package com.example.entities;

public class Cliente {
		
		private String nome;
		private Double qtdComprada;
		
		public Cliente() {
			
		}

		public Cliente(String nome, Double qtdComprada) {
			super();
			this.nome = nome;
			this.qtdComprada = qtdComprada;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Double getQtdComprada() {
			return qtdComprada;
		}

		public void setQtdComprada(Double qtdComprada) {
			this.qtdComprada = qtdComprada;
		}

		
		
}
