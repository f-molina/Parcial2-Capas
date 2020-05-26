package com.uca.capas.parcial.service;

import java.util.List;

import javax.transaction.Transactional;

import com.uca.capas.parcial.dao.LibroDao;
import com.uca.capas.parcial.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroDao libroDao;

    @Override
    public List<Libro> findAll() throws DataAccessException {
        return libroDao.findAll();
    }

    @Override
    @Transactional
    public void save(Libro libro) throws DataAccessException {
        libroDao.save(libro);
    }
    
}