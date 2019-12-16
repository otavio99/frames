package br.edu.ifms.TrabalhoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.TrabalhoFinal.model.Aviao;
import br.edu.ifms.TrabalhoFinal.service.AviaoService;

@Controller
public class AviaoController {
	@Autowired
	AviaoService aviaoService;
	
	@GetMapping("/avioes")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaAviao");
		
		mv.addObject("avioes", aviaoService.buscarTodos());
		mv.addObject(new Aviao());
		
		return mv;
	}
	
	@PostMapping("/avioes")
	public String salvar(Aviao aviao) {
		aviaoService.salvar(aviao);
		return "redirect:/avioes";
	}
	
	@GetMapping("/avioes/{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("EditaAviao");
		
		modelAndView.addObject(aviaoService.procurar(id));
		
		return modelAndView;
	}
	
	@GetMapping("/avioes/deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {
		aviaoService.deletar(id);
		return "redirect:/avioes";
	}
}
