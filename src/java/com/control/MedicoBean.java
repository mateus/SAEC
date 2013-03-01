/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.MedicoDAO;
import com.model.Medico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author mateus
 */
public class MedicoBean {
    Medico medico;

    private MedicoBean(Medico medico) {
        this.medico = medico;
    }
    
    public MedicoBean() {
        medico = new Medico();
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public void cadastrar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg;
        if(!medico.getNome().trim().isEmpty() && !medico.getCrm().trim().isEmpty()){
            MedicoDAO medicoDAO = new MedicoDAO();
            if(medicoDAO.cadastrar(medico)){
                medico = new Medico();
                msg = new FacesMessage("Operação realizada com sucesso");
                contexto.addMessage("cad-med-form", msg);
            }else{
                msg = new FacesMessage("Erro ao inserir no banco de dados");
                contexto.addMessage("cad-med-form", msg);
            }
        }
        else {
            msg = new FacesMessage("Preencha os campos obrigatórios");
            contexto.addMessage("cad-med-form", msg);
        }
    }
    
    public void alterarDados(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg;
        if(!medico.getNome().trim().isEmpty() && !medico.getCrm().trim().isEmpty()){
            MedicoDAO medicoDAO = new MedicoDAO();
            if(medicoDAO.alterar(medico)){
                medico = new Medico();
                msg = new FacesMessage("Operação realizada com sucesso");
                contexto.addMessage("cad-med-form", msg);
            }else{
                msg = new FacesMessage("Erro ao inserir no banco de dados");
                contexto.addMessage("cad-med-form", msg);
            }
        }
        else {
            msg = new FacesMessage("Preencha os campos obrigatórios");
            contexto.addMessage("cad-med-form", msg);
        }
    }
    
    public ListDataModel listar(){
        MedicoDAO medicoDAO = new MedicoDAO();
        List<MedicoBean> medicosBean = new ArrayList();
        
        if (medicoDAO.getMedicos() != null){
            for (Medico m : medicoDAO.getMedicos()){
                medicosBean.add(new MedicoBean(m));
            }
            return new ListDataModel(medicosBean);
        }else{
            return null;
        }
    }
    
    public List<MedicoBean> listarNomeId(){
        MedicoDAO medicoDAO = new MedicoDAO();
        List<MedicoBean> medicosBean = new ArrayList();
        
        if (medicoDAO.getMedicos() != null){
            for (Medico m : medicoDAO.getMedicos()){
                medicosBean.add(new MedicoBean(m));
            }
            return medicosBean;
        }else{
            return null;
        }
    }
    
    public Medico buscaMedico(int id){
        MedicoDAO medicoDAO = new MedicoDAO();
        medico = medicoDAO.getMedico(id);
        return medico;  
    }
    
     public void remover(){
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.deletar(medico);
    }
     
    public String alterar(Medico medico){
        this.medico = medico;
        return "alterar";
    }
}
