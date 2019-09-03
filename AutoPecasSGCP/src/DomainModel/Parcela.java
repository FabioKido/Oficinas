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
@Table(name = "parcela")

public class Parcela {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Column
    private Double valorParcelado;
    
    @Column
    private String situacao;
    
    @Column
    private String diaUtilBom;
    
    @ManyToOne
    private Crediario crediario;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getValorParcelado() {
        return valorParcelado;
    }

    public void setValorParcelado(Double valorParcelado) {
        this.valorParcelado = valorParcelado;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDiaUtilBom() {
        return diaUtilBom;
    }

    public void setDiaUtilBom(String diaUtilBom) {
        this.diaUtilBom = diaUtilBom;
    }

    public Crediario getCrediario() {
        return crediario;
    }

    public void setCrediario(Crediario crediario) {
        this.crediario = crediario;
    }

}
