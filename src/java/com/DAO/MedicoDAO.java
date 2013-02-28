/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.model.Medico;
import com.util.Conexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author mateus
 */
public class MedicoDAO {
            
    public boolean cadastrar(Medico medico){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(medico);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }        
    }
    
    public boolean alterar(Medico medico){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            Medico med = em.find(Medico.class, medico.getIdMedico());
            med.setNome(medico.getNome());
            med.setCrm(medico.getCrm());
            
            et.begin();
            em.persist(med);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }        
    }
 
    public boolean deletar(Medico medico){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(medico);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback(); 
            }
            return false;
        }        
    }
    
    public List<Medico> getMedicos(){
        try{
            EntityManager em = Conexao.getEntityManager();
            Query q = em.createQuery("SELECT m FROM Medico m");

            List<Medico> medicos = q.getResultList();
  
            return medicos;
        }catch(Exception e){
            return null;
        }
    }
    
    public Medico getMedico(int id){
        try{
            EntityManager em = Conexao.getEntityManager();
            Query q = em.createQuery("SELECT m FROM Medico m WHERE id=:id");
            q.setParameter("id", id);

            Medico medico = (Medico) q.getSingleResult();
  
            return medico;
        }catch(Exception e){
            return null;
        }
    }
}
