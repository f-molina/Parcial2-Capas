package com.uca.capas.parcial.service;

import java.util.List;

import javax.transaction.Transactional;

import com.uca.capas.parcial.dao.CategoriaDao;
import com.uca.capas.parcial.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaDao categoriaDao;

    @Override
    public List<Categoria> findAll() throws DataAccessException {
        return categoriaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Categoria categoria) throws DataAccessException {
        categoriaDao.save(categoria);
    }
}