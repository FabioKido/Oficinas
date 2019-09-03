/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.Parcela;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class ParcelaDAO {
    
    private static ParcelaDAO instance;
    protected EntityManager entityManager;
    
    public static ParcelaDAO getInstance(){
        if (instance == null){
            instance = new ParcelaDAO();
        }
        return instance;
    }
    
    private ParcelaDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Parcela getById(final int id){
        return entityManager.find(Parcela.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Parcela> findAll(){
        return entityManager.createQuery("FROM " + Parcela.class.getName()+" p").getResultList();
    }
    
    public void persist(Parcela parcela){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(parcela);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Parcela parcela){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(parcela);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Parcela parcela){
        try{
            entityManager.getTransaction().begin();
            parcela = entityManager.find(Parcela.class, parcela.getCodigo());
            entityManager.remove(parcela);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            Parcela parcela = getById(id);
            remove(parcela);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
