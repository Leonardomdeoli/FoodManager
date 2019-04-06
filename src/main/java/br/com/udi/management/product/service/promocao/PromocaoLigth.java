package br.com.udi.management.product.service.promocao;

import java.math.BigDecimal;
import java.util.List;

import br.com.udi.management.product.entity.Ingrediente;
import br.com.udi.management.product.service.Promocao;
import br.com.udi.management.product.utils.BigDecimalUtils;

public class PromocaoLigth implements Promocao {

	public BigDecimal calculaDesconto(List<Ingrediente> ingredientes) {
		BigDecimal valorTotal = BigDecimal.ZERO;
		
		for (Ingrediente ingrediente : ingredientes) {
			valorTotal = valorTotal.add(BigDecimalUtils.getBigDecimailOrZero(ingrediente.getValor()));
		}
		
		return valorTotal.subtract(valorTotal.multiply(new BigDecimal(0.1)));
	}
}
