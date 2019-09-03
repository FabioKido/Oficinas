/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.ItemServico;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class ItemServicoDAO {
    
    private static ItemServicoDAO instance;
    protected EntityManager entityManager;
    
    public static ItemServicoDAO getInstance(){
        if (instance == null){
            instance = new ItemServicoDAO();
        }
        return instance;
    }
    
    private ItemServicoDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public ItemServico getById(final int id){
        return entityManager.find(ItemServico.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<ItemServico> findAll(){
        return entityManager.createQuery("FROM " + ItemServico.class.getName()+" c").getResultList();
    }
    
    public void persist(ItemServico itemServico){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(itemServico);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(ItemServico itemServico){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(itemServico);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(ItemServico itemServico){
        try{
            entityManager.getTransaction().begin();
            itemServico = entityManager.find(ItemServico.class, itemServico.getCodigo());
            entityManager.remove(itemServico);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            ItemServico itemServico = getById(id);
            remove(itemServico);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
