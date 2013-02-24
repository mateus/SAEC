/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.ExameDAO;
import com.model.Exame;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author mateus
 */
public class ExameBean {
    Exame exame;
    private List<ExameBean> examesBean = new ArrayList();

    public ExameBean() {
        exame = new Exame();
    }

    public ExameBean(Exame exame) {
        this.exame = exame;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }
    
    public void cadastrar(){
        if(!exame.getNome().trim().isEmpty() && exame.getValor() > 0){
            ExameDAO exameDAO = new ExameDAO();
            if(exameDAO.cadastrar(exame)){
                exame = new Exame();
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("Operação realizada com sucesso.");
                contexto.addMessage("cad-exa-form", msg);
            }else{
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("Erro ao inserir no banco de dados.");
                contexto.addMessage("cad-exa-form", msg);
            }
        }
        else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("Preencha os campos obrigatórios.");
            contexto.addMessage("cad-exa-form", msg);
        }
    }
    
    public ListDataModel listar(){
        ExameDAO exameDAO = new ExameDAO();
        examesBean = new ArrayList();
        
        if (exameDAO.getExames() != null){
            for (Exame exame : exameDAO.getExames()){
                examesBean.add(new ExameBean(exame));
            }
            return new ListDataModel(examesBean);
        }else{
            return null;
        }
    }
    
     public void remover(){
        ExameDAO exameDAO = new ExameDAO();
        exameDAO.deletar(exame);
    }
     
    public String alterar(Exame exame){
        this.exame = exame;
        return "alterar";
    }
}
