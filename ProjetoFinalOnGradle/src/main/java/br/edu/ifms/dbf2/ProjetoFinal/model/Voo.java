package br.edu.ifms.dbf2.ProjetoFinal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity(name = "Voo")
@Table(name = "voo")
@Getter @Setter @NoArgsConstructor
public class Voo implements Serializable {
	@Id
	@GeneratedValue
	private Long id_voo;
	private String compania;
	private String horario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aeroportoChegada", nullable=false)
	private Aeroporto aeroportoChegada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aeroportoPartida", nullable=false)
	private Aeroporto aeroportoPartida;
	
	@OneToMany(
		mappedBy = "voo",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private List<Passagem> passagens = new ArrayList<>();
	
	@OneToOne
	private Aviao aviao;
}
