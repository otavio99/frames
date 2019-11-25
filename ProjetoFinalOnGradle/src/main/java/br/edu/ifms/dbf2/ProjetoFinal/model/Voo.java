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
public class Voo implements Serializable {
	@Id
	@GeneratedValue
	private Long id_voo;
    private String compania;
    private String horario;
}
