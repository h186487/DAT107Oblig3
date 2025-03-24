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
    	
	String brukernavn = "1001";
    	
        Ansatt a = finnAnsattMedBrukernavn(brukernavn);
        
        if (a != null) {
        	System.out.println(a);
        }
        System.out.println("Ingen ansatt funnet mer brukernavn: " + brukernavn);
    }

    private static Ansatt finnAnsattMedBrukernavn(String brukernavn) {

		System.out.println("Kobler til database...");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Ansatt.class, brukernavn);
        } finally {
            em.close();
        }
    }

}
