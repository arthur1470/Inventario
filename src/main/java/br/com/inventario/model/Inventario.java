package br.com.inventario.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "INVENTARIO")
public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_INVENTARIO")
    @GeneratedValue
    private BigInteger id;

    @Column(name = "NOME_INVENTARIO")
    private String nome;

    @Column(name = "DATA_INVENTARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDoInventario;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDoInventario() {
        return dataDoInventario;
    }

    public void setDataDoInventario(Date dataDoInventario) {
        this.dataDoInventario = dataDoInventario;
    }
}
