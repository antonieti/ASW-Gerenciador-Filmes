package br.edu.ifsp.cmp.gerenciamentofilmes.dao;

import br.edu.ifsp.cmp.gerenciamentofilmes.models.AbstractModel;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.BaseModel;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.MovieList;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.User;
import br.edu.ifsp.cmp.gerenciamentofilmes.utils.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MovieListDAO implements BaseDAO {
    private EntityManager em;


    public MovieListDAO() {
        em = ConnectionFactory.getEntityManager();
    }

    @Override
    public void save(AbstractModel object) {
        MovieList movieList = (MovieList) object;
        em.getTransaction().begin();
        em.persist(movieList);
        em.getTransaction().commit();
        List<AbstractModel> list = findFrom("name", movieList.getName());
        movieList.setId(list.get(0).getId());
    }

    @Override
    public void update(AbstractModel m, Long id) {
        MovieList bm = (MovieList) findById(id);
        bm.clone(m);
        this.em.getTransaction().begin();
        this.em.persist(bm);
        this.em.getTransaction().commit();
    }

    @Override
    public AbstractModel findById(Long id) {
        Class aClass = MovieList.class;
        this.em.getTransaction().begin();
        Object entity = this.em.find(aClass, id);
        this.em.getTransaction().commit();
        return (User) entity;
    }

    @Override
    public List findFrom(String column, String parameter) {
        Class entityClass = MovieList.class;
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<BaseModel> query = cb.createQuery(BaseModel.class);


        Root<BaseModel> from = query.from(entityClass);

        Predicate restriction = cb.like(from.<String>get(column), "%" + parameter + "%");

        query.select(from).equals(restriction);
        return em.createQuery(query.where(restriction)).getResultList();
    }

    @Override
    public List findAll() {
        return this.findFrom("name", " ");

    }

    @Override
    public void remove(AbstractModel object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeId(Long id) {
        this.remove(findById(id));
    }
}
