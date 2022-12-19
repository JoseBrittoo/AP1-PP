// Alessandra, Francisca e José Nilson 


import javax.swing.JOptionPane;


public class Principal {

	public static void main(String[] args) {
	Espaco e = new Espaco();
	
	e.criarEspaco();
	
	e.inserirJogador();
	
	e.inserirNaveInimiga();
	System.out.println("\n");
	
	//Declaração de variáveis.
	int a = 0;
	String b;
	
	JOptionPane.showMessageDialog(null, "Olá! Seja bem vindo ao jogo!");
	a = Integer.parseInt(JOptionPane.showInputDialog("Para iniciar o jogo digite 1"));

	//Laço de repetição onde se o jogador decidir jogar(iniciar jogo) a estrutura fará o teste entre as possíveis entradas de movimentação
	while(a != 0) {
		e.atualizacao(); //Esse método é chamado para atualizar o espaço e posição do jogador e inimigo.
		e.colidir(); //No dia da apresentação houve um bug nessa linha de código, mas era a posição, e já corrigimos.
		b = JOptionPane.showInputDialog(" Digite 8 para cima\n Digite 2 para baixo\n"
				+ " Digite 4 para esquerda\n Digite 6 para direita\n Digite 5 para atirar\n Digite 0 para sair do jogo");
		int entradaB = Integer.parseInt(b);
		if(entradaB == 8) {
			e.cima();
		}else if(entradaB == 2) {
			e.baixo();
		}else if(entradaB == 4) {
			e.esquerdo();
		}else if(entradaB == 6) {
			e.direito();
		}else if(entradaB == 5) {
			e.atirar();
		}else if(entradaB == 0) {
			JOptionPane.showMessageDialog(null, "Você saiu do jogo!");
			break;
		}
		e.colidir();
		e.vidaJogador();
		e.energiaInimigo();
		e.inserirNaveInimiga();	
	}
	}

}
