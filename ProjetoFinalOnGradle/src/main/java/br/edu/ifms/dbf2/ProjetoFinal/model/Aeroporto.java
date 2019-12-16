package br.edu.ifms.dbf2.ProjetoFinal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity(name = "Aeroporto")
@Table(name = "aeroporto")
@Getter @Setter @NoArgsConstructor
public class Aeroporto implements Serializable {
	@Id
	@GeneratedValue
	private Long id_aeroporto;
	private String codigo;
	private String nome;
	private String localizacao;
	
	
	@OneToMany(
			mappedBy = "aeroportoChegada",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Voo> voosChegada = new ArrayList<>();

	@OneToMany(
			mappedBy = "aeroportoPartida",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Voo> voosPartida = new ArrayList<>();

}
