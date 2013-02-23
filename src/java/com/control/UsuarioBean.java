/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.UsuarioDAO;
import com.model.Usuario;
import com.sun.faces.context.SessionMap;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.jms.Session;

/**
 *
 * @author administrador
 */
public class UsuarioBean implements Serializable{
    private Usuario usuario;

    public UsuarioBean() {
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void cadastrar(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.cadastrar(usuario);
        usuario = new Usuario();
    }
    
    public String verificaLogin(){
        FacesContext context = FacesContext.getCurrentInstance();
        SessionMap session;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(context.getExternalContext().getSessionMap().containsKey("usuario")){
            return "Login_OK";
        }else if(usuarioDAO.verificaLogin(usuario)){
            context.getExternalContext().getSessionMap().put("usuario", usuario);
            return "Login_OK";
        }else{
            return "Login_ERROR";
        }
        
    }
}
