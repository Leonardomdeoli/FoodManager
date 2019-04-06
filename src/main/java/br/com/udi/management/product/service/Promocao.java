package br.com.udi.management.product.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.udi.management.product.entity.Ingrediente;

public interface Promocao {
	
     public BigDecimal calculaDesconto(List<Ingrediente> ingredientes);
}
