package br.com.udi.management.product.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.udi.management.product.entity.Ingrediente;
import br.com.udi.management.product.entity.Lanche;

public class BaseDados {

	private static Map<Integer, Ingrediente> tbIngredientes;
	private static Map<Integer, Lanche> tbLanches;
	
	static{
		tbIngredientes =  new HashMap<Integer, Ingrediente>();
		tbIngredientes.put(1, new Ingrediente(1, "Alface", new BigDecimal("0.40"), "alface.jpg"));
		tbIngredientes.put(2, new Ingrediente(2, "Bacon", new BigDecimal("2.00"), "bacon.jpg"));
		tbIngredientes.put(3, new Ingrediente(3, "Hambúrguer de carne", new BigDecimal("3.00"), "hamburguer-carne.jpg"));
		tbIngredientes.put(4, new Ingrediente(4, "Ovo", new BigDecimal("0.80"), "ovo-frito.jpg"));
		tbIngredientes.put(5, new Ingrediente(5, "Queijo", new BigDecimal("1.50"), "queijo.jpg"));
		
		tbLanches =  new HashMap<Integer, Lanche>();
		tbLanches.put(1, new LancheBuilder(1, "X-Bacon").addBalcon(tbIngredientes.get(2)).addHamburguer(tbIngredientes.get(3)).construir());
		tbLanches.put(2, new LancheBuilder(2, "X-Burger").addHamburguer(tbIngredientes.get(3)).construir());
		tbLanches.put(3, new LancheBuilder(3, "X-Egg").addOvo(tbIngredientes.get(4)).addHamburguer(tbIngredientes.get(3)).construir());
		tbLanches.put(4, new LancheBuilder(4, "X-Egg-Bacon").addBalcon(tbIngredientes.get(2)).addOvo(tbIngredientes.get(4)).addHamburguer(tbIngredientes.get(3)).construir());
	
	}
	
	public static Collection<Ingrediente> getIngredientes(){
		return tbIngredientes.values();
	}

	public static Collection<Lanche> getLanhes() {
		return tbLanches.values();
	}

	public static Ingrediente getIngrediente(BigDecimal codigo) {
		return tbIngredientes.get(codigo);
	} 
}
