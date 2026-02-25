package com.example.desafio_padrao_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.desafio_padrao_projeto.service")
public class DesafioPadraoProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPadraoProjetoApplication.class, args);
	}

}
