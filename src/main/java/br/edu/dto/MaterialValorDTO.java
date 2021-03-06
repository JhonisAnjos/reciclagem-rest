package br.edu.dto;

import java.io.Serializable;

public class MaterialValorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String material;
	
	private Double valor;
	
	public MaterialValorDTO() {
	}
	
	public MaterialValorDTO(Integer id, String material, Double valor) {
		super();
		this.id = id;
		this.material = material;
		this.valor = valor;
	}


	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
