package br.edu.ifms.dbf2.ProjetoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.dbf2.ProjetoFinal.model.Passagem;
import br.edu.ifms.dbf2.ProjetoFinal.repository.Passagens;

@Service
public class PassagemService {
	
	@Autowired
	private Passagens passagens;
	
	public List<Passagem> buscarTodos() {
		return passagens.findAll();
	}
	
	public void salvar(Passagem passagem) {
		passagens.save(passagem);
	}
	
	public Passagem procurar(Long id) {
		return passagens.getOne(id);
	}
	
	public void deletar(Long id) {
		passagens.deleteById(id);
	}
	
	
	public void comprar(Passagem p){
		
		
	}
}
