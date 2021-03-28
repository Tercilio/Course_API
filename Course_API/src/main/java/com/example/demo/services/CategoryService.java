package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

@Service // REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) { // ECONTRAR UM USUÁRIO PELO ID
		Optional<Category> obj = repository.findById(id); // OBJ OPTIONAL
		return obj.get();
	}
}
