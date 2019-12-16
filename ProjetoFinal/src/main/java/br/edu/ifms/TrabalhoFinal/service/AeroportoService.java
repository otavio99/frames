package br.edu.ifms.TrabalhoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.TrabalhoFinal.model.Aeroporto;
import br.edu.ifms.TrabalhoFinal.repository.Aeroportos;

@Service
public class AeroportoService {
	@Autowired
	private Aeroportos aeroportos;
	
	public List<Aeroporto> buscarTodos(){
		return aeroportos.findAll();
	}
	
	public void salvar(Aeroporto aeroporto) {
		aeroportos.save(aeroporto);
	}
	
	public Aeroporto procurar(Long id) {
		return aeroportos.getOne(id);
	}
	
	public void deletar(Long id) {
		aeroportos.deleteById(id);
	}
}
