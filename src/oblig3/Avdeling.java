package oblig3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
// @NamedQuery(name = "hentAllePersoner", query ="SELECT p FROM Person as p
// order by p.id")

public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdeling_id;
	private String navn;
	private int sjef_ansatt_id;
	
	public Avdeling() {
	}
	
	public Avdeling(int avdeling_id, String navn, int sjef_ansatt_id) {
		this.avdeling_id = avdeling_id;
		this.navn = navn;
		this.sjef_ansatt_id = sjef_ansatt_id;
	}
	
	public int getAvdelingId() {
		return avdeling_id;
	}
	
	public void setAvdelingId(int avdeling_id) {
		this.avdeling_id = avdeling_id;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public int getSjefAnsattId() {
		return sjef_ansatt_id;
	}
	
	public void setSjefAnsattId(int sjef_ansatt_id) {
		this.sjef_ansatt_id = sjef_ansatt_id;
	}
	
	@Override
	public String toString () {
		return "Avdeling " +
				"[avdelingId=" + avdeling_id +
				", navn=" + navn +
				", sjef=" + sjef_ansatt_id + "]";
	}
}
