/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.Servicos;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class ServicosDAO {
    
    private static ServicosDAO instance;
    protected EntityManager entityManager;
    
    public static ServicosDAO getInstance(){
        if (instance == null){
            instance = new ServicosDAO();
        }
        return instance;
    }
    
    private ServicosDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Servicos getById(final int id){
        return entityManager.find(Servicos.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Servicos> findAll(){
        return entityManager.createQuery("FROM " + Servicos.class.getName()+" c").getResultList();
    }
    
    public void persist(Servicos servicos){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(servicos);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Servicos servicos){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(servicos);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Servicos servicos){
        try{
            entityManager.getTransaction().begin();
            servicos = entityManager.find(Servicos.class, servicos.getCodigo());
            entityManager.remove(servicos);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            Servicos servicos = getById(id);
            remove(servicos);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
