package br.com.proway.controller;

import br.com.proway.util.Imagem;
import br.com.proway.view.Principal;
import javax.swing.JFrame;

/**
 * @author Vinícius Luis da Silva
 */
public class ControllerPrincipal {

    private Principal view;
    
    public ControllerPrincipal(Principal view) {
        this.view = view;
        this.view.setLocationRelativeTo(null);
        this.view.setResizable(false);
        this.view.setTitle("Principal");
        Imagem.getInstance().setIcon(this.view.getLbl_cliente(), Imagem.ICON_CLIENTE, 200, 200);
        Imagem.getInstance().setIcon(this.view.getLbl_produto(), Imagem.ICON_PRODUTO, 200, 200);
        this.view.setVisible(true);
    }

    public void trocarTela(JFrame tela) {
        this.view.dispose();
    }
    
}
