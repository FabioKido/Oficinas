/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.Compra;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class CompraDAO {
    
    private static CompraDAO instance;
    protected EntityManager entityManager;
    
    public static CompraDAO getInstance(){
        if (instance == null){
            instance = new CompraDAO();
        }
        return instance;
    }
    
    private CompraDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Compra getById(final int id){
        return entityManager.find(Compra.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Compra> findAll(){
        return entityManager.createQuery("FROM" + Compra.class.getName()+" c ORDER BY c.codigo").getResultList();
    }
    
    public void persist(Compra compra){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(compra);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
