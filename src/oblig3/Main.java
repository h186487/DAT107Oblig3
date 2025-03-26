package oblig3;

import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		AnsattDAO ansattDAO = new AnsattDAO();

		Ansatt a = ansattDAO.finnAnsattMedAnsattId(1001);
		System.out.println("Ansatt med ID 1001: " + a);
		
		Ansatt b = ansattDAO.finnAnsattMedBrukernavn("J9");
		System.out.println("Ansatt med brukernavn J9: " + b);
		
		List<Ansatt> c = ansattDAO.hentAlleAnsatte();
		for (Ansatt ansatt : c) {
			System.out.println(ansatt);
		}
		
		ansattDAO.oppdaterAnsatt(1002, "Bad Ass", 5000.1);
		Ansatt oppdatert = ansattDAO.finnAnsattMedAnsattId(1002);
		System.out.println("Oppdatert ansatt: " + oppdatert);
		
		ansattDAO.leggTilNyAnsatt("B4", "Bob", "Kåre", new Date(), "Loker", 1.11, 1);
		Ansatt ny = ansattDAO.finnAnsattMedBrukernavn("B4");
		System.out.println("Ny ansatt: " + ny);
		
		/* --------------------------------------------------------------------- */
		
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		
		Avdeling d = avdelingDAO.finnAvdelingMedId(1);
		System.out.println("Avdeling med ID 1: " + d);
		
		System.out.println("Ansatte i avdeling 1:");
		avdelingDAO.utlistingAvAnsatteAvdeling(1);
		
		avdelingDAO.oppdaterAnsattAvdeling(1004, 3);
		Ansatt oppdatertAvdeling = ansattDAO.finnAnsattMedAnsattId(1004);
		System.out.println("Oppdatert ansatt etter bytte av avdeling: " + oppdatertAvdeling);
		
		avdelingDAO.leggTilNyAvdeling("Ny avdeling", 1004);
		
		/* --------------------------------------------------------------------- */
		
		ProsjektDAO prosjektDAO = new ProsjektDAO();
		
		prosjektDAO.leggTilNyttProsjekt("Prosjekt C", "Nytt prosjekt");
		
		prosjektDAO.registerProsjektdeltagelse(1004, 2, "yapping");
		
		prosjektDAO.foreTimerForProsjekt(1001, 1, 50);
		
		prosjektDAO.utskriftProsjektInfo(1);
	}
}
