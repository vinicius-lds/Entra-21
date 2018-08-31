package br.controller;

import br.view.panel.crud.PanelCRUD;
import javax.swing.JPanel;

/**
 * @author vinic
 */
public class ControllerPanelCRUD {

    private PanelCRUD view;
    
    public PanelCRUD getView() {
        return this.view;
    }

    public void setView(PanelCRUD view) {
        this.view = (PanelCRUD) view;
    }
    
    public void trocaTela(JPanel novaTela) {
        this.getView().getPn_usuarios().removeAll();
        System.out.println(novaTela.toString());
        this.getView().getPn_usuarios().add(novaTela);
        this.getView().getPn_usuarios().repaint();
        this.getView().getPn_usuarios().revalidate();
        System.out.println(" a");
    }
    
}
