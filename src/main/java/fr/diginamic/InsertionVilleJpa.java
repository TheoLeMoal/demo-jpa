package fr.diginamic;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.entites.Categorie;
import fr.diginamic.entites.Ville;

public class InsertionVilleJpa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai_drop_create");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Ville ville1 = new Ville(0,"Livron sur Drôme", "26250", new Date(), Categorie.PETITE);
            Ville ville2 = new Ville(0, "Dieulefit", "26220", new Date(), Categorie.MOYENNE);
            entityManager.persist(ville1);
            entityManager.persist(ville2);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
