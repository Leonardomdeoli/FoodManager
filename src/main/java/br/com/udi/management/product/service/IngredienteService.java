package br.com.udi.management.product.service;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.udi.management.product.entity.Ingrediente;
import br.com.udi.management.product.utils.BaseDados;

@Service
public class IngredienteService {

	public Collection<Ingrediente> getIngredientes() throws Exception {
		return BaseDados.getIngredientes();
	}
	
	public Ingrediente getIngrediente(BigDecimal codigo) throws Exception {
		return BaseDados.getIngrediente(codigo);
	}
}
