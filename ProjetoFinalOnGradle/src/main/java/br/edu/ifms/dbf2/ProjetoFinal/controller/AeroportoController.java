package br.edu.ifms.dbf2.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoFinal.model.Aeroporto;
import br.edu.ifms.dbf2.ProjetoFinal.service.AeroportoService;

@Controller
public class AeroportoController {
	
	@Autowired
	private AeroportoService aeroportoService;
	
	@GetMapping("/aeroportos") 
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Aeroportos");
		
		modelAndView.addObject("aeroportos", aeroportoService.buscarTodos());
		modelAndView.addObject(new Aeroporto());
		
		return modelAndView; 
	}
	
	@PostMapping("/aeroportos")
	public String salvar(Aeroporto aeropoto) {
		aeroportoService.salvar(aeropoto);
		return "redirect:/aeroportos";
	}
	
	@GetMapping("/aeroporto/{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("EditaAeroporto");
		modelAndView.addObject(aeroportoService.procurar(id));
		
		return modelAndView;
	}
	
	@GetMapping("/aeroporto/deletar/{id}") 
	public String deletar(@PathVariable("id") Long id) {
		aeroportoService.deletar(id);
		
		return "redirect:/aeroportos";
	}
	
	@GetMapping("/aeroporto/deletar/confirmacao/{id}") 
	public ModelAndView deletarAcessarConfirmacao(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("DeletaAeroporto");
		modelAndView.addObject(aeroportoService.procurar(id));
		
		return modelAndView;
	}

}
