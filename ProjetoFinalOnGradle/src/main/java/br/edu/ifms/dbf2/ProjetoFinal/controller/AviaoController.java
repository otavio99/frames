package br.edu.ifms.dbf2.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoFinal.model.Aviao;
import br.edu.ifms.dbf2.ProjetoFinal.service.AviaoService;

@Controller
public class AviaoController {
	
	@Autowired
	private AviaoService aviaoService;
	
	@GetMapping("/avioes") 
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Avioes");
		
		modelAndView.addObject("avioes", aviaoService.buscarTodos());
		modelAndView.addObject(new Aviao());
		
		return modelAndView; 
	}
	
	@PostMapping("/avioes")
	public String salvar(Aviao aviao) {
		aviaoService.salvar(aviao);
		return "redirect:/avioes";
	}
	
	@GetMapping("/aviao/{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("EditaAviao");
		modelAndView.addObject(aviaoService.procurar(id));
		
		return modelAndView;
	}
	
	@GetMapping("/aviao/deletar/{id}") 
	public String deletar(@PathVariable("id") Long id) {
		aviaoService.deletar(id);
		
		return "redirect:/avioes";
	}
	
	@GetMapping("/aviao/deletar/confirmacao/{id}") 
	public ModelAndView deletarAcessarConfirmacao(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("DeletaAviao");
		modelAndView.addObject(aviaoService.procurar(id));
		
		return modelAndView;
	}

}
