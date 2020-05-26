package com.uca.capas.parcial.service;

import java.util.List;

import com.uca.capas.parcial.domain.Libro;

import org.springframework.dao.DataAccessException;

public interface LibroService {

    public List<Libro> findAll() throws DataAccessException;

    public void save(Libro libro) throws DataAccessException;
    
}