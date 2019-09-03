/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.ItemVenda;
import DomainModel.Vendas;
import java.util.*;
import javax.persistence.*;

/**
 * 
 * @author kido
 */

public class ItemVendaDAO {
    
    private static ItemVendaDAO instance;
    protected EntityManager entityManager;
    
    public static ItemVendaDAO getInstance(){
        if (instance == null){
            instance = new ItemVendaDAO();
        }
        return instance;
    }
    
    private ItemVendaDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public ItemVenda getById(final int id){
        return entityManager.find(ItemVenda.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<ItemVenda> findAll(){
        return entityManager.createQuery("FROM " + ItemVenda.class.getName()+" c").getResultList();
    }
    
    public void persist(ItemVenda itemVenda){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(itemVenda);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(ItemVenda itemVenda){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(itemVenda);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(ItemVenda itemVenda){
        try{
            entityManager.getTransaction().begin();
            itemVenda = entityManager.find(ItemVenda.class, itemVenda.getCodigo());
            entityManager.remove(itemVenda);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            ItemVenda itemVenda = getById(id);
            remove(itemVenda);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

    
/*public List<ItemVenda> itensDaVenda(Vendas venda){
        Query query = entityManager.createQuery("FROM " + ItemVenda.class.getName()+" i where i.VENDAS_CODIGO = :idVenda");
        query.setParameter("idVenda", venda.getCodigo());
        return query.getResultList();
}*/