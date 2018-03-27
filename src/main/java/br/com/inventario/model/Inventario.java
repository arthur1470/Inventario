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
    @SequenceGenerator(name = "SEQ_ID_INVENTARIO", sequenceName = "SEQ_ID_INVENTARIO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_INVENTARIO")
    private BigInteger id;

    @Column(name = "NOME_INVENTARIO")
    private String nome;

    @Column(name = "DATA_INVENTARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDoInventario;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "INVENTARIO_PRODUTO_INSERIDO", joinColumns =
	@JoinColumn(name = "ID_INVENTARIO"), inverseJoinColumns =
	@JoinColumn(name = "ID_PRODUTO_INSERIDO"))
    private List<ProdutoInserido> produtosInseridos = new ArrayList<ProdutoInserido>();

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

    public List<ProdutoInserido> getProdutosInseridos() {
        return produtosInseridos;
    }

    public void setProdutosInseridos(List<ProdutoInserido> produtosInseridos) {
        this.produtosInseridos = produtosInseridos;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventario other = (Inventario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
