package br.com.udi.management.product.service;

import br.com.udi.management.product.service.promocao.PromocaoLigth;
import br.com.udi.management.product.service.promocao.PromocaoMuitaCarne;
import br.com.udi.management.product.service.promocao.PromocaoMuitoQueijo;

public enum TipoPromocao {
	LIGHT {
		@Override
		public Promocao obterPromocao() {
			return new PromocaoLigth();
		}
	},
	CARNE {
		@Override
		public Promocao obterPromocao() {

			return new PromocaoMuitaCarne();
		}
	},
	QUEIJO {
		@Override
		public Promocao obterPromocao() {
			return new PromocaoMuitoQueijo();
		}
	};

	public abstract Promocao obterPromocao();
}
