package br.unincor.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * Nesta classe você deve tratar exceção em todos os métodos que podem vir a
 * lançar exceções por entrada incorreta do usuário e remover os métodos não
 * utilizados.
 *
 */
public class Usuario {
	
	public void exibeMsg(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}

	public void exibeMsgErro(String texto) {
		JOptionPane.showMessageDialog(null, texto, "ERRO", 
				JOptionPane.ERROR_MESSAGE);
	}

	public Integer exibeMenuPrincipal() {
		Object[] opcoes = { "Sanduiche", "Sobremesa", "Finalizar pedido" };
		Integer op = JOptionPane.showOptionDialog(null,
												"Escolha o produto",
												"Menu Principal",
												JOptionPane.DEFAULT_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null,
												opcoes,
												2);

		return op;
	}

	public Integer exibeMenuPagamento() {
		Object[] opcoes = { "Dinheiro", "Cartão" };
		Integer op = JOptionPane.showOptionDialog(null,
												"Forma de Pagamento",
												"Pagamento",
												JOptionPane.DEFAULT_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null,
												opcoes,
												0);

		return op;
	}

	public Integer recebeInteiro(String texto) {
		return Integer.parseInt(JOptionPane.showInputDialog(texto));
	}

	public String recebeTexto(String texto) {
		return JOptionPane.showInputDialog(texto);
	}
}
