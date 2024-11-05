package fr.digi.cda2024;

import fr.digi.cda2024.entities.Client;
import fr.digi.cda2024.entities.Emprunt;
import fr.digi.cda2024.entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction();

        // Read/Select
        // tp 01
        Livre livreALire = em.find(Livre.class, 1);

        if (livreALire != null) {
            System.out.println();
            System.out.println(livreALire);
            System.out.println();
        }

        // tp 02
        Emprunt emprunt = em.find(Emprunt.class, 1);

        if (emprunt != null) {
            System.out.println("Livres apparaissant dans l'emprunt d'ID 1 :");
            for (Livre livre : emprunt.getLivres()) {
                System.out.println();
                System.out.println(livre);
            }
            System.out.println();
        }

        Client client = em.find(Client.class, 1);

        if (client != null) {
            System.out.println("Le client d'ID 1 à réaliser les emprunts suivants :");
            for (Emprunt emp : client.getEmprunts()) {
                System.out.println();
                System.out.println(emp);
            }
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}