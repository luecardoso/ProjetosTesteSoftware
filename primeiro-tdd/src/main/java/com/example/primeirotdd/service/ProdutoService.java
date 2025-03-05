package com.example.primeirotdd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.primeirotdd.model.Produto;

@Service
public class ProdutoService {

	public double calcularComissao(double valorVenda) {
		if (valorVenda <= 1000) {
			return valorVenda * 0.10;
		}
		return valorVenda * 0.15;
	}
	
	public List<Produto> findAll(){
		List<Produto> produtos = new ArrayList<>();
		return produtos;
	}
	
	public Optional<Produto> findById(Long id){
		Optional<Produto> produtos = Optional.of(new Produto());
		return produtos;
	}
	
	public Produto save(Produto produto){
		return produto;
	}
}
