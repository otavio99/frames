package br.edu.ifms.dbf2.ProjetoFinal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter @Setter @NoArgsConstructor
public class Aviao implements Serializable {
	@Id
	@GeneratedValue
	private Long id_aviao;
	private int numero;
	private String fabricante;
	private int capacidade;
	private String tipo;
	@OneToOne
	private Voo voo;
}
