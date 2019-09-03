/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.Crediario;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class CrediarioDAO {
    
    private static CrediarioDAO instance;
    protected EntityManager entityManager;
    
    public static CrediarioDAO getInstance(){
        if (instance == null){
            instance = new CrediarioDAO();
        }
        return instance;
    }
    
    private CrediarioDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Crediario getById(final int id){
        return entityManager.find(Crediario.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Crediario> findAll(){
        return entityManager.createQuery("FROM " + Crediario.class.getName()+" c ORDER BY c.situacao").getResultList();
    }
    
    public void persist(Crediario crediario){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(crediario);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Crediario crediario){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(crediario);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Crediario crediario){
        try{
            entityManager.getTransaction().begin();
            crediario = entityManager.find(Crediario.class, crediario.getCodigo());
            entityManager.remove(crediario);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            Crediario crediario = getById(id);
            remove(crediario);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
