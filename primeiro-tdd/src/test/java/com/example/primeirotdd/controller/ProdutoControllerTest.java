package com.example.primeirotdd.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.primeirotdd.model.Produto;
import com.example.primeirotdd.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest
public class ProdutoControllerTest {

	@Autowired
	private ProdutoController produtoController;
	
	@MockBean
	private ProdutoService produtoService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
        
	}
	
	@Test
	public void deve_retornar_status_200_para_requisicao_get() throws Exception {
		//Arrange
		List<Produto> produtos = new ArrayList<>();
		var requestBuilder = MockMvcRequestBuilders.get("/api/produtos");
		when(produtoService.findAll()).thenReturn(produtos);
		
		//Act (botao de enviar)
		this.mockMvc.perform(requestBuilder)		
		//Assert (resultado esperado)
			.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void deve_retornar_status_200_para_requisicao_get_por_id() throws Exception {
		// Arrange
		Produto produto = new Produto();
        produto.setId(1L);

		
		
		var requestBuilder = MockMvcRequestBuilders.get("/api/produtos/1");
		when(produtoService.findById(1L)).thenReturn(java.util.Optional.of(produto));

		// Act (botao de enviar)
		this.mockMvc.perform(requestBuilder)
				// Assert (resultado esperado)
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));

	}
	
	@Test
	public void deve_retornar_status_200_para_requisicao_post() throws Exception {
		// Arrange
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto 1");
	    produto.setQuantidade(10);
	    produto.setValor(100.0);
	    produto.setAcrescimo(10.0);
	    produto.setDesconto(5.0);

	    String jsonProduto = new ObjectMapper().writeValueAsString(produto);
	    
		var requestBuilder = MockMvcRequestBuilders.post("/api/produtos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonProduto);
		
		when(produtoService.save(produto)).thenReturn(produto);

		// Act (botao de enviar)
		this.mockMvc.perform(requestBuilder)
				// Assert (resultado esperado)
				.andExpect(MockMvcResultMatchers.status().isCreated());
        
	}
}
