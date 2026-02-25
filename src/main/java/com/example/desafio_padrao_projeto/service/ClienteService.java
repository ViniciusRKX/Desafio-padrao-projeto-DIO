package com.example.desafio_padrao_projeto.service;


import com.example.desafio_padrao_projeto.model.Cliente;

public interface ClienteService {
	
	Iterable<Cliente> buscarTodos();
	Cliente buscarPorId (long id);
	void inserir (Cliente cliente);
	void atualizar (Long id, Cliente cliente);
	void deletar (Long id);

}
