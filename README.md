# Howtos
1. Standard Expressions

  Model e View.

2. Fragments

  Criando fragmentos e componentes html.

---
1 - Standard Expressions

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
2 - Fragments

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
