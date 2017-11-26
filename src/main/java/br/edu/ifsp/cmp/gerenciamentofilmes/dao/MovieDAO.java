package br.edu.ifsp.cmp.gerenciamentofilmes.dao;


import br.edu.ifsp.cmp.gerenciamentofilmes.models.AbstractModel;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.Movie;
import br.edu.ifsp.cmp.gerenciamentofilmes.utils.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MovieDAO implements BaseDAO{

    private EntityManager em;

    public MovieDAO(){
        em = ConnectionFactory.getEntityManager();
    }


    @Override
    public void save(Object object) {
        Movie m = (Movie) object;
        this.em.getTransaction().begin();
        this.em.persist(m);
        this.em.getTransaction().commit();
    }

    @Override
    public void update(Object m, Long id) {
        Movie bm = (Movie) findById(id);
        bm.clone((Movie)m);
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
        CriteriaQuery<AbstractModel> query = cb.createQuery(AbstractModel.class);


        Root<AbstractModel> from = query.from(entityClass);

        Predicate restriction = cb.like(from.<String>get(column), "%" + parameter + "%");

        query.select(from).equals(restriction);
        return em.createQuery(query.where(restriction)).getResultList();
    }

    public Movie findByName(String parameter) {
        Class entityClass = Movie.class;
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<AbstractModel> query = cb.createQuery(AbstractModel.class);


        Root<AbstractModel> from = query.from(entityClass);

        Predicate restriction = cb.equal(from.<String>get("name"),  parameter );

        query.select(from).equals(restriction);

        List<AbstractModel> movie =  em.createQuery(query.where(restriction)).getResultList();
        for (AbstractModel m: movie) {
            Movie movie1 = (Movie) m;
            if(movie1.getName().equalsIgnoreCase(parameter)){
                return movie1;
            }

        }
        return null;
    }


    public List findAll() {
        return this.findFrom("name", " ");
    }

    @Override
    public void remove(Object object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }


    public void removeId(Long id){
        remove(findById(id));
    }
}
