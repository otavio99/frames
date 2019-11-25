package br.edu.ifms.dbf2.ProjetoN1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.dbf2.ProjetoN1.model.Carro;
import br.edu.ifms.dbf2.ProjetoN1.model.Multa;
import br.edu.ifms.dbf2.ProjetoN1.repository.Carros;
import br.edu.ifms.dbf2.ProjetoN1.repository.Multas;

@Service
public class MultaService {
	
	@Autowired
	private Multas multas;
	@Autowired
	private Carros carros;
	
	public List<Multa> buscarTodos() {
		return multas.findAll();
	}
	
	public List<String> salvar(Multa multa) {
		Carro carro = carros.findByPlaca(multa.getCarro().getPlaca());
		List<String> mensagens = new ArrayList<>();
		
		if(carro == null) {
			mensagens.add("Carro não encontrado, por favor informe uma placa válida.");
			mensagens.add("alert-danger");
			return mensagens;
		}
		else {
			multa.setCarro(carro);
			multas.save(multa);
			mensagens.add("Multa cadastrada com sucesso.");
			mensagens.add("alert-success");
			return mensagens;
		}
	}
}
