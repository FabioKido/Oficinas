/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.Pagamento;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class PagamentoDAO {
    
    private static PagamentoDAO instance;
    protected EntityManager entityManager;
    
    public static PagamentoDAO getInstance(){
        if (instance == null){
            instance = new PagamentoDAO();
        }
        return instance;
    }
    
    private PagamentoDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Pagamento getById(final int id){
        return entityManager.find(Pagamento.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Pagamento> findAll(){
        return entityManager.createQuery("FROM " + Pagamento.class.getName()+" c ORDER BY c.dataDeVenda").getResultList();
    }
    
    public void persist(Pagamento pagamento){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(pagamento);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Pagamento pagamento){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(pagamento);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Pagamento pagamento){
        try{
            entityManager.getTransaction().begin();
            pagamento = entityManager.find(Pagamento.class, pagamento.getCodigo());
            entityManager.remove(pagamento);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            Pagamento pagamento = getById(id);
            remove(pagamento);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
