package oblig3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")

public class Prosjektdeltagelse {

	@Id
	@ManyToOne
	@JoinColumn(name = "ansattId")
	private Ansatt ansatt;

	@Id
	@ManyToOne
	@JoinColumn(name = "prosjektId")
	private Prosjekt prosjekt;

	private String rolle;
	private double timer;

	public Prosjektdeltagelse() {
	}

	public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt, String rolle) {
		this.ansatt = ansatt;
		this.prosjekt = prosjekt;
		this.rolle = rolle;
		this.timer = 0;
	}

	public Ansatt getAnsatt() {
		return ansatt;
	}

	public void setAnsatt(Ansatt ansatt) {
		this.ansatt = ansatt;
	}

	public Prosjekt getProsjekt() {
		return prosjekt;
	}

	public void setProsjekt(Prosjekt prosjekt) {
		this.prosjekt = prosjekt;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public double getTimer() {
		return timer;
	}

	public void setTimer(double timer) {
		this.timer = timer;
	}

	@Override
	public String toString() {
		return "Prosjektdeltagelse [ansatt=" + ansatt + ", prosjekt=" + prosjekt + ", rolle=" + rolle + ", timer="
				+ timer + "]";
	}

}
