package com.example.desafio_padrao_projeto.repository;

import com.example.desafio_padrao_projeto.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {


}