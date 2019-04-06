package br.com.udi.management.product.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.udi.management.product.entity.Ingrediente;
import br.com.udi.management.product.entity.Lanche;
import br.com.udi.management.product.service.LancheService;
import br.com.udi.management.product.service.Promocao;
import br.com.udi.management.product.service.TipoPromocao;
import br.com.udi.management.product.utils.BigDecimalUtils;

@RestController
@RequestMapping(path = "/lanches", consumes = "application/json", produces = "application/json")
public class LancheController {

	@Autowired
	private LancheService service;

	@GetMapping
	public Collection<Lanche> findAll() throws Exception {
		return service.getLanches();
	}

	@PostMapping
	public ResponseEntity<Lanche> geraPedido(@RequestBody Lanche lanche) {
		int qtdQueijo = 0;
		int qtdCarne = 0;
		boolean temAlface = Boolean.FALSE;
		boolean temBacon = Boolean.FALSE;

		List<Ingrediente> ingredientes = lanche.getIngredientes();
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (Ingrediente ingrediente : ingredientes) {
			if (5 == ingrediente.getCodigo()) {
				qtdQueijo++;
			} else if (3 == ingrediente.getCodigo()) {
				qtdCarne++;
			} else if (1 == ingrediente.getCodigo()) {
				temAlface = true;
			} else if (2 == ingrediente.getCodigo()) {
				temBacon = true;
			}
			valorTotal = valorTotal.add(BigDecimalUtils.getBigDecimailOrZero(ingrediente.getValor()));
		}

		Promocao promocao = null;
		if (temAlface && !temBacon) {
			promocao = TipoPromocao.LIGHT.obterPromocao();
		} else if (qtdCarne > 2) {
			promocao = TipoPromocao.CARNE.obterPromocao();
		} else if (qtdQueijo > 2) {
			promocao = TipoPromocao.QUEIJO.obterPromocao();
		}

		lanche.setValor(BigDecimalUtils.round(promocao != null ? promocao.calculaDesconto(ingredientes) : valorTotal));
		
		return ResponseEntity.status(HttpStatus.OK).body(lanche);
	}
}
