package com.example.primeirotdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTest {

	@Test
	public void deve_calcular_valor_total() {
		// Arrange - Preparação
		Produto produto = new Produto();
		produto.setQuantidade(10);
		produto.setDesconto(10.0);
		produto.setAcrescimo(0.0);
		produto.setValor(10.0);
		
		double valorTotalEsperado = 90.0;

		// Act - Ação/Execução
		double resultado = produto.calcularValorTotal();

		// Assert - Confirmação
		Assertions.assertEquals(valorTotalEsperado, resultado);
	}
}
