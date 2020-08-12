package br.edu.dto;

import java.io.Serializable;

public class AgendaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String dia;
	
	private String horario;
	
	public AgendaDTO() {
	}
	

	public AgendaDTO(Integer dia, String horario) {
		super();
		
		switch (dia) {
		case 1:
			this.dia="Domingo";
		break;
		case 2:
			this.dia="Segunda-feira";
			break;
		case 3:
			this.dia="Terça-feira";
			break;
		case 4:
			this.dia="Quarta-feira";
			break;
		case 5:
			this.dia="Quinta-feira";
			break;
		case 6:
			this.dia="Sexta-feira";
			break;
		case 7:
			this.dia="Sábado";
			break;
		default:
			break;
		}
		this.horario = horario;
	}



	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	

}
