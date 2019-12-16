package br.edu.ifms.dbf2.ProjetoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.dbf2.ProjetoFinal.model.Aviao;
import br.edu.ifms.dbf2.ProjetoFinal.repository.Avioes;

@Service
public class AviaoService {
	
	@Autowired
	private Avioes avioes;
	
	public List<Aviao> buscarTodos() {
		return avioes.findAll();
	}
	
	public void salvar(Aviao aviao) {
		avioes.save(aviao);
	}
	
	public Aviao procurar(Long id) {
		return avioes.getOne(id);
	}
	
	public void deletar(Long id) {
		avioes.deleteById(id);
	}
}
