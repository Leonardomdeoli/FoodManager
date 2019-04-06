package br.com.udi.management.product.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.udi.management.product.entity.Lanche;
import br.com.udi.management.product.utils.BaseDados;

@Service
public class LancheService {

	public Collection<Lanche> getLanches() throws Exception {
		return BaseDados.getLanhes();
	}
}
