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
@Table(name = "pagamento")

public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Column
    private Double valorPago;
    
    @Column
    private Double valorReceber;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Crediario crediario;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(Double valorReceber) {
        this.valorReceber = valorReceber;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Crediario getCrediario() {
        return crediario;
    }

    public void setCrediario(Crediario crediario) {
        this.crediario = crediario;
    }
    
}
