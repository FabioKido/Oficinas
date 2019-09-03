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
@Table(name = "caixa")

public class Caixa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Column
    private Double saldoInicial;
    
    @Column
    private Double saldoCorrente;
    
    @Column
    private Double saldoReceber;
    
    @Column
    private Double valorRetirada;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Double getSaldoCorrente() {
        return saldoCorrente;
    }

    public void setSaldoCorrente(Double saldoCorrente) {
        this.saldoCorrente = saldoCorrente;
    }

    public Double getSaldoReceber() {
        return saldoReceber;
    }

    public void setSaldoReceber(Double saldoReceber) {
        this.saldoReceber = saldoReceber;
    }

    public Double getValorRetirada() {
        return valorRetirada;
    }

    public void setValorRetirada(Double valorRetirada) {
        this.valorRetirada = valorRetirada;
    }
    
    
}
