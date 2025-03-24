package oblig3;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
// @NamedQuery(name = "hentAllePersoner", query ="SELECT p FROM Person as p
// order by p.id")

public class Ansatt {

	@Id
	private int ansattId;

	private String brukernavn;
	private String fornavn;
	private String etternavn;

	private Date ansettelseDato;

	private String stilling;
	private double manedslonn;
	private int avdelingId;
	
	// fjerne avdelingId herfra seinere og legge til 
	 // Fremmednøkkel for Avdeling
//    @ManyToOne
//    @JoinColumn(name = "avdelingId", referencedColumnName = "AvdelingId", nullable = false)
//    private Avdeling avdeling; // Relasjon til Avdeling

	public Ansatt() {

	}

	public Ansatt(int ansattId, String brukernavn, String fornavn, String etternavn, Date ansettelseDato,
			String stilling, double manedslonn, int avdelingId) {
		this.ansattId = ansattId;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelseDato = ansettelseDato;
		this.stilling = stilling;
		this.manedslonn = manedslonn;
		this.avdelingId = avdelingId;
	}

	public int getAnsattId() {
		return ansattId;
	}

	public void setAnsattId(int ansattId) {
		this.ansattId = ansattId;
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
		return ansettelseDato;
	}

	public void setDatoAnsettelse(Date ansettelseDato) {
		this.ansettelseDato = ansettelseDato;
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
		return avdelingId;
	}

	public void setAvdelingId(int avdelingId) {
		this.avdelingId = avdelingId;
	}

	@Override
	public String toString() {
		return "Ansatt [ansattId=" + ansattId + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansettelseDato=" + ansettelseDato + ", stilling=" + stilling + ", manedslonn="
				+ manedslonn + ", avdelingId=" + avdelingId + "]";
	}

	

}
