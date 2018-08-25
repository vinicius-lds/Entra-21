package br.controller;

import br.util.Imagem;
import br.util.PedeDados;
import br.view.Inicio;
import br.view.MainFrame;
import br.vo.FactoryTema;
import br.vo.Jogador;
import br.vo.tema.Tema;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author 104884
 */
public class ControllerInicio {

    private Inicio view;
    
    public ControllerInicio(Inicio view) {
        this.view = view;
        Imagem img = new Imagem();
        img.setIcon(this.view.lbl_close, Imagem.ICON_CLOSE, 32, 32);
        this.view.setVisible(true);
        this.view.setLocationRelativeTo(null);
        this.atualizarRanking();
    }
    
    public void novoJogo() {
        String nome = JOptionPane.showInputDialog("Nome do Jogador?");
        try {
            Jogador j = new Jogador(nome);
            Tema t = FactoryTema.get(PedeDados.getComboBox("Qual tema deseja jogar?", new String[] {"História", "Matemática", "Português"}));
            new MainFrame(j, t).setVisible(true);
            this.view.setVisible(false);
        } catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch(NullPointerException e) {
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarRanking() {
        ArrayList<Jogador> jogadores = Jogador.getJogadores();
        for (int i = 0; i < jogadores.size(); i++) {
            for (int j = i; j > 0; j--) {
                if(jogadores.get(j).getScore()> jogadores.get(j - 1).getScore()){
                    Jogador k = jogadores.get(j);
                    jogadores.set(j, jogadores.get(j - 1));
                    jogadores.set(j - 1, k);
                }
            }
        }
        ((DefaultTableModel)this.view.tb_ranking.getModel()).setRowCount(0);
        for (int i = 0; i < jogadores.size(); i++) {
            ((DefaultTableModel)this.view.tb_ranking.getModel()).addRow(new Object[] {
                (i + 1) + "º",
                jogadores.get(i).getNome(),
                jogadores.get(i).getAcertos(),
                jogadores.get(i).getScore()
            });
        }
    }
    
}
