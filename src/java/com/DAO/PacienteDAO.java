/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.model.Medico;
import com.model.Paciente;
import com.util.Conexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author mateus
 */
public class PacienteDAO {
    public boolean cadastrar(Paciente paciente){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(paciente);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback(); 
            }
            return false;
        }        
    }
    
    public boolean deletar(Paciente paciente){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(paciente);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback(); 
            }
            return false;
        }        
    }
    
    public List<Paciente> getPacientes(){
        try{
            EntityManager em = Conexao.getEntityManager();
            Query q = em.createQuery("SELECT p FROM Paciente p");

            List<Paciente> pacientes = q.getResultList();
  
            return pacientes;
        }catch(Exception e){
            return null;
        }
    }
    
    public Paciente getPaciente(Paciente paciente){
        try{
            EntityManager em = Conexao.getEntityManager();
            Query q = em.createQuery("SELECT p FROM Paciente p WHERE p.id=:id");
            q.setParameter("id", paciente.getId());
            paciente = (Paciente) q.getResultList();
  
            return paciente;
        }catch(Exception e){
            return null;
        }
    }
}