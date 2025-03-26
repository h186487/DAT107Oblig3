package oblig3;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
// @NamedQuery(name = "hentAllePersoner", query ="SELECT p FROM Person as p
// order by p.id")

public class Ansatt {
<<<<<<< Updated upstream
//test??
=======

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansatt_id;

	private String brukernavn;
	private String fornavn;
	private String etternavn;

	private Date dato_ansettelse;

	private String stilling;
	private double manedslonn;
	private int avdeling_id;
	
	// fjerne avdelingId herfra seinere og legge til 
	 // Fremmednøkkel for Avdeling
//    @ManyToOne
//    @JoinColumn(name = "avdelingId", referencedColumnName = "AvdelingId", nullable = false)
//    private Avdeling avdeling; // Relasjon til Avdeling

	public Ansatt() {

	}

	public Ansatt(String brukernavn, String fornavn, String etternavn, Date dato_ansettelse,
			String stilling, double manedslonn, int avdeling_id) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.dato_ansettelse = dato_ansettelse;
		this.stilling = stilling;
		this.manedslonn = manedslonn;
		this.avdeling_id = avdeling_id;
	}

	public int getAnsattId() {
		return ansatt_id;
	}

	public void setAnsattId(int ansattId) {
		this.ansatt_id = ansattId;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Date getDatoAnsettelse() {
		return dato_ansettelse;
	}

	public void setDatoAnsettelse(Date dato_ansettelse) {
		this.dato_ansettelse = dato_ansettelse;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public double getManedslonn() {
		return manedslonn;
	}

	public void setManedslonn(double manedslonn) {
		this.manedslonn = manedslonn;
	}

	public int getAvdelingId() {
		return avdeling_id;
	}

	public void setAvdelingId(int avdeling_id) {
		this.avdeling_id = avdeling_id;
	}

	@Override
	public String toString() {
		return "Ansatt [ansattId=" + ansatt_id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansettelseDato=" + dato_ansettelse + ", stilling=" + stilling + ", manedslonn="
				+ manedslonn + ", avdelingId=" + avdeling_id + "]";
	}

	public void skrivUt() {
		// TODO Auto-generated method stub
		
	}

	

>>>>>>> Stashed changes
}
