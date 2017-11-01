package br.unincor.exception;

import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;

/**
 * Receber um objeto "Produto" via
 * construtor e implementar o método
 * 'getMessage()' retornando o texto:
 * 
 * "O produto <nome do produto> está com o preço zerado!"
 *
 */
public class PrecoZeradoException extends Exception {
	
	private Produto p;

	public PrecoZeradoException(Produto p) {
		super();
		this.p = p;
	}

	@Override
	public String getMessage() {
		if (p instanceof Sanduiche)
			return "O preço do Sanduiche " + p.getNome() + " está zerado.";
		else if (p instanceof Sobremesa)
			return "O preço da Sobremesa " + p.getNome() + " está zerado.";
		else
			return null;
	}
	
	

}
