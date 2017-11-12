package br.edu.ifsp.cmp.gerenciamentofilmes.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Objects;

public abstract class ConnectionFactory {

    private static EntityManager entityManager;


    private ConnectionFactory() {
    }

    private static void createConnection() {
        if (Objects.isNull(entityManager)) {
            entityManager = Persistence.createEntityManagerFactory("gerenciamentofilmes").createEntityManager();
        }
    }

    public static EntityManager getEntityManager() {
        if (Objects.isNull(entityManager)) {
            createConnection();
        }
        return entityManager;
    }
}
