package it.dstech.computers.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Voto extends Base{
	@Column(name="voto", nullable=false , unique = false)
	private Double voto;

	public Double getVoto() {
		return voto;
	}

	public void setVoto(Double voto) {
		this.voto = voto;
	}
	

}
