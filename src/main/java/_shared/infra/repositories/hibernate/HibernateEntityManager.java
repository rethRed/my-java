package _shared.infra.repositories.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateEntityManager {
    
    static private EntityManagerFactory instance = null;

    static public EntityManagerFactory getInstance() {
        if(instance == null) {
            instance = Persistence.createEntityManagerFactory("app");
        }
        return instance;
    }
}
