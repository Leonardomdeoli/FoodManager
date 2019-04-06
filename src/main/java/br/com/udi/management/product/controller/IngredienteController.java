package br.com.udi.management.product.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.udi.management.product.entity.Ingrediente;
import br.com.udi.management.product.service.IngredienteService;

@RestController
@RequestMapping(path = "/ingredientes", consumes = "application/json", produces = "application/json")
public class IngredienteController{

	@Autowired
	private IngredienteService service;

	@GetMapping
	public Collection<Ingrediente> findAll() throws Exception {
		return service.getIngredientes();
	}
}
