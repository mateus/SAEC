/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.PacienteDAO;
import com.model.Paciente;
import java.io.Serializable;

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
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.cadastrar(paciente);
        paciente = new Paciente();
    }
    
}
