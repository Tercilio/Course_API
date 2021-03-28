package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;


@Service  //REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) { //ECONTRAR UM USUÁRIO PELO ID
		Optional<Order> obj = repository.findById(id); //OBJ OPTIONAL
		return obj.get();
	}
}
