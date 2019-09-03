/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.Vendas;
import java.util.*;
import javax.persistence.*;

/**
 * Incompleto
 * @author kido
 */

public class VendasDAO {
    
    private static VendasDAO instance;
    protected EntityManager entityManager;
    
    public static VendasDAO getInstance(){
        if (instance == null){
            instance = new VendasDAO();
        }
        return instance;
    }
    
    private VendasDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Vendas getById(final int id){
        return entityManager.find(Vendas.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Vendas> findAll(){
        return entityManager.createQuery("FROM " + Vendas.class.getName()+" c ORDER BY c.dataDeVenda").getResultList();
    }
    
    public void persist(Vendas vendas){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(vendas);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Vendas vendas){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(vendas);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Vendas vendas){
        try{
            entityManager.getTransaction().begin();
            vendas = entityManager.find(Vendas.class, vendas.getCodigo());
            entityManager.remove(vendas);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            Vendas vendas = getById(id);
            remove(vendas);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
