/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import DomainModel.ServicoMecanico;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

public class ServicoMecanicoDAO {
    
    private static ServicoMecanicoDAO instance;
    protected EntityManager entityManager;
    
    public static ServicoMecanicoDAO getInstance(){
        if (instance == null){
            instance = new ServicoMecanicoDAO();
        }
        return instance;
    }
    
    private ServicoMecanicoDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoPecasSGCPPU");
            if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public ServicoMecanico getById(final int id){
        return entityManager.find(ServicoMecanico.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<ServicoMecanico> findAll(){
        return entityManager.createQuery("FROM " + ServicoMecanico.class.getName()+" c ORDER BY c.descricao").getResultList();
    }
    
    public void persist(ServicoMecanico servicoMecanico){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(servicoMecanico);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(ServicoMecanico servicoMecanico){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(servicoMecanico);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(ServicoMecanico servicoMecanico){
        try{
            entityManager.getTransaction().begin();
            servicoMecanico = entityManager.find(ServicoMecanico.class, servicoMecanico.getCodigo());
            entityManager.remove(servicoMecanico);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            ServicoMecanico servicoMecanico = getById(id);
            remove(servicoMecanico);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}