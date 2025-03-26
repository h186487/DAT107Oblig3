package oblig3;

import jakarta.persistence.*;

public class TestAnsatt {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            
            System.out.println("funker");
            
            Ansatt ansatt = new Ansatt("ola nordmann");
            
            em.persist(ansatt);

            em.getTransaction().commit();
            
            ansatt.skrivUt();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();	
            emf.close();
        }
    }

}


