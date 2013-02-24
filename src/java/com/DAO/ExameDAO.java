/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.model.Exame;
import com.util.Conexao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
