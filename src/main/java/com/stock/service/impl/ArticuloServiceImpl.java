package com.stock.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.IArticuloDao;
import com.stock.entity.Articulo;
import com.stock.service.IArticuloService;

@Service
public class ArticuloServiceImpl implements IArticuloService {
	
	@Autowired
	private IArticuloDao articuloDao;
	
	@Override
	public List<Articulo> findAll() {
		// TODO Auto-generated method stub
		return articuloDao.findAll();
	}

	@Override
	public Articulo findById(Long id) {
		// TODO Auto-generated method stub
		return articuloDao.findById(id).get();
	}

	@Override
	public Articulo save(Articulo articulo) {
		// TODO Auto-generated method stub
		return articuloDao.save(articulo);
	}

	@Override
	public void update(Long id, Articulo articulo) {
		// TODO Auto-generated method stub
		Articulo articuloDb = articuloDao.findById(id).get();
		System.out.println(articuloDb.toString());
		articuloDb.setNombre(articulo.getNombre());
		articuloDb.setPrecio(articulo.getPrecio());
		articuloDb.setDescripcion(articulo.getDescripcion());
		articuloDb.setFechaActualizacion(LocalDate.now());
		articuloDb.setImagen(articulo.getImagen());
		articuloDao.save(articuloDb);
	}

	@Override
	public void delete(Long id) {
		articuloDao.deleteById(id);
		
	}

}
