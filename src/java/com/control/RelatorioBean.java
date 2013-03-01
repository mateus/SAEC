/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.RelatorioDAO;
import com.model.Agenda;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author mateus
 */
public class RelatorioBean {
    String dataInicial, dataFinal;
    boolean faturamento = false;
    float total = 0;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
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
    
    public String redirecionar(String dataInicial, String dataFinal, boolean faturamento){
        if(!dataInicial.isEmpty() && !dataFinal.isEmpty()){
            this.dataInicial = dataInicial.substring(6, 10)+"-"+dataInicial.substring(3, 5)+"-"+dataInicial.substring(0, 2)+" "+dataInicial.substring(11, dataInicial.length());
            this.dataFinal = dataFinal.substring(6, 10)+"-"+dataFinal.substring(3, 5)+"-"+dataFinal.substring(0, 2)+" "+dataFinal.substring(11, dataFinal.length());
            this.faturamento = faturamento;
            return "pesquisar";
        }else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("Preencha os campos corretamente");
            contexto.addMessage("relatorio-form", msg);
            return null;
        }
    }
    
    public ListDataModel pesquisar(){      
        RelatorioDAO relatorio = new RelatorioDAO();

        List<AgendaBean> resultado = new ArrayList();

        if (relatorio.pesquisa(dataInicial, dataFinal, faturamento) != null){
            for (Agenda a : relatorio.pesquisa(dataInicial, dataFinal, faturamento)){
                resultado.add(new AgendaBean(a));
            }
            return new ListDataModel(resultado);
        }else{
            return null;
        }
    }
    
    public void total(float valor){
        this.total += valor;
    }
}
