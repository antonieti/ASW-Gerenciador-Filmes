package br.edu.ifsp.cmp.gerenciamentofilmes.dao;

import br.edu.ifsp.cmp.gerenciamentofilmes.models.Movie;
import br.edu.ifsp.cmp.gerenciamentofilmes.utils.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

public class GenericDAO <T, ID> implements BaseDAO{

    private EntityManager em;
    private Class<T> entityType;

    public GenericDAO(Class<T> entityType){
        em=ConnectionFactory.getEntityManager();
        this.entityType=entityType;
    }

    @Override
    public void create(Object object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }


    @Override
    public Object read(Long id) {
        Object n;

        em.getTransaction().begin();
        n = em.find(entityType, id);
        em.getTransaction().commit();

        return n;
    }

    @Override
    public List read(String parameter) {
        return null;
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void delete(Object object) {

    }
}
