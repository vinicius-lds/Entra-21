package exercicio02;
import javax.swing.JOptionPane;

import util.PedeDados;

public class Principal {
    public static void main(String[] args) {
        String 	nome;
        double  mediaAlturas = 0;
        int     qtdJogadores = 0;

        Jogador maior       = null;
        Jogador maisVelho   = null;
        Jogador maisPesado  = null;

        Jogador atual = null;
        

        do {
            
            atual = new Jogador(PedeDados.getString("Nome"), 
			            		PedeDados.getInt("Idade", true), 
			            		PedeDados.getDouble("Altura", true), 
			            		PedeDados.getDouble("Peso", true));
            
            nome = PedeDados.getString("Nome do Jogador");
            
            mediaAlturas += atual.getAltura();
            qtdJogadores++;
            
            if(qtdJogadores == 1) {
            	maior = atual;
            	maisPesado = atual;
            	maisVelho = atual;
            	continue;
            }
            
            if(maior.getAltura() < atual.getAltura()) {
            	maior = atual.clone();
            }
            
            if(maisVelho.getIdade() < atual.getIdade()) {
            	maisVelho = atual.clone();
            }
            
            if(maisPesado.getPeso() < atual.getPeso()) {
            	maisPesado = atual.clone();
            }
        	
        } while(!nome.equalsIgnoreCase("SAIR"));

        JOptionPane.showMessageDialog(null, "Quantidade de jogadores cadastrados: " + qtdJogadores + "."
                                            + "\nJogador mais alto: " + maior.getNome() + ", " + maior.getAltura() + " cm."
                                            + "\nJogador mais velho: " + maisVelho.getNome() + ", " + maisVelho.getIdade() + " anos."
                                            + "\nJogador mais pesado: " + maisPesado.getNome() + ", " + maisPesado.getPeso() + " kg."
                                            + "\nMédia de idade dos Jogadores: " + (mediaAlturas / qtdJogadores) + " anos.");

    }
}