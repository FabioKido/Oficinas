/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.Cliente;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class ClienteDAO {

    private static ClienteDAO instance;
    protected EntityManager entityManager;
    
    public static ClienteDAO getInstance(){
        if (instance == null){
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    private ClienteDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Cliente getById(final int id){
        return entityManager.find(Cliente.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Cliente> findAll(){
        return entityManager.createQuery("FROM " + Cliente.class.getName()+" c ORDER BY c.nome").getResultList();
    }
    
    public void persist(Cliente cliente){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Cliente cliente){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Cliente cliente){
        try{
            entityManager.getTransaction().begin();
            cliente = entityManager.find(Cliente.class, cliente.getCodigo());
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            Cliente cliente = getById(id);
            remove(cliente);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}