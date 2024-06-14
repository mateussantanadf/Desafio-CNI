package com.example.entities;

public class Hora {
	
	private String horaInicio;
	private String horaTermino;
	
	public Hora() {
		
	}

	public Hora(String horaInicio, String horaTermino) {
		super();
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}
	
}
