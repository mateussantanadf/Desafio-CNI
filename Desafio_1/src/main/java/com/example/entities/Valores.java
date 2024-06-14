package com.example.entities;

import java.io.Serializable;

public class Valores implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double valorA, valorB;
	
	public Valores() {
		
	}

	public Valores(Double valorA, Double valorB) {
		super();
		this.valorA = valorA;
		this.valorB = valorB;
	}

	public Double getValorA() {
		return valorA;
	}

	public void setValorA(Double valorA) {
		this.valorA = valorA;
	}

	public Double getValorB() {
		return valorB;
	}

	public void setValorB(Double valorB) {
		this.valorB = valorB;
	}

	@Override
	public String toString() {
		return "Valores [valorA=" + valorA + ", valorB=" + valorB + "]";
	}
}
