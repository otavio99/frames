package br.edu.ifms.dbf2.ProjetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoFinal.model.Voo;
import br.edu.ifms.dbf2.ProjetoFinal.model.Passagem;
import br.edu.ifms.dbf2.ProjetoFinal.service.VooService;
import br.edu.ifms.dbf2.ProjetoFinal.service.AeroportoService;
import br.edu.ifms.dbf2.ProjetoFinal.service.AviaoService;

@Controller
public class VooController {
	
	@Autowired
	private VooService vooService;
	
	@Autowired
	private AeroportoService aeroportoService;
	
	@Autowired
	private AviaoService aviaoService;
	
	@GetMapping("/") 
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Voos");
		
		modelAndView.addObject("voos", vooService.buscarTodos());
		modelAndView.addObject("avioes", aviaoService.buscarTodos());
		modelAndView.addObject("aeroportos", aeroportoService.buscarTodos());
		modelAndView.addObject(new Voo());
		
		return modelAndView; 
	}
	
	@PostMapping("/voos")
	public String salvar(Voo voo) {
		vooService.salvar(voo);
		return "redirect:/";
	}
	
	@GetMapping("/voo/{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("EditaVoo");
		modelAndView.addObject(vooService.procurar(id));
		
		return modelAndView;
	}
	
	@GetMapping("/voo/deletar/{id}") 
	public String deletar(@PathVariable("id") Long id) {
		vooService.deletar(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/voo/deletar/confirmacao/{id}") 
	public ModelAndView deletarAcessarConfirmacao(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("DeletaVoo");
		modelAndView.addObject(vooService.procurar(id));
		
		return modelAndView;
	}
	
	//////////
	
	@GetMapping("/voos/passagem/{id}") 
	public ModelAndView comprarPassagemView(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("ComprarPassagemView");
		
		Date data = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		
		Passagem passagem = new Passagem();
		passagem.setVoo(vooService.procurar(id));
		passagem.setData_compra(f.format( data ));
		
		modelAndView.addObject(passagem);
		
		return modelAndView;
	}
	
	
}
