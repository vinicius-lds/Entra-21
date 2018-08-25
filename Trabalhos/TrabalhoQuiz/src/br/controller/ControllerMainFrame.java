package br.controller;

import br.enumeradores.Alternativa;
import br.util.Imagem;
import br.util.PedeDados;
import br.view.Inicio;
import br.view.MainFrame;
import br.vo.Timer;
import br.vo.Jogador;
import br.vo.Pergunta;
import br.vo.tema.Tema;
import java.util.Enumeration;
import java.util.Random;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 * @author 104884
 */
public class ControllerMainFrame {

    private MainFrame view;
    private int chances;
    private int respondidas;
    private boolean ajudaDisponivel;
    private Pergunta pergunta;
    private Tema tema;
    private Jogador jogador;
    private Timer timer;

    public ControllerMainFrame(MainFrame view, Jogador j, Tema t) {
        this.view = view;
        this.chances = 3;
        this.respondidas = 0;
        this.ajudaDisponivel = true;
        this.tema = t;
        this.tema.iniciarPerguntas();
        this.jogador = j;
        this.timer = new Timer(this);
        Imagem img = new Imagem();
        img.setIcon(view.lbl_close, Imagem.ICON_CLOSE, 32, 32);
        img.setIcon(view.lbl_help, Imagem.ICON_HELP, 64, 64);
        img.setIcon(view.lbl_respond, Imagem.ICON_RESPOND, 64, 64);
        img.setIcon(view.lbl_skip, Imagem.ICON_SKIP, 64, 64);
        this.view.setLocationRelativeTo(null);
        PedeDados.perguntaBooleana("Prepaprado?");
        this.view.setVisible(true);
        
        this.novaPergunta();
        this.timer.iniciarCronometro();
    }

    public void atualizaTimer(long tempo) {
        if (tempo > 0) {
            this.view.lbl_timer.setText("Restam " + tempo + " segundos!");
        } else {
            int resposta = this.getSelectedIndex(this.view.bg_resposta);
            this.tratarResposta(this.timer.getTempoRestante(), resposta);
        }
    }

    public void setPergunta(Pergunta p) {
        this.pergunta = p;
        this.view.lbl_pergunta.setText(this.getHtml(p.getPergunta(), 36));
        this.view.rb_aternativa1.setText(this.getHtml(p.getAlternativa(Alternativa.A), 48));
        this.view.rb_aternativa2.setText(this.getHtml(p.getAlternativa(Alternativa.B), 48));
        this.view.rb_aternativa3.setText(this.getHtml(p.getAlternativa(Alternativa.C), 48));
        this.view.rb_aternativa4.setText(this.getHtml(p.getAlternativa(Alternativa.D), 48));
        this.view.bg_resposta.clearSelection();
        this.enableAll();
    }

    public void enableAll() {
        this.view.rb_aternativa1.setEnabled(true);
        this.view.rb_aternativa2.setEnabled(true);
        this.view.rb_aternativa3.setEnabled(true);
        this.view.rb_aternativa4.setEnabled(true);
    }

    private String getHtml(String pergunta, int charPorLinha) {
        String aux = "<html>";
        for (int i = 0, j = 0; i < pergunta.length(); i++, j++) {
            if (j == charPorLinha) {
                j = 0;
                aux += "<br>";
            }
            aux += pergunta.charAt(i);
        }
        return aux + "</html>";
    }

    private int getSelectedIndex(ButtonGroup bg) {
        Enumeration<AbstractButton> buttons = bg.getElements();
        AbstractButton button;
        int i = 0;
        while (buttons.hasMoreElements()) {
            button = buttons.nextElement();
            if (button.isSelected()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void responder() {
        int resposta = this.getSelectedIndex(this.view.bg_resposta);
        if (resposta < 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma alternativa foi selecionada!");
        } else {
            this.tratarResposta(this.timer.getTempoRestante(), resposta);
        }
    }

    public void tratarResposta(long ms, int resposta) {
        this.timer.pararCronometro();
        System.out.print("Resposta Correta: " + this.pergunta.getResposta().getIndex());
        System.out.println(" Resposta dada pelo usuario " + resposta);
        if (this.pergunta.getResposta().isAlternativaCorreta(resposta)) {
            this.jogador.incAcertos();
        }
        this.jogador.incScore(ms);
        this.respondidas++;
        if (respondidas < 10) {
            this.novaPergunta();
            this.timer.iniciarCronometro();
        } else {
            finalizarJogo();
            this.timer.destruir();
        }
    }

    public void finalizarJogo() {
        this.view.setVisible(false);
        new Inicio().setVisible(true);
    }

    public void ajuda() {
        if (this.ajudaDisponivel && PedeDados.perguntaBooleana("Tem certeza que deseja usar sua ajuda? Você só tem uma por jogo!")) {
            this.ajudaDisponivel = false;
            Random r = new Random();
            Enumeration<AbstractButton> buttons = this.view.bg_resposta.getElements();
            AbstractButton button;
            for (int i = 0; buttons.hasMoreElements(); i++) {
                button = buttons.nextElement();
                if (this.pergunta.getResposta().getIndex() == i) {
                    continue;
                }
                button.setEnabled(r.nextBoolean());
            }
            this.view.bg_resposta.clearSelection();
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem mais ajudas!");
        }
    }

    public void pular() {
        if (this.chances < 1) {
            JOptionPane.showMessageDialog(null, "Você não pode pular mais perguntas!");
        } else {
            this.chances--;
            this.timer.pararCronometro();
            this.novaPergunta();
            this.timer.iniciarCronometro();
        }
    }

    private void novaPergunta() {
        try {
            this.setPergunta(this.tema.getPergunta());
        } catch (IndexOutOfBoundsException e) {
            this.finalizarJogo();
        }
    }

}
