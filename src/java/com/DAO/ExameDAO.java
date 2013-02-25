/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.model.Exame;
import com.util.Conexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author mateus
 */
public class ExameDAO {
    public boolean cadastrar(Exame exame){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(exame);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }        
    }
    
    public boolean deletar(Exame exame){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(exame);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback(); 
            }
            return false;
        }        
    }
    
    public List<Exame> getExames(){
        try{
            EntityManager em = Conexao.getEntityManager();
            Query q = em.createQuery("SELECT e FROM Exame e");

            List<Exame> exames = q.getResultList();
  
            return exames;
        }catch(Exception e){
            return null;
        }
    }
    
    public Exame getExame(int id){
        try{
            EntityManager em = Conexao.getEntityManager();
            Query q = em.createQuery("SELECT e FROM Exame e WHERE id=:id");
            q.setParameter("id", id);

            Exame exame = (Exame) q.getSingleResult();
  
            return exame;
        }catch(Exception e){
            return null;
        }
    }
}
