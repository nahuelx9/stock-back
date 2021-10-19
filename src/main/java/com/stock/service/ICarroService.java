package com.stock.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.stock.entity.Articulo;
import com.stock.entity.Carro;

public interface ICarroService   {
	
	public List<Carro> findAll();
	
	public Carro findById(Long id) throws ServiceException;
	
	public Carro save(Carro carro) throws ServiceException;
	
	public void update(Long id, Carro carro) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;


}
