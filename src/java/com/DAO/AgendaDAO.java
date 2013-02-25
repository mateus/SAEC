/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.model.Agenda;
import com.util.Conexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author mateus
 */
public class AgendaDAO {
    public boolean cadastrar(Agenda agenda){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(agenda);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }        
    }
    
    public boolean deletar(Agenda agenda){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(agenda);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback(); 
            }
            return false;
        }        
    }
    
    public List<Agenda> getConsultas(){
        try{
            EntityManager em = Conexao.getEntityManager();
            Query q = em.createQuery("SELECT a FROM Agenda a");

            List<Agenda> consultas = q.getResultList();
  
            return consultas;
        }catch(Exception e){
            return null;
        }
    }

}
