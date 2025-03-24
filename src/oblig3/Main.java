package oblig3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Main {
	
	private static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("ansattPU");
	}
	
	/* ------------------------------------------------------------------- */

    public static void main(String[] args) {
    	
	int ansattId = 1001;
    	
        Ansatt a = finnAnsattMedAnsattId(ansattId);
        
        if (a != null) {
        	System.out.println(a);
        } else {
        System.out.println("Ingen ansatt funnet med ansatt id: " + ansattId);
        }
    }

    private static Ansatt finnAnsattMedAnsattId(int ansattId) {

		System.out.println("Kobler til database...");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Ansatt.class, ansattId);
        } finally {
            em.close();
        }
    }

}
