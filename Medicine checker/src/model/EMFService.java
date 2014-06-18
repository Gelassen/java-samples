package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Gleichmut on 6/13/2014.
 */
public class EMFService {
    private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");

    private EMFService() {
    }

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}
