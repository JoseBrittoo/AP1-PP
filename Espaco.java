// Alessandra, Francisca e José Nilson 

import javax.swing.JOptionPane;

public class Espaco {
	String [][] esp = new String [10][10];
	
	EnemyShip ship = new EnemyShip();
	
	Jogador j = new Jogador();
	//Essas variáveis serão utilizadas para guardar linha e coluna de jogador e nave inimiga.
	int posJl = 0;
	int posJc = 0;
	int posSl = 0;
	int posSc = 0;
	
	//Está criando o espaço do jogo utilizando * para compor o espaço.
	void criarEspaco() {
		System.out.println("HP Jogador: "+j.getVida() +  "\nHP Nave Inimiga: "+ship.getEnergia());
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++) {
				esp[l][c] = "*";
				System.out.print(esp[l][c]);
			}
			System.out.print("\n");
		}
	}
	
	//Método para inserir jogador no espaço.
	void inserirJogador() {
		j.setNome("#");
		esp[9][1] = j.getNome();
	}
	
	//Método para atualizar o espaço e dados de vida e energia.
	void atualizacao() {
		System.out.println("HP Jogador: "+j.getVida() +  "\nHP Nave Inimiga: "+ship.getEnergia());
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++) {
				System.out.print(esp[l][c]);
			}
			System.out.print("\n");
			}
	}
	
	//Método para inserir inimigo no espaço.
	void inserirNaveInimiga() {
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++){
				if(esp[l][c].equals(ship.getNome())) {
					esp[l][c] = "*";
					
				}
			}
		}
		//Insere inimigo de forma aleatória utilizando random.
		int c, l;
		c = (int)(Math.random()*10);
		l = (int)(Math.random()*10);
		ship.setNome("@");
		esp[l][c] = ship.getNome();	
		
	}
	
	//Métodos de definir movimentação do jogador.
	void direito() {
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++) {
				if(esp[l][c].equals(j.getNome())) {
					if (c == 9) {}
					else{ esp[l][c]  = "*";
					c = c+1;
					esp[l][c] = j.getNome();
					}
				}
			}
		}
	}
	void esquerdo() {
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++) {
				if(esp[l][c].equals(j.getNome())) {
					if (c == 0) {}
					else{ esp[l][c]  = "*";
					c = c-1;
					esp[l][c] = j.getNome();
					}
				}
			}
		}
	}
	void cima() {
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++) {
				if(esp[l][c].equals(j.getNome())) {
					if (l == 0) {}
					else{ esp[l][c]  = "*";
					l = l-1;
					esp[l][c] = j.getNome();
					}
				}
			}
		}
	}
	void baixo() {
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++) {
				if(esp[l][c].equals(j.getNome())) {
					if (l == 9) {}
					else{esp[l][c]  = "*";
					l = l+1;
					esp[l][c] = j.getNome();
					}
				}
			}
		}
	}
	
	//Método para verificar HP do joagdor e do inimigo.
	void vidaJogador() {
		if(j.getVida() == 0) {
			JOptionPane.showMessageDialog(null, "Você foi destruido!\nO inimigo venceu o jogo com " + ship.getEnergia()+"% energia");
		}
	}
	void energiaInimigo() {
		if(ship.getEnergia() == 0) {
			JOptionPane.showMessageDialog(null, "Você destruiu a nave inimiga!\nRestaram " + j.getVida()+ " vidas");
		}
	}
	
	//Método para atirar no inimigo, e testar se o inimigo foi atingido.
	void atirar() {
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++) {
				if(esp[l][c].equals(j.getNome())) {
					posJl = l;
					posJc = c;
				}
				if(esp[l][c].equals(ship.getNome())) {
					posSl = l;
					posSc = c;
				}	
			}
		}
		if(posJl == posSl) {
			JOptionPane.showMessageDialog(null, "Você acertou o inimigo!");
			ship.setEnergia(ship.getEnergia()-10);
		}
		if(posJc == posSc) {
			JOptionPane.showMessageDialog(null, "Você acertou o inimigo!");
			ship.setEnergia(ship.getEnergia()-10);
		}
		
	}
	
	//Métdodo para verficar se houve colisão entre jogador e nave inimiga.
	void colidir() {
		for(int l = 0; l < 10; l++) {
			for(int c = 0; c < 10; c++) {
				if(esp[l][c].equals(j.getNome())) {
					posJl = l;
					posJc = c;
				}
				if(esp[l][c].equals(ship.getNome())) {
					posSl = l;
					posSc = c;
				}	
			}
		}
		//Em caso de colisão ocorre alteração de vida e energia.
		if((posJl == posSl) && (posJc == posSc)) {
			JOptionPane.showMessageDialog(null, "As naves colidiram!");
			ship.setEnergia(ship.getEnergia()-10);
			j.setVida(j.getVida()-1);
		}
	}
	
}
	

