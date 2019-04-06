package br.com.udi.management.product;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.udi.management.product.controller.IngredienteController;
import br.com.udi.management.product.controller.LancheController;
import br.com.udi.management.product.entity.Ingrediente;
import br.com.udi.management.product.entity.Lanche;

public class TestWebApp extends ApplicationTests{

	@Autowired
	private IngredienteController ingredienteController;
	
	@Autowired
	private LancheController lancheController;

	private MockMvc ingredienteMvc;
	private MockMvc lancheMvc;

	@Before
	public void setup() {
		ingredienteMvc = MockMvcBuilders.standaloneSetup(ingredienteController).setControllerAdvice(new Exception()).build();
		lancheMvc = MockMvcBuilders.standaloneSetup(lancheController).setControllerAdvice(new Exception()).build();
	}

	@Test
	public void testIngredientes() throws Exception {
		ingredienteMvc.perform(get("/ingredientes")
					.contentType(APPLICATION_JSON)
				    .content("{\"json\":\"request to be send\"}"))
				    .andExpect(status().isOk())
				    .andExpect(content().contentType(APPLICATION_JSON_UTF8))
				    .andExpect(status().isOk());
	}
	
	@Test
	public void testLanches() throws Exception {
		lancheMvc.perform(get("/lanches")
				.contentType(APPLICATION_JSON)
				.content("{\"json\":\"request to be send\"}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void gerarPedidoMuitoQueijo() throws Exception {
		Collection<Lanche> lanches = lancheController.findAll();
		Lanche lanche = null;
		for (Lanche lanc : lanches) {
			if (4 == lanc.getCodigo()) {
				lanche = lanc;
				break;
			} 
		}
		
		Collection<Ingrediente> ingredientes = ingredienteController.findAll();

		for (Ingrediente ingrediente : ingredientes) {
			if (5 == ingrediente.getCodigo()) {
				lanche.addIngrediente(ingrediente);
				lanche.addIngrediente(ingrediente);
				lanche.addIngrediente(ingrediente);
				break;
			} 
		}
		
		Lanche response = lancheController.geraPedido(lanche).getBody();
		
		assertEquals(response.getValor(), new BigDecimal("8.80"));
	}
	
	@Test
	public void gerarPedidoMuitoCarne() throws Exception {
		Collection<Lanche> lanches = lancheController.findAll();
		Lanche lanche = null;
		for (Lanche lanc : lanches) {
			if (1 == lanc.getCodigo()) {
				lanche = lanc;
				break;
			} 
		}
		
		Collection<Ingrediente> ingredientes = ingredienteController.findAll();
		
		Ingrediente carne = null;
		for (Ingrediente ingrediente : ingredientes) {
			if (3 == ingrediente.getCodigo()) {
				carne = ingrediente;
				lanche.addIngrediente(carne);
				break;
			} 
		}
		
		Lanche response = lancheController.geraPedido(lanche).getBody();
		
		assertEquals(response.getValor(), new BigDecimal("8.00"));
		
		lanche.addIngrediente(carne);
		
		response = lancheController.geraPedido(lanche).getBody();
		
		assertEquals(response.getValor(), new BigDecimal("8.00"));
	}
	
	@Test
	public void gerarPedidoLight() throws Exception {
		Collection<Lanche> lanches = lancheController.findAll();
		Lanche lanche = null;
		for (Lanche lanc : lanches) {
			if (2 == lanc.getCodigo()) {
				lanche = lanc;
				break;
			} 
		}
		
		Collection<Ingrediente> ingredientes = ingredienteController.findAll();
		
		for (Ingrediente ingrediente : ingredientes) {
			if (1 == ingrediente.getCodigo()) {
				lanche.addIngrediente(ingrediente);
				break;
			} 
		}
		
		Lanche response = lancheController.geraPedido(lanche).getBody();
		
		assertEquals(response.getValor(), new BigDecimal("3.06"));
	}
}
