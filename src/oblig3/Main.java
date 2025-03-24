package oblig3;

import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		AnsattDAO ansattDAO = new AnsattDAO();

		Ansatt a = ansattDAO.finnAnsattMedAnsattId(1001);
		System.out.println(a);
		
		Ansatt b = ansattDAO.finnAnsattMedBrukernavn("J9");
		System.out.println(b);
		
		List<Ansatt> c = ansattDAO.hentAlleAnsatte();
		System.out.println(c);
		
		ansattDAO.oppdaterAnsatt(1002, "Bad Ass", 5000.1);
		Ansatt oppdatert = ansattDAO.finnAnsattMedAnsattId(1002);
		System.out.println(oppdatert);
		
		ansattDAO.leggTilNyAnsatt("B1", "Bob", "Kåre", new Date(), "Loker", 1.11, 0);
		Ansatt ny = ansattDAO.finnAnsattMedBrukernavn("B1");
		System.out.println(ny);
	
		

	}
}
