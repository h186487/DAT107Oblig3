package oblig3;

import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AnsattDAO {

	private static EntityManagerFactory emf;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("ansattPU");
	}

	/* --------------------------------------------------------------------- */

	public Ansatt finnAnsattMedAnsattId(int ansatt_id) {

		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Ansatt.class, ansatt_id);
		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {

		EntityManager em = emf.createEntityManager();

		try {
			String q = """
					select a from Ansatt a
					where a.brukernavn = :brukernavn
					""";
			TypedQuery<Ansatt> query = em.createQuery(q, Ansatt.class);
			query.setParameter("brukernavn", brukernavn);

			return query.getSingleResult();

		} catch (NoResultException e) {
			return null;

		} finally {
			em.close();

		}

	}

	/* --------------------------------------------------------------------- */

	public List<Ansatt> hentAlleAnsatte() {

		EntityManager em = emf.createEntityManager();

		try {
			String q = """
					select a from Ansatt a
					""";
			TypedQuery<Ansatt> query = em.createQuery(q, Ansatt.class);

			return query.getResultList();

		} finally {
			em.close();

		}
	}

	/* --------------------------------------------------------------------- */

	public void oppdaterAnsatt(int ansatt_id, String stilling, double manedslonn) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Ansatt a = em.find(Ansatt.class, ansatt_id);

			if (a != null) {
				a.setStilling(stilling);
				a.setManedslonn(manedslonn);
				em.merge(a);
				tx.commit();
			}

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public void leggTilNyAnsatt(String brukernavn, String fornavn, String etternavn, Date dato_ansettelse, String stilling,
			double manedslonn, int avdeling_id) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			Long count = em.createQuery(
				"SELECT COUNT(a) FROM Ansatt a WHERE a.brukernavn = :brukernavn", Long.class)
				.setParameter("brukernavn", brukernavn)
				.getSingleResult();
					
			if (count > 0) {
				System.out.println("Ansatt med gitt brukernavn eksisterer allerede");
				return;
			}
			
			Ansatt a = new Ansatt(brukernavn, fornavn, etternavn, dato_ansettelse, stilling, manedslonn, avdeling_id);

			em.persist(a);
			tx.commit();
			
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
