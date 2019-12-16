package br.edu.ifms.TrabalhoFinal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.TrabalhoFinal.model.Passagem;
import br.edu.ifms.TrabalhoFinal.model.Voo;
import br.edu.ifms.TrabalhoFinal.service.AeroportoService;
import br.edu.ifms.TrabalhoFinal.service.AviaoService;
import br.edu.ifms.TrabalhoFinal.service.PassagemService;
import br.edu.ifms.TrabalhoFinal.service.VooService;

@Controller
public class VooController {
	@Autowired
	VooService vooService;
	@Autowired
	AviaoService aviaoService;
	@Autowired
	AeroportoService aeroportoService;
	@Autowired
	PassagemService passagemService;
	
	@GetMapping(value = {"/", "/voos"})
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaVoo");
		
		mv.addObject("voos", vooService.buscarTodos());
		mv.addObject("avioes", aviaoService.buscarTodos());
		mv.addObject("aeroportos", aeroportoService.buscarTodos());
		mv.addObject(new Voo());
		
		return mv;
	}
	
	@PostMapping("/voos")
	public String salvar(Voo voo) {
		vooService.salvar(voo);
		return "redirect:/voos";
	}
	
	@GetMapping("/voos/{id}") 
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("EditaVoo");
		
		mv.addObject(vooService.procurar(id));
		mv.addObject("avioes", aviaoService.buscarTodos());
		mv.addObject("aeroportos", aeroportoService.buscarTodos());
		
		return mv;
	}
	
	@GetMapping("/voos/deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {
		vooService.deletar(id);
		return "redirect:/voos";
	}
	
	
	//DIFERENCIAL ABAIXO
	
	@GetMapping("/voos/checklist/{id}")
	public ModelAndView checklist(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("ChecklistVoo");
		
		mv.addObject("passagens", passagemService.buscarTodos());
		
		return mv;
	}
	
	@GetMapping("/voos/passagem/checkin/{id}")
	public String realizarCheckin(@PathVariable("id") Long id) {
		Passagem passagem = passagemService.procurar(id);
		passagem.setCheckin(true);
		passagemService.salvar(passagem);
		return "redirect:/voos/checklist/"+passagem.getVoo().getId();
	}
	
	@GetMapping("/voos/passagem/deletar/{id}")
	public String deletarPassagem(@PathVariable("id") Long id) {
		Passagem passagem = passagemService.procurar(id);
		long idVoo = passagem.getVoo().getId();
		passagemService.deletar(id);
		return "redirect:/voos/checklist/"+idVoo;
	}
	
	@GetMapping("/voos/passagem/{id}") 
	public ModelAndView comprarPassagem(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("ComprarPassagem");
		
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		Passagem passagem = new Passagem();
		passagem.setVoo(vooService.procurar(id));
		passagem.setData_compra(formatador.format( data ));
		
		mv.addObject(passagem);
		
		return mv;
	}
	
	@PostMapping("/voos/passagem")
	public String salvarPassagem(Passagem passagem) {
		passagemService.salvar(passagem);
		return "redirect:/voos";
	}
	
}
