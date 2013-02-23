/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author administrador
 */
public class Conexao {
    private static EntityManager em;
    private static EntityManagerFactory emf;
    
    public static EntityManager getEntityManager(){
        try {
            if(emf == null){
                emf = Persistence.createEntityManagerFactory("SAECPU");
                em = emf.createEntityManager();
            }else{
                if (em == null) {
                    em = emf.createEntityManager();
                }
            }
            return em;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
}
