/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.model.Usuario;
import com.util.Conexao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author administrador
 */
public class UsuarioDAO {
    public void cadastrar(Usuario usuario){
        EntityManager em = Conexao.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(usuario);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        }        
    }
    
    public boolean verificaLogin(Usuario usuario){
        EntityManager em = Conexao.getEntityManager();
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE usuario=:usuario AND senha=:senha");
        q.setParameter("usuario", usuario.getUsuario());
        q.setParameter("senha", usuario.getSenha());
        try {
            usuario = (Usuario) q.getSingleResult();
            return usuario != null;
        } catch (Exception e) {
        }
        return false;
    }
}
