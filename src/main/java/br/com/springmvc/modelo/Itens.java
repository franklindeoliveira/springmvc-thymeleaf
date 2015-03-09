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
