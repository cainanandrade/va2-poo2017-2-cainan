package br.unincor.controle;

import java.util.ArrayList;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;

public class CalculoPrecos {
	
	public void calculaPrecoFinal(Produto p) throws PrecoZeradoException{
		if (p instanceof Sanduiche){
			if (((Sanduiche) p).getTrio() == true)
				p.setPreco(p.getPreco() + 20.0);
			else
				p.setPreco(p.getPreco());
			
			if (((Sanduiche) p).getDobroRecheio() == true)
				p.setPreco(p.getPreco() + ((p.getPreco()*40)/100));
			else 
				p.setPreco(p.getPreco());
		}
		
		else if (p instanceof Sobremesa){
			if (((Sobremesa) p).getAdicionais() == true)
				p.setPreco(p.getPreco() + ((p.getPreco()*5)/100));
			else
				p.setPreco(p.getPreco());
		}
		
		else if (p == null){
			throw new PrecoZeradoException(p);
		}
	}
	
	/**
	 * No pagamento em dinheiro após o calculo final do preço, dar desconto de XX%.
	 */
	public Double pagtoDinheiro(ArrayList<Produto> lista) throws PrecoZeradoException {
		Double precoFinal = 0.0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getPreco() > 0)
				precoFinal += lista.get(i).getPreco();
			else
				throw new PrecoZeradoException(lista.get(i));
		}
		
		precoFinal = precoFinal - ((precoFinal*5)/100);
		
		return precoFinal;
	}
	
	/**
	 * No pagamento em dinheiro após o calculo final do preço, acrescer XX% no valor do preço.
	 */
	public Double pagtoCartao(ArrayList<Produto> lista) throws PrecoZeradoException {
		Double precoFinal = 0.0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getPreco() > 0)
				precoFinal += lista.get(i).getPreco();
			else
				throw new PrecoZeradoException(lista.get(i));
		}
		
		precoFinal = precoFinal + ((precoFinal*10)/100);
		
		return precoFinal;
	}

}
