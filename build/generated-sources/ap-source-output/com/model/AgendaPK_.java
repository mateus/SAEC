package com.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T16:52:16")
@StaticMetamodel(AgendaPK.class)
public class AgendaPK_ { 

    public static volatile SingularAttribute<AgendaPK, Integer> idPaciente;
    public static volatile SingularAttribute<AgendaPK, Integer> idExame;
    public static volatile SingularAttribute<AgendaPK, Date> dataHora;
    public static volatile SingularAttribute<AgendaPK, Integer> idMedico;

}