package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;

@Service // REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) { // ECONTRAR UM USUÁRIO PELO ID
		Optional<User> obj = repository.findById(id); // OBJ OPTIONAL
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) { // INSERE NO BD UM NOVO USUÁRIO
		return repository.save(obj);
	}

	public void delete(Long id) { // DELETA O USUÁRIO DO BANCO DE DADOS
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id); // MELHOR QUE O FIND BY ID o FIND_BY_ID VAI NO BD E TRÁS O OBJ O
			updateDate(entity, obj);				// GET_ONE SÓ
			return repository.save(entity);			// PREPARA O OBJETO PARA DEPOIS INSERIR NO BD
			
			
		} catch (EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateDate(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		;
	}
}