package br.unincor.controle;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;
import br.unincor.view.Usuario;

public class Main {

	public static void main(String[] args) {
		Usuario view = new Usuario();
		
		Integer opcao = view.exibeMenuPrincipal();
		
		ArrayList<Produto> listaCompras = new ArrayList<Produto>();
		
		CalculoPrecos cp = new CalculoPrecos();
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		while(opcao < 3){
			switch (opcao){
			
			case 0:
				Sanduiche sanduba = new Sanduiche("SANDUICHE: " + 
			view.recebeTexto("Digite o nome do Sanduiche: "), 
			/*(Math.random()*15-5)*/ 20.0, true, true);
				///view.exibeMsg(sanduba.verDados());
				listaCompras.add(sanduba);
				break;
			
			case 1:
				Sobremesa sobremesa = new Sobremesa("SOBREMESA: " +
						view.recebeTexto("Digite o nome da sobremesa: "),
						/*(Math.random()*15-5)*/ 10.0, true);
				listaCompras.add(sobremesa);
				break;
			
			case 2:				
				try {
					
					if (listaCompras.isEmpty())
						view.exibeMsg("Você ainda não comprou nada!!");
					else{
					
					Integer opcoes = view.exibeMenuPagamento();
					
					for (int i = 0; i < listaCompras.size(); i++) {
						cp.calculaPrecoFinal(listaCompras.get(i));						
					}
					
					if (opcoes == 1){
						String resumoPedido = null;
						for (int i = 0; i < listaCompras.size(); i++) {
							resumoPedido += listaCompras.get(i).verDados() + "\n\n";
						}
						
						view.exibeMsg("RESUMO DO PEDIDO: \n" + resumoPedido + 
								"\n\nPreço Final: " + df.format(cp.pagtoCartao(listaCompras)));
					}
					
					else{
						String resumoPedido = null;
						for (int i = 0; i < listaCompras.size(); i++) {
							resumoPedido += listaCompras.get(i).verDados() + "\n\n";
						}
						
						view.exibeMsg("RESUMO DO PEDIDO: \n" + resumoPedido + 
								"\n\nPreço Final: " + df.format(cp.pagtoDinheiro(listaCompras)));
					}
					
					System.exit(0);
					
					
					}
					
					break;
					
				} catch (PrecoZeradoException e) {
					view.exibeMsgErro("ERRO COM O PRODUTO \n\n" + e.getMessage());
				}				
				break;
				
			case -1:				
				try {
					
					if (listaCompras.isEmpty())
						view.exibeMsg("Você ainda não comprou nada!!");
					else{
					
					Integer opcoes = view.exibeMenuPagamento();
					
					for (int i = 0; i < listaCompras.size(); i++) {
						cp.calculaPrecoFinal(listaCompras.get(i));						
					}
					
					if (opcoes == 1){
						String resumoPedido = null;
						for (int i = 0; i < listaCompras.size(); i++) {
							resumoPedido += listaCompras.get(i).verDados() + "\n\n";
						}
						
						view.exibeMsg("RESUMO DO PEDIDO: \n" + resumoPedido + 
								"\n\nPreço Final: " + df.format(cp.pagtoCartao(listaCompras)));
					}
					
					else{
						String resumoPedido = null;
						for (int i = 0; i < listaCompras.size(); i++) {
							resumoPedido += listaCompras.get(i).verDados() + "\n\n";
						}
						
						view.exibeMsg("RESUMO DO PEDIDO: \n" + resumoPedido + 
								"\n\nPreço Final: " + df.format(cp.pagtoDinheiro(listaCompras)));
					}
					
					System.exit(0);
					
					
					}
					
					break;
					
				} catch (PrecoZeradoException e) {
					view.exibeMsgErro("ERRO COM O PRODUTO \n\n" + e.getMessage());
				}				
				break;
				
			
			}
			
			opcao = view.exibeMenuPrincipal();
			
			
		}
		
	}
}