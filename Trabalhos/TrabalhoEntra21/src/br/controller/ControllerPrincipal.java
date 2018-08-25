package br.controller;


import br.util.Imagem;
import br.view.FramePrincipal;
import br.view.SubPanel;
import br.vo.Login;
import br.vo.pessoa.Caixa;
import br.vo.pessoa.Funcionario;
import br.vo.pessoa.Gerente;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 104884
 */
public class ControllerPrincipal {
    
    private FramePrincipal view;
    private Login sessao;
    
    public Login getSessao() {
        return sessao;
    }

    public void setSessao(Login sessao) {
        this.sessao = sessao;
    }

    public FramePrincipal getView() {
        return view;
    }

    public void setView(FramePrincipal view) {
        this.view = view;
    }
    
    public void trocaTela(SubPanel newPanel) {
        newPanel.setRoot(this.getView());
        this.getView().getjPanel2().removeAll();
        this.getView().getjPanel2().add(newPanel);
        this.getView().getjPanel2().repaint();
        this.getView().getjPanel2().revalidate();
    }
    
    public void prepararBotoes(String imagem, JButton botao) {
        int width = 32;
        int height = 32;
        botao.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagem)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
        
        botao.setVerticalTextPosition(SwingConstants.BOTTOM);
        botao.setVerticalAlignment(SwingConstants.TOP);
        botao.setHorizontalTextPosition(SwingConstants.CENTER);
        
        this.isEnabled(botao);
    }
    
    public void isEnabled(JButton botao) {
        if(this.getSessao().getUsuario() instanceof Gerente) {
            botao.setEnabled(true);
        } else {
            System.out.println(botao.getText());
            if(this.getSessao().getUsuario() instanceof Caixa && botao.getText().equals("Vendas")) {
                botao.setEnabled(true);
            }
        }
    }
    
}
