package br.edu.ifms.dbf2.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.dbf2.ProjetoN1.model.TipoInfracao;
import br.edu.ifms.dbf2.ProjetoN1.repository.TipoInfracoes;

@Service
public class TipoInfracaoService {
	
	@Autowired
	private TipoInfracoes tipoInfracoes;
	
	public List<TipoInfracao> buscarTodos() {
		return tipoInfracoes.findAll();
	}
	
	public void salvar(TipoInfracao tipoInfracao) {
		tipoInfracoes.save(tipoInfracao);
	}
	
}
