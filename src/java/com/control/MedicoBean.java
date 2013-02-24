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
    private List<MedicoBean> medicosBean = new ArrayList();

    private MedicoBean(Medico medico) {
        this.medico = medico;
    }

    public List<MedicoBean> getMedicosBean() {
        return medicosBean;
    }

    public void setMedicosBean(List<MedicoBean> medicosBean) {
        this.medicosBean = medicosBean;
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
        if(!medico.getNome().trim().isEmpty() && !medico.getCrm().trim().isEmpty()){
            MedicoDAO medicoDAO = new MedicoDAO();
            if(medicoDAO.cadastrar(medico)){
                medico = new Medico();
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("Operação realizada com sucesso.");
                contexto.addMessage("med-cad-form", msg);
            }else{
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("Erro ao inserir no banco de dados.");
                contexto.addMessage("med-cad-form", msg);
            }
        }
        else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("Preencha os campos obrigatórios.");
            contexto.addMessage("med-cad-form", msg);
        }
    }
    
    public ListDataModel listar(){
        MedicoDAO medicoDAO = new MedicoDAO();
        medicosBean = new ArrayList();
        
        if (medicoDAO.getMedicos() != null){
            for (Medico medico : medicoDAO.getMedicos()){
                medicosBean.add(new MedicoBean(medico));
            }
            return new ListDataModel(medicosBean);
        }else{
            return null;
        }
    }
    
    public List<MedicoBean> listarNomeId(){
        MedicoDAO medicoDAO = new MedicoDAO();
        medicosBean = new ArrayList();
        
        if (medicoDAO.getMedicos() != null){
            for (Medico medico : medicoDAO.getMedicos()){
                medicosBean.add(new MedicoBean(medico));
            }
            return medicosBean;
        }else{
            return null;
        }
    }
    
     public void remover(){
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.deletar(medico);
    }
     
    public String alterar(Medico medico){
        this.medico = medico;
        return "alterar";
    }
    
    public void limpar(){
        medico = new Medico();
    }
}
