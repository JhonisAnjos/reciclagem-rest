package br.edu.dto;

import java.io.Serializable;

public class MaterialValorNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer material;
	
	private Integer empresa;
	
	private Double valor;

	public Integer getMaterial() {
		return material;
	}

	public void setMaterial(Integer material) {
		this.material = material;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
