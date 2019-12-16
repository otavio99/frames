package br.edu.ifms.TrabalhoFinal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aeroportos")
public class Aeroporto {
	@Id
	@GeneratedValue
	private long id;
	private String codigo;
	private String nome;
	private String localizacao;
	
	@OneToMany(mappedBy = "aeroportoPartida")
	private List<Voo> voosPartida;
	@OneToMany(mappedBy = "aeroportoChegada")
	private List<Voo> voosChegada;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public List<Voo> getVoosPartida() {
		return voosPartida;
	}
	public void setVoosPartida(List<Voo> voosPartida) {
		this.voosPartida = voosPartida;
	}
	public List<Voo> getVoosChegada() {
		return voosChegada;
	}
	public void setVoosChegada(List<Voo> voosChegada) {
		this.voosChegada = voosChegada;
	}
}
