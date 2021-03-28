package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;


@Service  //REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) { //ECONTRAR UM USUÁRIO PELO ID
		Optional<Product> obj = repository.findById(id); //OBJ OPTIONAL
		return obj.get();
	}
}
