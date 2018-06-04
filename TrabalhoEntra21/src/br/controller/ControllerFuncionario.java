/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.view.InternalFrameEditarPerfil;
import br.view.PanelFuncionario;

/**
 *
 * @author vinic
 */
public class ControllerFuncionario {
    
    private PanelFuncionario view;

    public PanelFuncionario getView() {
        return view;
    }

    public void setView(PanelFuncionario view) {
        this.view = view;
    }
    
    public void editarPerfil() {
        InternalFrameEditarPerfil aux = new InternalFrameEditarPerfil(this.getView());
        this.getView().getjDesktopPane1().add(aux);
        aux.setResizable(false);
        aux.show();
    }
    
}
