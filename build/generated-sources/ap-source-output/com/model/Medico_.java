package com.model;

import com.model.Agenda;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T16:52:16")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, String> crm;
    public static volatile CollectionAttribute<Medico, Agenda> agendaCollection;
    public static volatile SingularAttribute<Medico, String> nome;
    public static volatile SingularAttribute<Medico, Integer> idMedico;

}