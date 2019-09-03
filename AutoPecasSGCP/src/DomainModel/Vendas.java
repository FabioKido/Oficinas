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
@Table(name = "vendas")

public class Vendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataDeVenda;
    
    @Column
    private Double valorTotal;
    
    @Column
    private String situacao;

    @ManyToOne
    private Pagamento pagamento;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataDeVenda() {
        return dataDeVenda;
    }

    public void setDataDeVenda(Date dataDeVenda) {
        this.dataDeVenda = dataDeVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

}
