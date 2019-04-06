package br.com.udi.management.product.service.promocao;

import java.math.BigDecimal;
import java.util.List;

import br.com.udi.management.product.entity.Ingrediente;
import br.com.udi.management.product.service.Promocao;
import br.com.udi.management.product.utils.BigDecimalUtils;

public class PromocaoMuitaCarne implements Promocao {

	public BigDecimal calculaDesconto(List<Ingrediente> ingredientes) {
		BigDecimal valorTotal = BigDecimal.ZERO;
		int qtd = 0;

		for (Ingrediente ingrediente : ingredientes) {
			if (3 == ingrediente.getCodigo()) {
				qtd++;
			}
			
			if(qtd == 3){
				qtd = 0;
			}else{
				valorTotal = valorTotal.add(BigDecimalUtils.getBigDecimailOrZero(ingrediente.getValor()));
			}
		}
		
		return valorTotal;
	}
}
