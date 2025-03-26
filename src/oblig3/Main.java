package oblig3;

import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		AnsattDAO ansattDAO = new AnsattDAO();

		Ansatt a = ansattDAO.finnAnsattMedAnsattId(1001);
		System.out.println(a);
//		
		Ansatt b = ansattDAO.finnAnsattMedBrukernavn("B1");
		System.out.println(b);
//		
//		ansattDAO.oppdaterAnsatt(1002, "Bad Ass", 5000.1);
//		Ansatt oppdatert = ansattDAO.finnAnsattMedAnsattId(1002);
//		System.out.println(oppdatert);
////		
//		ansattDAO.leggTilNyAnsatt("B1", "Bob", "Kåre", new Date(), "Loker", 1.11, 1);
//		Ansatt ny = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
////		
//		ansattDAO.leggTilNyAnsatt("B2", "Bobby", "Kåre", new Date(), "Social hire", 0.01, 1);
//		Ansatt ny2 = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
//		
//		ansattDAO.leggTilNyAnsatt("B3", "Bobala", "Kåre", new Date(), "kattemenneske", 1, 1);
//		Ansatt ny3 = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
//		
//		ansattDAO.leggTilNyAnsatt("B4", "Bobsen", "Kåre", new Date(), "junior developer", 3, 2);
//		Ansatt ny4 = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
//		
//		ansattDAO.leggTilNyAnsatt("B5", "Bobander", "Kåre", new Date(), "nerd", 4, 2);
//		Ansatt ny5 = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
//		
//		ansattDAO.leggTilNyAnsatt("B6", "Bobob", "Kåre", new Date(), "underkvalifisert", 6, 2);
//		Ansatt ny6 = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
//		
//		ansattDAO.leggTilNyAnsatt("B7", "Bobala", "Kåre", new Date(), "overkvalifisert", 4, 3);
//		Ansatt ny7 = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
//		
//		ansattDAO.leggTilNyAnsatt("B8", "Bobs", "Kåre", new Date(), "senior developer", 7, 3);
//		Ansatt ny8 = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
//		
//		ansattDAO.leggTilNyAnsatt("B9", "Bobkåre", "Kåre", new Date(), "AI hvisker", 10, 3);
//		Ansatt ny9 = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
//		
//		ansattDAO.leggTilNyAnsatt("B10", "Bobobob", "Kåre", new Date(), "10 års erfaring", 7, 3);
//		Ansatt ny10 = ansattDAO.finnAnsattMedBrukernavn("B1");
//		System.out.println(ny);
		
        List<Ansatt> ansatte = ansattDAO.hentAlleAnsatte();
        for (Ansatt ansatt : ansatte) {
            System.out.println(ansatt); 
        }
		//------------------------------------------------------------------//
		
		AvdelingDAO avdelingDAO = new AvdelingDAO();
//		
		avdelingDAO.leggTilNyAvdeling(1, "Avdeling 1");
//		avdelingDAO.leggTilNyAvdeling(2, "Avdeling 2");
//		avdelingDAO.leggTilNyAvdeling(3, "Avdeling 3");
		
		
		Avdeling aa = avdelingDAO.finnAvdelingMedId(1);
		System.out.println(aa);
		
		Avdeling bb = avdelingDAO.finnAvdelingMedId(2);
		System.out.println(bb);
		
		Avdeling cc = avdelingDAO.finnAvdelingMedId(3);
		System.out.println(cc);

	}
}
