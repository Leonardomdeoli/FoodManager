package br.com.udi.management.product.utils;

import br.com.udi.management.product.entity.Ingrediente;
import br.com.udi.management.product.entity.Lanche;

/**
 * Exemplo de uso de Builder Design Patterns
 */
public class LancheBuilder {
	private Lanche instance;

	public LancheBuilder(Integer codigo, String nome) {
		this.instance = new Lanche(codigo, nome);
	}

	public LancheBuilder addALface(Ingrediente alface) {
		instance.addIngrediente(alface);
		return this;
	}
	
	public LancheBuilder addBalcon(Ingrediente bacon) {
		instance.addIngrediente(bacon);
		return this;
	}
	
	public LancheBuilder addHamburguer(Ingrediente hamburguer) {
		instance.addIngrediente(hamburguer);
		return this;
	}
	
	public LancheBuilder addOvo(Ingrediente ovo) {
		instance.addIngrediente(ovo);
		return this;
	}
	
	public LancheBuilder addQueijo(Ingrediente queijo) {
		instance.addIngrediente(queijo);
		return this;
	}
	
	public Lanche construir() {
		return instance;
	}
}
