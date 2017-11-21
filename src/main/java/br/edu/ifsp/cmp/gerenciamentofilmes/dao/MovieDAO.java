package br.edu.ifsp.cmp.gerenciamentofilmes.dao;


import br.edu.ifsp.cmp.gerenciamentofilmes.models.AbstractModel;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.BaseModel;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.Movie;
import br.edu.ifsp.cmp.gerenciamentofilmes.utils.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MovieDAO{

    private EntityManager em;

    public MovieDAO(){
        em = ConnectionFactory.getEntityManager();
    }


    public void save(AbstractModel object) {
        Movie m = (Movie) object;
        this.em.getTransaction().begin();
        this.em.persist(m);
        this.em.getTransaction().commit();
        List<AbstractModel> list = findFrom("name", m.getName());
        m.setId(list.get(0).getId());
    }

    public void update(AbstractModel m, Long id) {
        Movie bm = (Movie) findById(id);
        bm.clone(m);
        this.em.getTransaction().begin();
        this.em.persist(bm);
        this.em.getTransaction().commit();

    }

    public AbstractModel findById(Long id) {
        Class aClass = Movie.class;
        this.em.getTransaction().begin();
        Object entity = this.em.find(aClass, id);
        this.em.getTransaction().commit();
        return (Movie) entity;

    }

    public List findFrom(String column, String parameter) {
        Class entityClass = Movie.class;
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<BaseModel> query = cb.createQuery(BaseModel.class);


        Root<BaseModel> from = query.from(entityClass);

        Predicate restriction = cb.like(from.<String>get(column), "%" + parameter + "%");

        query.select(from).equals(restriction);
        return em.createQuery(query.where(restriction)).getResultList();
    }

    public Movie findByName(String parameter) {
        Class entityClass = Movie.class;
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<BaseModel> query = cb.createQuery(BaseModel.class);


        Root<BaseModel> from = query.from(entityClass);

        Predicate restriction = cb.equal(from.<String>get("name"),  parameter );

        query.select(from).equals(restriction);
        return (Movie) em.createQuery(query.where(restriction));
    }


    public List findAll() {
        return this.findFrom("name", " ");
    }

    public void remove(AbstractModel object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    public void removeId(Long id){
        remove(findById(id));
    }
}
