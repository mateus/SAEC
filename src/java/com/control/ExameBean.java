/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.ExameDAO;
import com.model.Exame;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
        if(!exame.getNome().trim().isEmpty() && exame.getValor() > 0){
            ExameDAO exameDAO = new ExameDAO();
            if(exameDAO.cadastrar(exame)){
                exame = new Exame();
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("Operação realizada com sucesso.");
                contexto.addMessage("exa-cad-form", msg);
            }else{
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("Erro ao inserir no banco de dados.");
                contexto.addMessage("exa-cad-form", msg);
            }
        }
        else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("Preencha os campos obrigatórios.");
            contexto.addMessage("exa-cad-form", msg);
        }
    }
}
