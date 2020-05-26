package com.uca.capas.parcial.dao;

import java.util.List;

import com.uca.capas.parcial.domain.Categoria;

import org.springframework.dao.DataAccessException;

public interface CategoriaDao {

    public List<Categoria> findAll() throws DataAccessException;

    public void save(Categoria categoria) throws DataAccessException;
    
}