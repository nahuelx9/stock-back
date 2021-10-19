package com.stock.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.stock.entity.Articulo;

public interface IArticuloService   {
	
	public List<Articulo> findAll();
	
	public Articulo findById(Long id) throws ServiceException;
	
	public Articulo save(Articulo articulo) throws ServiceException;
	
	public void update(Long id, Articulo articulo) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;


}
