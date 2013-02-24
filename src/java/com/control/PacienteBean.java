/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.PacienteDAO;
import com.model.Paciente;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author mateus
 */
public class PacienteBean implements Serializable{
    Paciente paciente;
  
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
                FacesMessage msg = new FacesMessage("Cadastro realizado com sucesso.");
                contexto.addMessage("pac-cad-form", msg);
            }else{
                FacesContext contexto = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("Erro ao inserir no banco de dados.");
                contexto.addMessage("pac-cad-form", msg);
            }
        }
        else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("Preencha os campos obrigatórios.");
            contexto.addMessage("pac-cad-form", msg);
        }
    }
    
}
