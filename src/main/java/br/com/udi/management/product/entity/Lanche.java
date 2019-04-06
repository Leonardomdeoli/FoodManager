package br.com.udi.management.product.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Lanche {
	private Integer codigo;
	private String nome;
	private List<Ingrediente> ingredientes;
	private BigDecimal valor;

	public Lanche(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		this.ingredientes = new ArrayList<Ingrediente>();
		this.valor = BigDecimal.ZERO;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void addIngrediente(Ingrediente ingrediente) {
		valor = valor.add(ingrediente.getValor());
		this.ingredientes.add(ingrediente);
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
