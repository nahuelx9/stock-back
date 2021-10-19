package com.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.Articulo;


@Repository
public interface IArticuloDao extends JpaRepository<Articulo, Long> {

}
