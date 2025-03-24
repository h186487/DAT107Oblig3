package oblig3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

}
