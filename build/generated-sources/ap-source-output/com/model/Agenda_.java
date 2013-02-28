package com.model;

import com.model.AgendaPK;
import com.model.Exame;
import com.model.Medico;
import com.model.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-27T22:52:21")
@StaticMetamodel(Agenda.class)
public class Agenda_ { 

    public static volatile SingularAttribute<Agenda, String> obs;
    public static volatile SingularAttribute<Agenda, Paciente> paciente;
    public static volatile SingularAttribute<Agenda, Medico> medico;
    public static volatile SingularAttribute<Agenda, String> resultado;
    public static volatile SingularAttribute<Agenda, AgendaPK> agendaPK;
    public static volatile SingularAttribute<Agenda, Exame> exame;

}