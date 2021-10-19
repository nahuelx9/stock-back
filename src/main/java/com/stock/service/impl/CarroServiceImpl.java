package com.stock.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.IArticuloDao;
import com.stock.dao.ICarroDao;
import com.stock.entity.Articulo;
import com.stock.entity.Carro;
import com.stock.service.IArticuloService;
import com.stock.service.ICarroService;

@Service
public class CarroServiceImpl implements ICarroService {

	@Override
	public List<Carro> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carro findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carro save(Carro carro) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id, Carro carro) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	

}
