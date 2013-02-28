/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.RelatorioDAO;
import javax.faces.model.ListDataModel;

/**
 *
 * @author mateus
 */
public class RelatorioBean {
    String dataInicial, dataFinal;
    boolean faturamento;

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isFaturamento() {
        return faturamento;
    }

    public void setFaturamento(boolean faturamento) {
        this.faturamento = faturamento;
    }
    
    public ListDataModel pesquisar(){
        RelatorioDAO relatorio = new RelatorioDAO();
        return relatorio.pesquisa(dataInicial, dataFinal, faturamento);
    }
}
