package com.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.Articulo;
import com.stock.entity.Carro;


@Repository
public interface ICarroDao extends JpaRepository<Carro, Long> {

}
