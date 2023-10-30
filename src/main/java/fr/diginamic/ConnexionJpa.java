package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.entites.Region;

public class ConnexionJpa {

	public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        //Recherche une région dans la base de données
        try {
            Region region = entityManager.find(Region.class, 1);
            System.out.println(region);
		} catch (Exception e) {
			System.err.println(e);
		}
        
        //Ajout d'une région en base de données
        try {
            Region nouvelleRegion = new Region(0, "Guadeloupe");
            entityManager.getTransaction().begin();
            entityManager.persist(nouvelleRegion);
            entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Erreur lors de l'ajout d'une région");
		}
        
        //Recherche la région ajoutée
        try {
            Region region = entityManager.find(Region.class, 3);
            System.out.println(region);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
            entityManager.close();
            entityManagerFactory.close();
        }
	}

}
