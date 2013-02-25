/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.MedicoDAO;
import com.DAO.PacienteDAO;
import com.model.Medico;
import com.model.Paciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author mateus
 */
public class PacienteBean implements Serializable{
    Paciente paciente;
    
    private PacienteBean(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteBean() {
        paciente = new Paciente();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public void cadastrar(){
        if(!paciente.getNome().trim().isEmpty()){
            PacienteDAO pacienteDAO = new PacienteDAO();
            if(pacienteDAO.cadastrar(paciente)){
                paciente = new Paciente();
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("Operação realizada com sucesso.");
                contexto.addMessage("cad-pac-form", msg);
            }else{
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("Erro ao inserir no banco de dados.");
                contexto.addMessage("cad-pac-form", msg);
            }
        }
        else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("Preencha os campos obrigatórios.");
            contexto.addMessage("cad-pac-form", msg);
        }
    }
    
    public ListDataModel listar(){
        PacienteDAO pacienteDAO = new PacienteDAO();
        List<PacienteBean> pacientesBean = new ArrayList();
        
        if (pacienteDAO.getPacientes() != null){
            for (Paciente p : pacienteDAO.getPacientes()){
                pacientesBean.add(new PacienteBean(p));
            }
            return new ListDataModel(pacientesBean);
        }else{
            return null;
        }
    }
    
    public List<PacienteBean> listarNomeId(){
        PacienteDAO pacienteDAO = new PacienteDAO();
        List<PacienteBean> pacientesBean = new ArrayList();
        
        if (pacienteDAO.getPacientes() != null){
            for (Paciente p : pacienteDAO.getPacientes()){
                pacientesBean.add(new PacienteBean(p));
            }
            return pacientesBean;
        }else{
            return null;
        }
    }
    
    public Paciente buscaPaciente(int id){
        PacienteDAO pacienteDAO = new PacienteDAO();
        paciente = pacienteDAO.getPaciente(id);
        return paciente;  
    }
    
    public void remover(){
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.deletar(paciente);
    }
    
    public String alterar(Paciente paciente){
        this.paciente = paciente;
        return "alterar";
    }
 }
