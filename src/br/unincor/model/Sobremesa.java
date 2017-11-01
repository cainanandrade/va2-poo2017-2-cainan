package br.unincor.model;

/**
 * Implementar relacionamento de herança
 * com a classe "Produto"
 *
 */
public class Sobremesa extends Produto{
	
	public Sobremesa(String nome, Double preco, Boolean adicionais) {
		super(nome, preco);
		this.adicionais = adicionais;
	}

	private Boolean adicionais;
	/** Criar um construtor que recebe todos os atributos como parâmetro **/

	/** Criar getters e setters **/

	/** Implementar para mostrar os valores de todos os atributos **/

	public Boolean getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(Boolean adicionais) {
		this.adicionais = adicionais;
	}
	
	@Override
	public String verDados() {
		// TODO Auto-generated method stub
		return super.verDados() + "\nAdicionais: " + this.adicionais;
	}
}
