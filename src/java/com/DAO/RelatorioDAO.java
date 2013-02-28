/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.control.RelatorioBean;
import com.model.Agenda;
import com.model.AgendaPK;
import com.util.Conexao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mateus
 */
public class RelatorioDAO {
    public List<Agenda> pesquisa(String dataInicial, String dataFinal, boolean faturamento){
        System.out.println("########" + dataInicial +" "+ dataFinal);
        try{
            EntityManager em = Conexao.getEntityManager();
            Query q = em.createQuery("SELECT a FROM Agenda a WHERE dataHora BETWEEN :dataInicial AND :dataFinal");
            q.setParameter("dataInicial", dataInicial);
            q.setParameter("dataFinal", dataFinal);
            
            List<Agenda> agenda = q.getResultList();
            
            return agenda;
        }catch(Exception e){
            return null;
        }
    }
}
