package oblig3;

public class Main {

	public static void main(String[] args) {

		AnsattDAO ansattDAO = new AnsattDAO();

		Ansatt a = ansattDAO.finnAnsattMedAnsattId(1001);
		System.out.println(a);

	}
}
