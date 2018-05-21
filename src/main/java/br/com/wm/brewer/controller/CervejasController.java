package br.com.wm.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.wm.brewer.model.Cerveja;
import br.com.wm.brewer.model.Origem;
import br.com.wm.brewer.model.Sabor;
import br.com.wm.brewer.repository.Estilos;

@Controller
public class CervejasController {
	
	//@Autowired
	//private Cervejas cervejas;
	
	@Autowired
	private Estilos estilos;
	
	//private static Logger logger = LoggerFactory.getLogger(CervejasController.class);
	
	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}

//	@RequestMapping("/cervejas/novo")
//	public String novo(Cerveja cerveja) {
//		//logger.info("Teste info");
//		//logger.debug("Teste debug");
//		
//		Optional<Cerveja> cervejaOptional = cervejas.findBySkuIgnoreCase("AAA111"); //apagar
//		System.out.println(cervejaOptional.isPresent());
//		
//		return "cerveja/CadastroCerveja";
//	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		/*if (result.hasErrors()) {
			return novo(cerveja);
		}*/
	
		// Salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		System.out.println(">>> sku: " + cerveja.getSku());
		System.out.println(">>> sabor: " + cerveja.getSabor());
		System.out.println(">>> Origem: " + cerveja.getOrigem());
		
		System.out.println("cerveja.getEstilo(): " + cerveja.getEstilo());
		if (cerveja.getEstilo() != null)
			System.out.println(">>> Estilo: " + cerveja.getEstilo().getCodigo());
		
		return new ModelAndView("redirect:/cervejas/novo");
	}
	
}
