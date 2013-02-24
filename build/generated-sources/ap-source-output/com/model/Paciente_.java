package com.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-24T02:38:51")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Integer> id;
    public static volatile SingularAttribute<Paciente, String> bairro;
    public static volatile SingularAttribute<Paciente, String> cidade;
    public static volatile SingularAttribute<Paciente, Date> dataNasc;
    public static volatile SingularAttribute<Paciente, String> uf;
    public static volatile SingularAttribute<Paciente, String> logradouro;
    public static volatile SingularAttribute<Paciente, String> nome;
    public static volatile SingularAttribute<Paciente, String> numero;

}