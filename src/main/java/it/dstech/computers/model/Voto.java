package it.dstech.computers.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Voto extends Base{
	
	@Column(name = "voto", nullable=false , unique = true)
	private Double voto;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "voti")
	@JsonIgnore
	private List<Partita> partite;

	public Double getVoto() {
		return voto;
	}

	public void setVoto(Double voto) {
		this.voto = voto;
	}

	/**
	 * @return the partite
	 */
	public List<Partita> getPartite() {
		return partite;
	}

	/**
	 * @param partite the partite to set
	 */
	public void setPartite(List<Partita> partite) {
		this.partite = partite;
	}
	

}
