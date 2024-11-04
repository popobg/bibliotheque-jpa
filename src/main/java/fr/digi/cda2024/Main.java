package fr.digi.cda2024;

import fr.digi.cda2024.entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque-jpa");
        EntityManager em = emf.createEntityManager();

        // Read/Select
        Livre livreALire = em.find(Livre.class, 1);

        if (livreALire != null) {
            System.out.println();
            System.out.println(livreALire);
        }

        em.close();
        emf.close();
    }
}