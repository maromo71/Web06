package br.santalucia.web06.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jogadores_pu");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }


}
