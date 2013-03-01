/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.AgendaDAO;
import com.model.Agenda;
import com.model.AgendaPK;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author mateus
 */
public class AgendaBean {
    Agenda agenda;
    AgendaPK agendaPK;

    private List<AgendaBean> consultas = new ArrayList();

    public AgendaBean() {
        agendaPK = new AgendaPK();
        agenda = new Agenda(agendaPK);
    }

    public AgendaBean(Agenda agenda) {
        this.agenda = agenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public AgendaPK getAgendaPK() {
        return agendaPK;
    }

    public void setAgendaPK(AgendaPK agendaPK) {
        this.agendaPK = agendaPK;
    }

    public List<AgendaBean> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<AgendaBean> consultas) {
        this.consultas = consultas;
    }
    
    public String cancelar(Agenda agenda){
        this.agenda = agenda;
        return "candelar";
    }
    
    public void limpar(){
        agendaPK = new AgendaPK();
        agenda = new Agenda(agendaPK);
    }
    
    public void remover(){
        AgendaDAO agendaDAO = new AgendaDAO();
        agendaDAO.deletar(agenda);
    }
    
    public void cadastrar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg;
        if(agenda.getAgendaPK().getDataHora() != null){
            AgendaDAO agendaDAO = new AgendaDAO();
            if(agendaDAO.cadastrar(agenda)){
                agendaPK = new AgendaPK();
                agenda = new Agenda(agendaPK);
                msg = new FacesMessage("Operação realizada com sucesso");
                contexto.addMessage("agendar-form", msg);
            }else{
                msg = new FacesMessage("Verifique se existe uma consulta nesta Data e Hora");
                contexto.addMessage("agendar-form", msg);
            }
        }
        else {
            msg = new FacesMessage("Preencha os campos obrigatórios");
            contexto.addMessage("agendar-form", msg);
        }
    }
    
    public ListDataModel listar(){
        AgendaDAO agendaDAO = new AgendaDAO();
        consultas = new ArrayList();
        
        if (agendaDAO.getConsultas() != null){
            for (Agenda a : agendaDAO.getConsultas()){
                consultas.add(new AgendaBean(a));
            }
            return new ListDataModel(consultas);
        }else{
            return null;
        }
    }
}
