/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.DAO.UsuarioDAO;
import com.model.Usuario;
import com.sun.faces.context.SessionMap;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
    
    public String getUsuarioLogado(){
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return usuario.getUsuario();
    }
    
    public void cadastrar(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.cadastrar(usuario);
        usuario = new Usuario();
    }
    
    public String verificaLogin(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        FacesContext contexto = FacesContext.getCurrentInstance();
        Map<String, Object> sessao = contexto.getExternalContext().getSessionMap();
        if(sessao.containsKey("usuario")){
            return null;
        }
        else if(usuario.getUsuario() == null || usuario.getSenha() == null){
            try{
                ExternalContext contextoExterno = contexto.getExternalContext();
                contextoExterno.redirect("faces/login.xhtml");
            }
            catch(IOException e){
                System.out.println("Erro: " + e.getMessage());
            }
            return null;
        }
        else if(usuarioDAO.verificaLogin(usuario)){
            sessao.put("usuario", usuario);
            return "Login_OK";
        }
        else{
            FacesMessage msg = new FacesMessage("Login incorreto");
            contexto.addMessage("form_login", msg);
            return null;
        }
    }
    
    public void deslogar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
    }

}
