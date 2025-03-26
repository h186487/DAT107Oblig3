package oblig3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProsjektDAO {
	
	private static EntityManagerFactory emf;
	
	public ProsjektDAO() {
		emf = Persistence.createEntityManagerFactory("ansattPU");
	}

	/* --------------------------------------------------------------------- */

	public void leggTilNyttProsjekt(String navn, String beskrivelse) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Prosjekt prosjekt = new Prosjekt(navn, beskrivelse);
			em.persist(prosjekt);
			tx.commit();
			System.out.println("Prosjekt lagt til: " + prosjekt);
			
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	/* --------------------------------------------------------------------- */

	public void registerProsjektdeltagelse(int ansattId, int prosjektId, String rolle) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Ansatt ansatt = em.find(Ansatt.class, ansattId);
			Prosjekt prosjekt = em.find(Prosjekt.class, prosjektId);
			
			if (ansatt != null && prosjekt != null) {
				List<Prosjektdeltagelse> eksisterendeDeltagere = em.createQuery("select p from Prosjektdeltagelse p where p.ansatt.ansattId = :ansattId AND p.prosjekt.prosjektId= :prosjektId", Prosjektdeltagelse.class)
						.setParameter("ansattId", ansattId)
						.setParameter("prosjektId", prosjektId)
						.getResultList();
				
				if (eksisterendeDeltagere.isEmpty()) {
					Prosjektdeltagelse prosjektdeltagelse = new Prosjektdeltagelse(ansatt, prosjekt, rolle);
					em.persist(prosjektdeltagelse);
					
					System.out.println("Prosjektdeltagelse registeret: " + prosjektdeltagelse);
				} else {
					System.out.println("Prosjektdeltagelse eksisterer allerede for ansattId: " + ansattId + " og prosjektId: " + prosjektId);
				}
				
				tx.commit();
			} else {
				System.out.println("Fant ikke ansatt eller prosjekt.");
			}		
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	/* --------------------------------------------------------------------- */

	public void foreTimerForProsjekt(int ansattId, int prosjektId, double timer) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();

			Prosjektdeltagelse prosjektdeltagelse = em.createQuery("select p from Prosjektdeltagelse p where p.ansatt.ansattId = :ansattId AND p.prosjekt.prosjektId= :prosjektId", Prosjektdeltagelse.class)
					.setParameter("ansattId", ansattId)
					.setParameter("prosjektId", prosjektId)
					.getSingleResult();
			
			prosjektdeltagelse.setTimer(prosjektdeltagelse.getTimer() + timer);
			em.persist(prosjektdeltagelse);
			tx.commit();
			System.out.println("Timer oppdatert for prosjektdeltagelse: " + prosjektdeltagelse);		
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	/* --------------------------------------------------------------------- */

	public void utskriftProsjektInfo(int prosjektId) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			
			Prosjekt prosjekt = em.find(Prosjekt.class, prosjektId);
			
			if (prosjekt != null) {
				System.out.println("Prosjekt: " + prosjekt.getNavn());
				System.out.println("Beskrivelse: " + prosjekt.getBeskrivelse());
				List<Prosjektdeltagelse> deltagere = em.createQuery("select p from Prosjektdeltagelse p where p.prosjekt.prosjektId= :prosjektId", Prosjektdeltagelse.class)
						.setParameter("prosjektId", prosjektId)
						.getResultList();
				
				double totaltTimer = 0;
				for ( Prosjektdeltagelse deltagelse : deltagere) {
					System.out.println("Ansatt: " + deltagelse.getAnsatt().getFornavn() + " " + deltagelse.getAnsatt().getEtternavn() + 
							" Rolle: " + deltagelse.getRolle() + " Timer: " + deltagelse.getTimer());
					totaltTimer += deltagelse.getTimer();
				}
				System.out.println("Totalt antall timer for prosjektet:" + totaltTimer);
			} else {
				System.out.println("Prosjektet finnes ikke");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
