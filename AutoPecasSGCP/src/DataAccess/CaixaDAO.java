/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.Caixa;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class CaixaDAO {
    
    private static CaixaDAO instance;
    protected EntityManager entityManager;
    
    public static CaixaDAO getInstance(){
        if (instance == null){
            instance = new CaixaDAO();
        }
        return instance;
    }
    
    private CaixaDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Caixa getById(final int id){
        return entityManager.find(Caixa.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Caixa> findAll(){
        return entityManager.createQuery("FROM " + Caixa.class.getName()+" c").getResultList();
    }
    
    public void persist(Caixa caixa){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(caixa);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Caixa caixa){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(caixa);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Caixa caixa){
        try{
            entityManager.getTransaction().begin();
            caixa = entityManager.find(Caixa.class, caixa.getCodigo());
            entityManager.remove(caixa);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            Caixa caixa = getById(id);
            remove(caixa);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
