package com.uca.capas.parcial.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.uca.capas.parcial.domain.Categoria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaDaoImpl implements CategoriaDao {

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Categoria> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.cat_categoria");
        Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
        List<Categoria> res = query.getResultList();

        return res;
    }

    @Override
    public void save(Categoria categoria) throws DataAccessException {
        entityManager.persist(categoria);
    }
    
}