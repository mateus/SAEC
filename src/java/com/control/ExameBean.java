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
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg;
        if(!exame.getNome().trim().isEmpty() && exame.getValor() >= 0){
            ExameDAO exameDAO = new ExameDAO();
            if(exameDAO.cadastrar(exame)){
                exame = new Exame();
                msg = new FacesMessage("Operação realizada com sucesso");
                contexto.addMessage("cad-exa-form", msg);
            }else{
                msg = new FacesMessage("Erro ao inserir no banco de dados");
                contexto.addMessage("cad-exa-form", msg);
            }
        }
        else {
            msg = new FacesMessage("Preencha os campos obrigatórios");
            contexto.addMessage("cad-exa-form", msg);
        }
    }
    
    public void alterarDados(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg;
        if(!exame.getNome().trim().isEmpty() && exame.getValor() >= 0){
            ExameDAO exameDAO = new ExameDAO();
            if(exameDAO.alterar(exame)){
                exame = new Exame();
                msg = new FacesMessage("Operação realizada com sucesso");
                contexto.addMessage("cad-exa-form", msg);
            }else{
                msg = new FacesMessage("Erro ao inserir no banco de dados");
                contexto.addMessage("cad-exa-form", msg);
            }
        }
        else {
            msg = new FacesMessage("Preencha os campos obrigatórios");
            contexto.addMessage("cad-exa-form", msg);
        }
    }
    
    public ListDataModel listar(){
        ExameDAO exameDAO = new ExameDAO();
        List<ExameBean> examesBean = new ArrayList();
        
        if (exameDAO.getExames() != null){
            for (Exame e : exameDAO.getExames()){
                examesBean.add(new ExameBean(e));
            }
            return new ListDataModel(examesBean);
        }else{
            return null;
        }
    }
    
    public List<ExameBean> listarNomeId(){
        ExameDAO exameDAO = new ExameDAO();
        List<ExameBean> examesBean = new ArrayList();
        
        if (exameDAO.getExames() != null){
            for (Exame e : exameDAO.getExames()){
                examesBean.add(new ExameBean(e));
            }
            return examesBean;
        }else{
            return null;
        }
    }
    
    public Exame buscaExame(int id){
        ExameDAO exameDAO = new ExameDAO();
        exame = exameDAO.getExame(id);
        return exame;  
    }
    
    public void remover(){
        ExameDAO exameDAO = new ExameDAO();
        exameDAO.deletar(exame);
    }
     
    public String alterar(Exame exame){
        this.exame = exame;
        return "alterar";
    }
    
    public void limpar(){
        exame = new Exame();
    }
}
