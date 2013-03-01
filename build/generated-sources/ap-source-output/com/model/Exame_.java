package com.model;

import com.model.Agenda;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T16:52:16")
@StaticMetamodel(Exame.class)
public class Exame_ { 

    public static volatile SingularAttribute<Exame, Integer> idExame;
    public static volatile SingularAttribute<Exame, Float> valor;
    public static volatile CollectionAttribute<Exame, Agenda> agendaCollection;
    public static volatile SingularAttribute<Exame, String> nome;

}