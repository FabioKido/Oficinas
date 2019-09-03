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
@Table(name = "compras")

public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataDeCompra;
    
    @Column
    private int quantidade;
    
    @Column
    private Double precoTotal;
    
    @ManyToOne
    private Mercadoria mercadoria;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(Date dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Mercadoria getMercadoria() {
        return mercadoria;
    }

    public void setMercadoria(Mercadoria mercadoria) {
        this.mercadoria = mercadoria;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
}
