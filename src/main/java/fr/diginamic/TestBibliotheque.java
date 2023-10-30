package fr.diginamic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.entites.Client;
import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

public class TestBibliotheque {

	public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliothèque");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        try {
        	//Recherche du livre avec l'id 1
			Livre livre = entityManager.find(Livre.class, 1);
			if (livre != null) {
				System.out.println(livre);
			}else {
				System.err.println("Le livre recherché est introuvable");
			}
			System.out.println("\n");
			
			// Recherche de l'emprunt par son ID
            Emprunt emprunt = entityManager.find(Emprunt.class, 1);
            if (emprunt != null) {
                System.out.println("Emprunt trouvé - ID : " + emprunt.getId());
                System.out.println("Livres associés :");
                // Afficher tous les livres associés à cet emprunt
                for (Livre livres : emprunt.getLivres()) {
                    System.out.println(" - " + livres.getTitre());
                }
            } else {
                System.out.println("Emprunt non trouvé pour l'ID : " + 1);
            }
            System.out.println("\n");
            
            /** Utilisez une requête JPQL pour extraire les livres associés à l'emprunt
            String jpqlQuery = "SELECT l FROM Livre l JOIN l.emprunts e WHERE e.id = :empruntId";
            List<Livre> livresSQL = entityManager.createQuery(jpqlQuery, Livre.class)
                    .setParameter("empruntId", 2)
                    .getResultList();

            if (!livresSQL.isEmpty()) {
                System.out.println("Livres associés à l'emprunt (ID " + 1 + "):");
                for (Livre livres : livresSQL) {
                    System.out.println(" - Titre : " + livres.getTitre());
                    System.out.println("   Auteur : " + livres.getAuteur());
                }
            } else {
                System.out.println("Aucun livre associé à l'emprunt (ID " + 1 + ").");
            }*/    
            System.out.println("\n");
            
            // Recherche du client par son ID
            Client client = entityManager.find(Client.class, 1);
            if (client != null) {
                System.out.println("Emprunts associés :");
                // Afficher tous les emprunts associés à ce client
                for (Emprunt emprunts : client.getEmprunts()) {
                    System.out.println(" - " + emprunts.getId());
                }
			} else {
                System.out.println("Client non trouvé pour l'ID : " + 1);
            }
            
            /**Utilisez une requête JPQL pour extraire les emprunts du client
            String jpqlQuery = "SELECT e FROM Emprunt e WHERE e.client.id = :clientId";
            List<Emprunt> empruntsSQL = entityManager.createQuery(jpqlQuery, Emprunt.class)
                    .setParameter("clientId", 1)
                    .getResultList();

            if (!empruntsSQL.isEmpty()) {
                System.out.println("Emprunts du client (ID " + 1 + "):");
                for (Emprunt emprunts : empruntsSQL) {
                    System.out.println("Emprunt ID : " + emprunt.getId());
                }
            } else {
                System.out.println("Aucun emprunt trouvé pour le client (ID " + 1 + ").");
            }*/
            
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
            entityManager.close();
            entityManagerFactory.close();
        }
	}

}
