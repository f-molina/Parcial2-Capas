package com.uca.capas.parcial.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.uca.capas.parcial.domain.Libro;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class LibroDaoImpl implements LibroDao {

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Libro> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.cat_libro");
        Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
        List<Libro> res = query.getResultList();

        return res;
    }

    @Override
    public void save(Libro libro) throws DataAccessException {
        try {
            if (libro.getCodigoLibro() == null) {
                entityManager.persist(libro);;
            }
            else {
                entityManager.merge(libro);
                entityManager.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}