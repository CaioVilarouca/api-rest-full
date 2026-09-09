package com.demo.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.api.domain.User;
import com.demo.api.repository.UserRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner { // Interface funcional spring boot usado para execultar códigos automaticos logo após o carregamento do contexto da aplicação

	@Autowired // Criar uma instância do usuário no Repository
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { // Instância dos objetos
		User user01 = new User(null, "Caio Vilarouca", "caio@email.com", "caio1234");
		User user02 = new User(null, "Bruno Contente", "bruno@email.com", "bruno1234");
		User user03 = new User(null, "Emily Fonseca", "emily@email.com", "emily1234");

		// Salvar na banco de dados
		userRepository.saveAll(Arrays.asList(user01, user02, user03));
	}
}
