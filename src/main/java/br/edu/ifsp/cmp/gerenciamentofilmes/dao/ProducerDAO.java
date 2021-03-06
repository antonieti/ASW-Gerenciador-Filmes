package br.edu.ifsp.cmp.gerenciamentofilmes.dao;

import br.edu.ifsp.cmp.gerenciamentofilmes.models.AbstractModel;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.Producer;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.User;
import br.edu.ifsp.cmp.gerenciamentofilmes.utils.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProducerDAO implements BaseDAO{

    private EntityManager em;

    public ProducerDAO(){
        em = ConnectionFactory.getEntityManager();
    }

    @Override
    public void save(Object object) {
        Producer producer = (Producer) object;
        em.getTransaction().begin();
        em.persist(producer);
        em.getTransaction().commit();
    }

    @Override
    public void update(Object m, Long id) {
        Producer bm = (Producer) findById(id);
        bm.clone((Producer)m);
        this.em.getTransaction().begin();
        this.em.persist(bm);
        this.em.getTransaction().commit();
    }

    @Override
    public AbstractModel findById(Long id) {
        Class aClass = Producer.class;
        this.em.getTransaction().begin();
        Object entity = this.em.find(aClass, id);
        this.em.getTransaction().commit();
        return (User) entity;
    }

    @Override
    public List findFrom(String column, String parameter) {
        Class entityClass = Producer.class;
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<AbstractModel> query = cb.createQuery(AbstractModel.class);


        Root<AbstractModel> from = query.from(entityClass);

        Predicate restriction = cb.like(from.<String>get(column), "%" + parameter + "%");

        query.select(from).equals(restriction);
        return em.createQuery(query.where(restriction)).getResultList();

    }

    public Producer findByName(String parameter){
        Class entityClass = Producer.class;
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<AbstractModel> query = cb.createQuery(AbstractModel.class);


        Root<AbstractModel> from = query.from(entityClass);

        Predicate restriction = cb.equal(from.<String>get("name"), "%" + parameter + "%");

        query.select(from).equals(restriction);
        List<AbstractModel> producer = em.createQuery(query.where(restriction)).getResultList();
        for (AbstractModel m: producer) {
            Producer producer1 = (Producer) m;
            if(producer1.getName().equalsIgnoreCase(parameter)){
                return producer1;
            }

        }
        return null;
    }
    @Override
    public List findAll() {
        return findFrom("name", " ");
    }

    @Override
    public void remove(Object object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    @Override
    public void removeId(Long id) {
        this.remove(findById(id));
    }
}
