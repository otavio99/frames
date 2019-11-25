package br.edu.ifms.dbf2.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoFinal.model.Aeroporto;

@Controller
public class AeroportoController {
	
	//@Autowired
	//private CarroService carroService;
	
	@GetMapping("/") 
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Aeroportos");
		
		//modelAndView.addObject("carros", carroService.buscarTodos());
		modelAndView.addObject(new Aeroporto());
		
		return modelAndView; 
	}
	


}
