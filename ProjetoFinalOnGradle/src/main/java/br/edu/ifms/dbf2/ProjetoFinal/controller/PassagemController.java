package br.edu.ifms.dbf2.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoFinal.model.Passagem;
import br.edu.ifms.dbf2.ProjetoFinal.service.PassagemService;

@Controller
public class PassagemController {
	
	@Autowired
	private PassagemService passagemService;
	
	@GetMapping("/passagens") 
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Passagens");
		
		modelAndView.addObject("passagens", passagemService.buscarTodos());
		modelAndView.addObject(new Passagem());
		
		return modelAndView; 
	}
	
	@PostMapping("/passagens")
	public String salvar(Passagem passagem) {
		passagemService.salvar(passagem);
		return "redirect:/passagens";
	}
	
	@GetMapping("/passagem/{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("EditaPassagem");
		modelAndView.addObject(passagemService.procurar(id));
		
		return modelAndView;
	}
	
	@GetMapping("/passagem/deletar/{id}") 
	public String deletar(@PathVariable("id") Long id) {
		passagemService.deletar(id);
		
		return "redirect:/passagens";
	}
	
	@GetMapping("/passagem/deletar/confirmacao/{id}") 
	public ModelAndView deletarAcessarConfirmacao(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("DeletaPassagem");
		modelAndView.addObject(passagemService.procurar(id));
		
		return modelAndView;
	}
	
	///////
	
	@PostMapping("/passagem/compra")
	public String compra(Passagem passagem) {
		passagemService.compra(passagem);
		return "redirect:/passagens";
	}

}
