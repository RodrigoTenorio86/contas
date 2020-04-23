package br.com.caelum.contas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	//@Autowired
	private ContaDAO dao = new ContaDAO();

	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {
		// se tiver erro, redirecione para o formulário
		if(result.hasErrors()) {
			return "formulario";
		}
		
		dao.adiciona(conta);
		return "conta-adicionada";
	}
	
	@RequestMapping(value = "/form")
	public String form() {
		return "formulario";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista() {
		List<Conta> contas =dao.lista();
		
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("contas",contas);
		return mv;
	}
	
	@RequestMapping("/removeConta")
	public String remove(Conta conta) {
		dao.remove(conta);
		return "redirect:listaContas";
		//return "formard:listaContas";
	}
	@RequestMapping("/mostraConta")
	public String mostra(Long id, Model model) {
		model.addAttribute("conta", dao.buscaPorId(id));		
		return "conta/mostra";
	}
	@RequestMapping("/alteraConta")
	public String altera(Conta Conta) {
		dao.altera(Conta);
		return "redirect:listaContas";
	}
	
}
