/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo;

import br.util.Arquivo;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author 104884
 */
public class Historico implements Serializable {
    
    private static ArrayList<Historico> historico = new ArrayList();
    
    public static void setHistorico(ArrayList<Historico> hitorico) {
        Historico.historico = hitorico;
    }
    
    public static ArrayList<Historico> getHistorico() {
        return Historico.historico;
    }
    
    public static void addHistoric(Historico h) {
        Historico.historico.add(h);
        Arquivo.gravarAlteracoesHistorico();
    }
    
    private String atividade;
    private LocalDateTime data;
    
    public Historico(String atividade) {
        this.setAtividade(atividade);
        this.setData(LocalDateTime.now());
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
    public String getDataFormatada() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
    
}
