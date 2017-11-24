package br.edu.ifsp.cmp.gerenciamentofilmes.dao;

import br.edu.ifsp.cmp.gerenciamentofilmes.models.AbstractModel;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.BaseModel;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.User;
import br.edu.ifsp.cmp.gerenciamentofilmes.utils.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDAO implements BaseDAO {
    private EntityManager em;


    public UserDAO() {
        em = ConnectionFactory.getEntityManager();
    }


    @Override
    public void save(Object object) {
        User user = (User) object;
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        List<AbstractModel> list = findFrom("name", user.getName());
        user.setId(list.get(0).getId());
    }

    @Override
    public void update(Object m, Long id) {
        User bm = (User) findById(id);
        bm.clone((User)m);
        this.em.getTransaction().begin();
        this.em.persist(bm);
        this.em.getTransaction().commit();
    }

    @Override
    public AbstractModel findById(Long id) {
        Class aClass = User.class;
        this.em.getTransaction().begin();
        Object entity = this.em.find(aClass, id);
        this.em.getTransaction().commit();
        return (User) entity;
    }

    @Override
    public List findFrom(String column, String parameter) {
        Class entityClass = User.class;
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<BaseModel> query = cb.createQuery(BaseModel.class);


        Root<BaseModel> from = query.from(entityClass);

        Predicate restriction = cb.equal(from.<String>get(column), parameter );

        query.select(from).equals(restriction);
        return em.createQuery(query.where(restriction)).getResultList();
    }

    public User findFrom(String parameter) {
        Class entityClass = User.class;
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<BaseModel> query = cb.createQuery(BaseModel.class);


        Root<BaseModel> from = query.from(entityClass);

        Predicate restriction = cb.equal(from.<String>get("userName"), parameter );

        query.select(from).equals(restriction);
        List<BaseModel> user =  em.createQuery(query.where(restriction)).getResultList();
        for (BaseModel m: user) {
            User user1 = (User) m;
            if(user1.getUserName().equalsIgnoreCase(parameter)){
                return user1;
            }

        }
        return null;
    }

    @Override
    public List findAll() {
        return this.findFrom("name", " ");
    }

    @Override
    public void remove(Object object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }


    @Override
    public void removeId(Long id) {
        remove(findById(id));
    }
}
