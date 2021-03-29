package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service // REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) { // ECONTRAR UM USUÁRIO PELO ID
		Optional<User> obj = repository.findById(id); // OBJ OPTIONAL
		return obj.get();
	}

	public User insert(User obj) { // INSERE NO BD UM NOVO USUÁRIO
		return repository.save(obj);
	}

	public void delete(Long id) { // DELETA O USUÁRIO DO BANCO DE DADOS
		repository.deleteById(id);
	}

	public User update(Long id, User obj) {
		User entity = repository.getOne(id); // MELHOR QUE O FIND BY ID o FIND_BY_ID VAI NO BD E TRÁS O OBJ O GET_ONE SÓ PREPARA O OBJETO PARA DEPOIS INSERIR NO BD
		updateDate(entity, obj);          
		return repository.save(entity); 
	}

	private void updateDate(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());;
	}
}