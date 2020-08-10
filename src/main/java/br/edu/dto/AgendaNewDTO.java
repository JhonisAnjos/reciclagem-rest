package br.edu.dto;

import java.io.Serializable;

public class AgendaNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer empresa;
	
	private Integer bairro;
	
	private Integer diaSemana;
	
	private String horario;

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Integer getBairro() {
		return bairro;
	}

	public void setBairro(Integer bairro) {
		this.bairro = bairro;
	}

	public Integer getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
}
