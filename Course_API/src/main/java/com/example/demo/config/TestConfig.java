package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Configuration  //PARA INFORMAR QUE É UMA CLASSE DE CONFIGURAÇÃO
@Profile("test")  //INFORMAR O PERFIL
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepositoty;   //ASSOCIANDO DEPENDENCIA, OBJ QUE ACESSA OS DADOS
	
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");	
		
		userRepositoty.saveAll(Arrays.asList(u1, u2)); //SALVANDO OS USUÁRIOS NO BD
	}

}