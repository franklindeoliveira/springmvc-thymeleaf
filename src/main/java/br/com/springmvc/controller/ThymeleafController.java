package br.com.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springmvc.modelo.Itens;

@Controller
public class ThymeleafController {

	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		Itens item1 = new Itens("Item 1", "Descrição Item 1", 1);
		Itens item2 = new Itens("Item 2", "Descrição Item 2", 2);
		Itens item3 = new Itens("Item 3", "Descrição Item 3", 3);
		model.addAttribute("itens", new ArrayList<Itens>(Arrays.asList(item1, item2, item3)));
		model.addAttribute("atributo", "Atributo recuperado com sucesso!");
		return "thymeleaf";
	}
	
	@RequestMapping("/fragments")
	public String fragments(Model model) {
		model.addAttribute("content", "content1");
		return "fragments";
	}
}
