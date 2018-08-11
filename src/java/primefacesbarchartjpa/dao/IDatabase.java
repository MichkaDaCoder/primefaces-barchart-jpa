package primefacesbarchartjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * IDatabase.java: contains methods of establishing request with our <b>MySQL</b> database
 * @author MichkaDaCoder
 */
public interface IDatabase {
    EntityManager getEntityManager();
    EntityManagerFactory getEntityManagerFactory();
    void connect();
}
