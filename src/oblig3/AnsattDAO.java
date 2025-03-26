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

	public Ansatt finnAnsattMedAnsattId(int ansattId) {

		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Ansatt.class, ansattId);
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

	public void oppdaterAnsatt(int ansattId, String stilling, double manedslonn) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Ansatt a = em.find(Ansatt.class, ansattId);

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

	public void leggTilNyAnsatt(String brukernavn, String fornavn, String etternavn, Date ansettelseDato, String stilling,
			double manedslonn, int avdelingId) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			String qStr = "SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn";
	        TypedQuery<Ansatt> q = em.createQuery(qStr, Ansatt.class);
	        q.setParameter("brukernavn", brukernavn);
			
			List<Ansatt> eksisterendeAnsatt = q.getResultList();
			if (!eksisterendeAnsatt.isEmpty()) {
				throw new IllegalArgumentException("Brukernavnet finnes allerede.");
			}
			
			Avdeling avdeling = em.find(Avdeling.class, avdelingId);
			
			if (avdeling != null) {
				
				Ansatt a = new Ansatt(brukernavn, fornavn, etternavn, ansettelseDato, stilling, manedslonn, avdeling);

				em.persist(a);
				tx.commit();
			} else {
				System.out.println("Avdeling med ID " + avdeling + "finnes ikke.");
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
