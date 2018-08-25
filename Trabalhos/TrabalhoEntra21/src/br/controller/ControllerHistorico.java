/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.view.PanelHistorico;
import br.vo.Historico;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinic
 */
public class ControllerHistorico {
    
    private PanelHistorico view;

    public PanelHistorico getView() {
        return view;
    }

    public void setView(PanelHistorico view) {
        this.view = view;
    }
    
    public void iniciaTabelaHistorico() {
        for(Historico h: Historico.getHistorico()) {
            ((DefaultTableModel)this.getView().getTb_historico().getModel()).addRow(new Object[]{h.getAtividade(), h.getDataFormatada()});
        }
    }
    
    public void atualizaPeriodoDeTempo() {
        ((DefaultTableModel)this.getView().getTb_historico().getModel()).setRowCount(0);
        String dataInicio = (this.getView().getTf_inicio().getText().equals("  /  /       :  ")) ? LocalDateTime.of(1000, Month.JANUARY, 1, 0, 0).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : this.getView().getTf_inicio().getText();
        String dataFim = (this.getView().getTf_fim().getText().equals("  /  /       :  ")) ? LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : this.getView().getTf_fim().getText();
        for(Historico h : Historico.getHistorico()) {
            if(h.getData().isAfter(LocalDateTime.parse(dataInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
               && h.getData().isBefore(LocalDateTime.parse(dataFim, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))) {
                ((DefaultTableModel)this.getView().getTb_historico().getModel()).addRow(new Object[]{h.getAtividade(), h.getDataFormatada()});
            }
        }
    }
    
    public void redefinir() {
        this.getView().getTf_fim().setText("");
        this.getView().getTf_inicio().setText("");
        ((DefaultTableModel)this.getView().getTb_historico().getModel()).setRowCount(0);
        this.iniciaTabelaHistorico();
    }
    
}
