package oblig3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AvdelingDAO {
	
	private static EntityManagerFactory emf;
	
	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("ansattPU");
	}

	/* --------------------------------------------------------------------- */

	public Avdeling finnAvdelingMedId(int avdelingId) {

		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Avdeling.class, avdelingId);
		} finally {
			em.close();
		}
	}
	
	/* --------------------------------------------------------------------- */

	public List<Ansatt> utlistingAvAnsatteAvdeling(int avdelingId) {

		EntityManager em = emf.createEntityManager();

		try {
			String q = """
					select a from Ansatt a
					where a.avdeling.avdelingId = :avdelingId
					""";
			TypedQuery<Ansatt> query = em.createQuery(q, Ansatt.class);
			query.setParameter("avdelingId", avdelingId);
			List<Ansatt> ansatte = query.getResultList();

			for (Ansatt ansatt : ansatte) {
				if (ansatt.getAvdeling().getSjefId() == ansatt.getAnsattId()) {
					System.out.println("Sjef: " + ansatt);
				} else {
					System.out.println("Ansatt: " + ansatt);
				}
			}
			return ansatte;

		} finally {
			em.close();

		}
	}
	
	/* --------------------------------------------------------------------- */

	public void oppdaterAnsattAvdeling(int ansattId, int nyAvdelingId) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Ansatt ansatt = em.find(Ansatt.class, ansattId);
			Avdeling nyAvdeling = em.find(Avdeling.class, nyAvdelingId);
			
			if (ansatt != null && nyAvdeling != null) {
				
				if (ansatt.getAvdeling().getSjefId() == ansatt.getAnsattId()) {
					System.out.println("Kan ikke bytte avdeling fordi det er sjef.");
				} else {
					ansatt.setAvdeling(nyAvdeling);
					em.merge(ansatt);
					tx.commit();
					System.out.println("Ansatte sin avdeling er oppdatert.");
				} 
			} else {
				System.out.println("Ansatt eller avdeling finnes ikke.");
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

	public void leggTilNyAvdeling(String avdelingNavn, int sjefAnsattId) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Ansatt sjefAnsatt = em.find(Ansatt.class, sjefAnsattId);
			
			if (sjefAnsatt != null) {
				
				Avdeling nyAvdeling = new Avdeling();
				nyAvdeling.setNavn(avdelingNavn);
				nyAvdeling.setSjefId(sjefAnsattId);
				
				sjefAnsatt.setAvdeling(nyAvdeling);
				
				em.persist(nyAvdeling);
				em.merge(sjefAnsatt);
				tx.commit();
				System.out.println("Ny avdeling er lagt til, og sjef er overført.");				
			} else {
				System.out.println("Ansatt finnes ikke.");
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
}
