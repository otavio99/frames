package br.edu.ifms.TrabalhoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.TrabalhoFinal.model.Aeroporto;
import br.edu.ifms.TrabalhoFinal.service.AeroportoService;

@Controller
public class AeroportoController {
	@Autowired
	AeroportoService aeroportoService;
	
	@GetMapping("/aeroportos")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaAeroporto");
		
		mv.addObject("aeroportos", aeroportoService.buscarTodos());
		mv.addObject(new Aeroporto());
		
		return mv;
	}
	
	@PostMapping("/aeroportos")
	public String salvar(Aeroporto aeroporto) {
		aeroportoService.salvar(aeroporto);
		return "redirect:/aeroportos";
	}
	
	@GetMapping("/aeroportos/{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("EditaAeroporto");
		
		modelAndView.addObject(aeroportoService.procurar(id));
		
		return modelAndView;
	}
	
	@GetMapping("/aeroportos/deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {
		aeroportoService.deletar(id);
		return "redirect:/aeroportos";
	}
}
