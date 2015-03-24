# Howtos
1. Standard Expressions

  Model e View.

2. Fragments

  Criando fragmentos e componentes html.

---

ThymeleafController.java
``` java
package br.com.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springmvc.modelo.Itens;

@Controller
public class ThymeleafController {

	@RequestMapping("/standartExpressions")
	public String thymeleaf(Model model) {
		Itens item1 = new Itens("Item 1", "Descrição Item 1", 1);
		Itens item2 = new Itens("Item 2", "Descrição Item 2", 2);
		Itens item3 = new Itens("Item 3", "Descrição Item 3", 3);
		model.addAttribute("itens", new ArrayList<Itens>(Arrays.asList(item1, item2, item3)));
		model.addAttribute("atributo", "Atributo recuperado com sucesso!");
		return "standartExpressions";
	}
	
	@RequestMapping("/fragments")
	public String fragments(Model model) {
		Itens item1 = new Itens("Item 1", "Descrição Item 1", 1);
		Itens item2 = new Itens("Item 2", "Descrição Item 2", 2);
		Itens item3 = new Itens("Item 3", "Descrição Item 3", 3);
		model.addAttribute("itens", new ArrayList<Itens>(Arrays.asList(item1, item2, item3)));
		model.addAttribute("content", "content1");
		return "fragments";
	}
}
```

1 - Standard Expressions

StandardExpressionsController.java
``` java
package br.com.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springmvc.modelo.Itens;

@Controller
public class StandardExpressionsController {

	@RequestMapping("/standartExpressions")
	public String thymeleaf(Model model) {
		Itens item1 = new Itens("Item 1", "Descrição Item 1", 1);
		Itens item2 = new Itens("Item 2", "Descrição Item 2", 2);
		Itens item3 = new Itens("Item 3", "Descrição Item 3", 3);
		model.addAttribute("itens", new ArrayList<Itens>(Arrays.asList(item1, item2, item3)));
		model.addAttribute("atributo", "Atributo recuperado com sucesso!");
		return "standardExpressions";
	}
}
```

standartExpressions.html
``` html
<!DOCTYPE html>
<html>
	<body>
		<p>Variáveis: <th th:text="${atributo}">variaveis</th></p>
		<p>Mensagens: <th th:text="#{mensagem}">mensagens</th></p>
		<p>Link: <a th:href="@{http://www.thymeleaf.org}">Link</a></p>
		<p>Iterando numa lista: </p>
		<ul>
			<li th:each="item : ${itens}">
				<span th:text="*{item.nome}">Nome</span>
				<span th:text="*{item.descricao}">Descrição</span>
				<span th:text="*{item.valor}">Valor</span>
			</li>
		</ul>
	</body>
</html>
```

Itens.java
``` java
package br.com.springmvc.modelo;

public class Itens {
	private String nome;
	private String descricao;
	private Integer valor;
	
	public Itens(String nome, String descricao, Integer valor) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
}
```
2 - Fragments

FragmentsController.java
``` java
package br.com.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springmvc.modelo.Itens;

@Controller
public class FragmentsController {
	
	@RequestMapping("/fragments")
	public String fragments(Model model) {
		Itens item1 = new Itens("Item 1", "Descrição Item 1", 1);
		Itens item2 = new Itens("Item 2", "Descrição Item 2", 2);
		Itens item3 = new Itens("Item 3", "Descrição Item 3", 3);
		model.addAttribute("itens", new ArrayList<Itens>(Arrays.asList(item1, item2, item3)));
		model.addAttribute("content", "content1");
		return "fragments";
	}

}

```

fragments.html
``` html
<!DOCTYPE html>
<html>
	<head>
		<th th:include="fragments/head" />
	</head>
	<body>
		<div th:include="fragments/header">Cabeçalho da página</div>
		<div th:include="'fragments/pages/' + ${content}">Conteúdo da página.</div>
		<div th:include="fragments/footer">Rodapé da página.</div>
		<div th:replace="fragments/table :: table (${new String[]{'item1', 'item2', 'item3'}}, ${itens})">Tabela</div>
	</body>
</html>
```
