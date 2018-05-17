import java.util.Random;

import javax.swing.JOptionPane;

public class Prova {

	public static void main(String[] args) {
		
		int intAux = 0;
		String strAux = "";
		
		boolean sair = false;
		Random r = new Random();
		String resposta;
		
		//[2] Nome, acertos
		String[][] jogadores = new String[5][2];
		String[][] questoes = new String[30][6];

		questoes[0][0] = "Quem era o homem mais sedutor do mundo?";
		questoes[0][1] = "a)Dom Juan";
		questoes[0][2] = "b)Dom Antônio";
		questoes[0][3] = "c)Dom Marco";
		questoes[0][4] = "d)Dom Carlos";
		questoes[0][5] = "a";

		questoes[1][0] = "De quantos anos é constituído um século?";
		questoes[1][1] = "a)50";
		questoes[1][2] = "b)100";
		questoes[1][3] = "c)1000";
		questoes[1][4] = "d)1500";
		questoes[1][5] = "b";

		questoes[2][0] = "Qual é o coletivo de cães?";
		questoes[2][1] = "a)Matilha";
		questoes[2][2] = "b)Rebanho";
		questoes[2][3] = "c)Cardume";
		questoes[2][4] = "d)Manada";
		questoes[2][5] = "a";

		questoes[3][0] = "Segundo a Bíblia, em que rio Jesus foi batizado por João Batista?";
		questoes[3][1] = "a)Rio Nilo";
		questoes[3][2] = "b)Rio Sena";
		questoes[3][3] = "c)Rio Reno";
		questoes[3][4] = "d)Rio Jordão";
		questoes[3][5] = "d";

		questoes[4][0] = "Qual é a maior floresta do planeta?";
		questoes[4][1] = "a)Negra";
		questoes[4][2] = "b)Sherwood";
		questoes[4][3] = "c)Tijuca";
		questoes[4][4] = "d)Amazônica";
		questoes[4][5] = "d";

		questoes[5][0] = "Qual é o naipe do baralho que tem o desenho de coração?";
		questoes[5][1] = "a)Ouros";
		questoes[5][2] = "b)Paus";
		questoes[5][3] = "c)Copas";
		questoes[5][4] = "d)Espadas";
		questoes[5][5] = "c";
		
		questoes[6][0] = "Qual atriz estrelou no filme: 'A lagoa azul'?";
		questoes[6][1] = "a)Alicia Silverstone";
		questoes[6][2] = "b)Brooke Shields";
		questoes[6][3] = "c)Julia Roberts";
		questoes[6][4] = "d)Jessica Lange";
		questoes[6][5] = "b";

		questoes[7][0] = "Qual casal foi expulso do Paraíso?";
		questoes[7][1] = "a)Sansão de Dalila";
		questoes[7][2] = "b)José e Maria";
		questoes[7][3] = "c)Sara e Abraão";
		questoes[7][4] = "d)Adão e Eva";
		questoes[7][5] = "d";

		questoes[8][0] = "Segundo os contos, qual animal ao ser beijado se transforma em príncipe?";
		questoes[8][1] = "a)Cavalo";
		questoes[8][2] = "b)Cão";
		questoes[8][3] = "c)Gato";
		questoes[8][4] = "d)Sapo";
		questoes[8][5] = "d";

		questoes[9][0] = "Qual é o santo que só acreditou vendo?";
		questoes[9][1] = "a)Santo Antônio";
		questoes[9][2] = "b)São Judas Tadeu";
		questoes[9][3] = "c)São Pedro";
		questoes[9][4] = "d)São Tomé";
		questoes[9][5] = "d";

		questoes[10][0] = "Qual é o fruto conhecido no nordeste do Brasil como 'jerimum'?";
		questoes[10][1] = "a)Caju";
		questoes[10][2] = "b)Abóbora";
		questoes[10][3] = "c)Chuchu";
		questoes[10][4] = "d)Coco";
		questoes[10][5] = "b";

		questoes[11][0] = "Em qual parte do corpo humano são implantadas as 'pontes de safena'?";
		questoes[11][1] = "a)Estômago";
		questoes[11][2] = "b)Intestino";
		questoes[11][3] = "c)Pulmão";
		questoes[11][4] = "d)Coração";
		questoes[11][5] = "d";

		questoes[12][0] = "Como é conhecido o jogador Edmundo?";
		questoes[12][1] = "a)Tigrão";
		questoes[12][2] = "b)Gatinho";
		questoes[12][3] = "c)Animal";
		questoes[12][4] = "d)Cobra";
		questoes[12][5] = "c";

		questoes[13][0] = "Na literatura, quem foi o criador da boneca Emília?";
		questoes[13][1] = "a)Monteiro Lobato";
		questoes[13][2] = "b)Maurício de Souza";
		questoes[13][3] = "c)Walt Disney";
		questoes[13][4] = "d)Jorge Amado";
		questoes[13][5] = "a";

		questoes[14][0] = "Quem é o primeiro substituto do Presidente?";
		questoes[14][1] = "a)Veriador";
		questoes[14][2] = "b)Vice-presidente";
		questoes[14][3] = "c)Senador";
		questoes[14][4] = "d)Deputado";
		questoes[14][5] = "b";

		questoes[15][0] = "Segundo o romance, que animal era 'Moby Dick'?";
		questoes[15][1] = "a)Tubarão";
		questoes[15][2] = "b)Golfinho";
		questoes[15][3] = "c)Polvo";
		questoes[15][4] = "d)Baleia";
		questoes[15][5] = "d";

		questoes[16][0] = "Que animal é o Pateta?";
		questoes[16][1] = "a)Cavalo";
		questoes[16][2] = "b)Burro";
		questoes[16][3] = "c)Cachorro";
		questoes[16][4] = "d)Raposa";
		questoes[16][5] = "c";

		questoes[17][0] = "Em qual cidade está o Cristo Redentor do Corcovado?";
		questoes[17][1] = "a)Rio de Janeiro";
		questoes[17][2] = "b)São Paulo";
		questoes[17][3] = "c)Curitiba";
		questoes[17][4] = "d)Belo Horizonte";
		questoes[17][5] = "a";

		questoes[18][0] = "Quem é conhecido como o 'playboy brasileiro'?";
		questoes[18][1] = "a)Joãozinho Trinta";
		questoes[18][2] = "b)Zeca Pagodinho";
		questoes[18][3] = "c)Chiquinho Scarpa";
		questoes[18][4] = "d)Chico Buarque";
		questoes[18][5] = "c";

		questoes[19][0] = "Quantos centímetros equivalem a um metro?";
		questoes[19][1] = "a)10";
		questoes[19][2] = "b)100";
		questoes[19][3] = "c)1000";
		questoes[19][4] = "d)10000";
		questoes[19][5] = "b";

		questoes[20][0] = "Qual é o nome do macho da abelha?";
		questoes[20][1] = "a)Zangão";
		questoes[20][2] = "b)Abelhão";
		questoes[20][3] = "c)Rufião";
		questoes[20][4] = "d)Pulgão";
		questoes[20][5] = "a";

		questoes[21][0] = "Qual é o inseto que transmite a doença de Chagas?";
		questoes[21][1] = "a)Abelha";
		questoes[21][2] = "b)Rato";
		questoes[21][3] = "c)Barbeiro";
		questoes[21][4] = "d)Pulga";
		questoes[21][5] = "c";

		questoes[22][0] = "Qual é o nome do conjunto de dados sobre uma população?";
		questoes[22][1] = "a)Censo";
		questoes[22][2] = "b)Montagem";
		questoes[22][3] = "c)Marcação";
		questoes[22][4] = "d)Registro";
		questoes[22][5] = "a";

		questoes[23][0] = "Qual ator imortalizou o personagem 'Zé Bonitinho'?";
		questoes[23][1] = "a)Roni Cócegas";
		questoes[23][2] = "b)Jorge Loredo";
		questoes[23][3] = "c)Davi Pinheiro";
		questoes[23][4] = "d)Arnaud Rodrigues";
		questoes[23][5] = "b";

		questoes[24][0] = "Qual a cantora conhecida como 'A rainha dos caminhoneiros'?";
		questoes[24][1] = "a)Roberta Miranda";
		questoes[24][2] = "b)Maria Bethânia";
		questoes[24][3] = "c)Sula Miranda";
		questoes[24][4] = "d)Rita Cadillac";
		questoes[24][5] = "c";

		questoes[25][0] = "Qual é o nome da missa rezada no Natal?";
		questoes[25][1] = "a)Campal";
		questoes[25][2] = "b)Do Galo";
		questoes[25][3] = "c)Do Vaticano";
		questoes[25][4] = "d)Do Sétimo Dia";
		questoes[25][5] = "b";

		questoes[26][0] = "Qual é a orixá conhecida como 'A rainha do mar'?";
		questoes[26][1] = "a)Mamãe Oxum";
		questoes[26][2] = "b)Iemanjá";
		questoes[26][3] = "c)Axé";
		questoes[26][4] = "d)Iansã";
		questoes[26][5] = "b";

		questoes[27][0] = "No julgamento de Jesus, quem disse a frase: 'Eu lavo minhas mãos'?";
		questoes[27][1] = "a)Barrabás";
		questoes[27][2] = "b)Tibério";
		questoes[27][3] = "c)Pôncio Pilatos";
		questoes[27][4] = "d)Judas";
		questoes[27][5] = "c";

		questoes[28][0] = "O que está no centro da Terra?";
		questoes[28][1] = "a)Manto";
		questoes[28][2] = "b)Núcleo";
		questoes[28][3] = "c)Hidrosfera";
		questoes[28][4] = "d)Litosfera";
		questoes[28][5] = "b";

		questoes[29][0] = "Qual é o animal que representa o signo de áries?";
		questoes[29][1] = "a)Touro";
		questoes[29][2] = "b)Leão";
		questoes[29][3] = "c)Caneiro";
		questoes[29][4] = "d)Bode";
		questoes[29][5] = "c";
		
		int[] questoesUsadas = new int[13];
		//jogador, certa
		String[][] respostas = new String[10][3];
		int acertos = 0;
		int pulos = 0;
		String[] alternativas = new String[5];
		
		int indexJogadores = 0;
		int indexQuestoes = 0;
		
		int questoesRespondidas = 0;
		
		while(!sair) {
			
			//Validação Quantidade de jogadores
			if(indexJogadores == 4) {
				JOptionPane.showMessageDialog(null, "Não é possivel cadastrar mais jogadores");
				break;
			}
			
			//Validação Nome Repetidos
			while(jogadores[indexJogadores][0] == null) {
				
				try {
					jogadores[indexJogadores][0] = JOptionPane.showInputDialog("Nome do Jogador");
					if(jogadores[indexJogadores][0] == "") {
						throw new IllegalArgumentException();
					}
					for (int i = indexJogadores - 1; i >= 0; i--) {
						if(jogadores[indexJogadores][0].equals(jogadores[i][0])) {
							throw new IllegalArgumentException();
						}
					}
				} catch (Exception e) {
					jogadores[indexJogadores][0] = null;
					JOptionPane.showMessageDialog(null, "Nome Inválido!");
				}
			}
			
			//Gera os indices das questoes aleatoriamente
			for (int i = 0; i < questoesUsadas.length; i++) {
				questoesUsadas[i] = r.nextInt(30);
				for (int j = i; j >= 0; j--) {
					if(questoesUsadas[j] == questoesUsadas[i]) {
						if(j == i) { continue; }
						i--;
						break;
					}
				}
			}
			
			for (int i = 0; i < questoesUsadas.length; i++) {
				System.out.print(questoesUsadas[i] + " ");
			}
			System.out.println();
			
			//Faz as perguntas ao usuario
			while(questoesRespondidas < 10) {
				
				//Cria alternativas
				for(int i = 0; i < questoes[0].length - 1; i++) {
					
					alternativas[i] = questoes[questoesUsadas[indexQuestoes]][i + 1];
					
				}
				
				alternativas[4] = "Pular";
				
				resposta = (String) JOptionPane.showInputDialog(null,
																 questoes[questoesUsadas[indexQuestoes]][0],
											                     "Pergunta "+ (questoesRespondidas + 1), 
											                     JOptionPane.PLAIN_MESSAGE,
											                     null,
											                     alternativas,
											                     "");
				alternativas = new String[5];
				
				//Valida quantas vezes o usuario pulou a pergunta
				if(resposta.equals("Pular")) {
					if(pulos < 3) {
						pulos++;
						continue;
					} else {
						JOptionPane.showMessageDialog(null, "Você ja pulou tres vezes");
						continue;
					}
				}
				
				respostas[questoesRespondidas][0] = resposta;
				respostas[questoesRespondidas][1] = questoes[questoesUsadas[indexQuestoes]][5];
				respostas[questoesRespondidas][2] = questoes[questoesUsadas[indexQuestoes]][0];
				
				System.out.println(respostas[questoesRespondidas][0]);
				System.out.println(respostas[questoesRespondidas][1]);
				
				if(respostas[questoesRespondidas][1].charAt(0) == respostas[questoesRespondidas][0].charAt(0)) {
					acertos++;
					System.out.println(acertos);
				}
				
				indexQuestoes++;
				questoesRespondidas++;
				
			}
			
			strAux = "Voce acertou " + acertos + " questões!";
			
			for (int i = 0; i < respostas.length; i++) {
				if(respostas[i][0].charAt(0) != respostas[i][1].charAt(0)) {
					strAux += "\n" + respostas[i][2];
					strAux += "\nSua resposta: " + respostas[i][0] + " Resposta Correta: " + respostas[i][1];
					strAux += "\n";
				}
			}
			
			JOptionPane.showMessageDialog(null, strAux);
			
			indexQuestoes = 0;
			questoesRespondidas = 0;
			respostas = new String[10][3];
			questoesUsadas = new int[13];
			jogadores[indexJogadores][1] = String.valueOf(acertos);
			acertos = 0;
			indexJogadores++;
			
			sair = (JOptionPane.showConfirmDialog(null, "Deseja sair?", "", 0) == 0) ? true : false;
			
		}
		
		for (int i = 1; i < indexJogadores; i++) {
			for (int j = i; j > 0; j--) {
				if(Integer.parseInt(jogadores[j][1]) < Integer.parseInt(jogadores[j - 1][1])) {
					intAux = Integer.parseInt(jogadores[j - 1][1]);
					jogadores[j - 1][1] = jogadores[j][1];
					jogadores[j][1] = String.valueOf(intAux);
					
					strAux = jogadores[j - 1][0];
					jogadores[j - 1][0] = jogadores[j][0];
					jogadores[j][0] = strAux;
				}
			}
		}
		
		strAux = "";
		for (int i = 0; i < indexJogadores; i++) {
			strAux += jogadores[i][0] + " " + jogadores[i][1] + " acertos";
		}
		JOptionPane.showMessageDialog(null, strAux);
		
	}
	
}
