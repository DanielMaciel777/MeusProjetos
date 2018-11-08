/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Ganhos;
import br.edu.qi.model.Gastos;
import br.edu.qi.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author danie
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void persisteUsuario(Usuario u){
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(u);
        tr.commit();
        tr=null;
        ss.close();
    }
    
    public static void persisteGanhos(Ganhos gn){
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(gn);
        tr.commit();
        tr=null;
        ss.close();
    }
    public static void persisteGastos(Gastos gt){
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(gt);
        tr.commit();
        tr=null;
        ss.close();
    }
    public static List<Usuario> listarUsuarios(){
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Criteria crit = ss.createCriteria(Usuario.class);
        List<Usuario> listUsuario = (List<Usuario>)crit.list();
        return listUsuario;
    }
    public static List<Ganhos> listarGanhos(){
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Criteria crit = ss.createCriteria(Ganhos.class);
        List<Ganhos> listGanhos = (List<Ganhos>)crit.list();
        return listGanhos;
    }
    public static List<Gastos> listarGastos(){
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Criteria crit = ss.createCriteria(Gastos.class);
        List<Gastos> listGastos = (List<Gastos>)crit.list();
        return listGastos;
    }
}
