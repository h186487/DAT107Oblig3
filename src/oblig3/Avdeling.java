package oblig3;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")

public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingId;
	
	private String navn;
	
	@OneToMany(mappedBy = "avdeling")
	private List<Ansatt> ansatte;
	
	private int sjefId;
	
	
	public Avdeling() {
	}


	public Avdeling(String navn, int sjefId) {
		this.navn = navn;
		this.sjefId = sjefId;
	}


	public int getAvdelingId() {
		return avdelingId;
	}


	public void setAvdelingId(int avdelingId) {
		this.avdelingId = avdelingId;
	}


	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}


	public List<Ansatt> getAnsatte() {
		return ansatte;
	}


	public void setAnsatte(List<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}


	public int getSjefId() {
		return sjefId;
	}


	public void setSjefId(int sjefId) {
		this.sjefId = sjefId;
	}


	@Override
	public String toString() {
		return "Avdeling [avdelingId=" + avdelingId + ", navn=" + navn + ", sjefId=" + sjefId + "]";
	}

}
