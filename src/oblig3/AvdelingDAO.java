package oblig3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AvdelingDAO {
	
	private static EntityManagerFactory emf;
	
	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("avdelingPU");
	}
	
	public Avdeling finnAvdelingMedId(int avdeling_id) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Avdeling.class, avdeling_id);
		} finally {
			em.close();
		}
	}
	
	public void leggTilNyAvdeling(int avdeling_id, String navn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Long count = em.createQuery(
					"SELECT COUNT(a) FROM Avdeling a WHERE a.navn = :navn", Long.class)
					.setParameter("navn", navn)
					.getSingleResult();
						
				if (count > 0) {
					System.out.println("Avdeling med gitt navn eksisterer allerede");
					return;
				}
				
			Avdeling avdeling = new Avdeling();
			avdeling.setAvdelingId(avdeling_id);
			avdeling.setNavn(navn);
			
			em.persist(avdeling);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			
		} finally {
			em.close();
		}
		
	}

}
