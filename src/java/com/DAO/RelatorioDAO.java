/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.util.Conexao;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mateus
 */
public class RelatorioDAO {
    public ListDataModel pesquisa(String dataInicial, String dataFinal, boolean faturamento){
        try{
            EntityManager em = Conexao.getEntityManager();
            Query q = em.createQuery("SELECT a FROM Agenda a WHERE dataHora BETWEEN \':dataIncial\' AND \':dataFinal\'");
            q.setParameter("dataInicial", dataInicial);
            q.setParameter("dataFinal", dataInicial);
            
            ListDataModel resultado = (ListDataModel) q.getResultList();
            
            return resultado;
        }catch(Exception e){
            return null;
        }
    }
}
