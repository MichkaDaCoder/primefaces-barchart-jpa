package primefacesbarchartjpa.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * DatabaseJob.java: contains 2 methods for returning respectively
 * <b>EntityManager</b> and <b>EntityManagerFactory</b> object. Also, implements
 * <b>IDatabase</b> and <b>Serializable</b>
 *
 * @author MichkaDaCoder
 */
public class DatabaseJob implements IDatabase, Serializable {

    final String PARAM_PERSISTENCE_NAME = "primefaces-barchart-jpaPU";
    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PARAM_PERSISTENCE_NAME);

    @Override
    public EntityManager getEntityManager() {
        this.entityManager = this.getEntityManagerFactory().createEntityManager();
        return this.entityManager;
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(PARAM_PERSISTENCE_NAME);
        return this.entityManagerFactory;
    }

    @Override
    public void connect() {
        if(!getEntityManager().isOpen()) {
        getEntityManager();
        getEntityManagerFactory();
        getEntityManager().getTransaction().begin();
        }
    }

}
