package br.edu.ifms.dbf2.ProjetoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.dbf2.ProjetoFinal.model.Voo;
import br.edu.ifms.dbf2.ProjetoFinal.repository.Voos;

@Service
public class VooService {
	
	@Autowired
	private Voos voos;
	
	public List<Voo> buscarTodos() {
		return voos.findAll();
	}
	
	public void salvar(Voo voo) {
		voos.save(voo);
	}
	
	public Voo procurar(Long id) {
		return voos.getOne(id);
	}
	
	public void deletar(Long id) {
		voos.deleteById(id);
	}
	
	/////
	
}
