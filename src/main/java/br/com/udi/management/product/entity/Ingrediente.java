package br.com.udi.management.product.entity;

import java.math.BigDecimal;

public class Ingrediente {
	private Integer codigo; 
	private String nome;
	private BigDecimal valor;
	private String pathImage;

	public Ingrediente(Integer codigo, String nome, BigDecimal valor, String pathImage) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.pathImage = pathImage;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
}