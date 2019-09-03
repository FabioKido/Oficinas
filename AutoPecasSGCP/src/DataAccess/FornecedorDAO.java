/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.Fornecedor;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class FornecedorDAO {
    
    private static FornecedorDAO instance;
    protected EntityManager entityManager;
    
    public static FornecedorDAO getInstance(){
        if (instance == null){
            instance = new FornecedorDAO();
        }
        return instance;
    }
    
    private FornecedorDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Fornecedor getById(final int id){
        return entityManager.find(Fornecedor.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Fornecedor> findAll(){
        return entityManager.createQuery("FROM " + Fornecedor.class.getName()+" c ORDER BY c.nome").getResultList();
    }
    
    public void persist(Fornecedor fornecedor){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(fornecedor);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Fornecedor fornecedor){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(fornecedor);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Fornecedor fornecedor){
        try{
            entityManager.getTransaction().begin();
            fornecedor = entityManager.find(Fornecedor.class, fornecedor.getCodigo());
            entityManager.remove(fornecedor);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            Fornecedor fornecedor = getById(id);
            remove(fornecedor);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}