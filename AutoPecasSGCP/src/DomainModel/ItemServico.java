/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DomainModel;

import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kido
 */

@Entity
@Table(name = "item_servico")

public class ItemServico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Column
    private int quantidade;
    
    @ManyToOne
    private ServicoMecanico servicoMecanico;
    
    @ManyToOne
    private Servicos servicos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ServicoMecanico getServicoMecanico() {
        return servicoMecanico;
    }

    public void setServicoMecanico(ServicoMecanico servicoMecanico) {
        this.servicoMecanico = servicoMecanico;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }
    
}
