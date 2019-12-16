package br.edu.ifms.TrabalhoFinal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voos")
public class Voo {
	@Id
	@GeneratedValue
	private long id;
	private String compania;
	private String horario;
	@OneToOne
	private Aviao aviao;
	@OneToMany(mappedBy = "voo")
	private List<Passagem> passagens;
	@ManyToOne
	@JoinColumn(name="idAeroportoPartida")
	private Aeroporto aeroportoPartida;
	@ManyToOne
	@JoinColumn(name="idAeroportoChegada")
	private Aeroporto aeroportoChegada;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Aviao getAviao() {
		return aviao;
	}
	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}
	public List<Passagem> getPassagens() {
		return passagens;
	}
	public void setPassagens(List<Passagem> passagens) {
		this.passagens = passagens;
	}
	public Aeroporto getAeroportoPartida() {
		return aeroportoPartida;
	}
	public void setAeroportoPartida(Aeroporto aeroportoPartida) {
		this.aeroportoPartida = aeroportoPartida;
	}
	public Aeroporto getAeroportoChegada() {
		return aeroportoChegada;
	}
	public void setAeroportoChegada(Aeroporto aeroportoChegada) {
		this.aeroportoChegada = aeroportoChegada;
	}
}
