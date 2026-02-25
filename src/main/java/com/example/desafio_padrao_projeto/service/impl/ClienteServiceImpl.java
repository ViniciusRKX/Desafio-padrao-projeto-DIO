package com.example.desafio_padrao_projeto.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_padrao_projeto.model.Cliente;
import com.example.desafio_padrao_projeto.model.Endereco;
import com.example.desafio_padrao_projeto.repository.ClienteRepository;
import com.example.desafio_padrao_projeto.repository.EnderecoRepository;
import com.example.desafio_padrao_projeto.service.ClienteService;
import com.example.desafio_padrao_projeto.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);

	}



	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteDb = clienteRepository.findById(id);
		if (clienteDb.isPresent()) {
			salvarClienteComCep(cliente);
		}
		
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
		
	}
	
	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			return enderecoRepository.save(novoEndereco);
			
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
